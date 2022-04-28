package com.company.clients;

import com.company.core.CoreCronParser;
import com.company.core.ModelConvertor;
import com.company.exception.InvalidParseCommandException;
import com.company.model.CronExpressionInput;
import com.company.model.CronExpressionOutput;
import com.company.model.OutPutTypeStrInput;
import com.company.output.IOutPutWriter;
import com.company.output.OutputWriterFactory;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CommandLineClientTest {

    @Mock
    private ModelConvertor modelConvertorMock;
    @Mock
    private CoreCronParser coreCronParserMock;
    @Mock
    private CronExpressionInput cronExpressionInputMock;
    @Mock
    private CronExpressionOutput cronExpressionOutputMock;
    @Mock
    private OutputWriterFactory outputWriterFactoryMock;
    @Mock
    private IOutPutWriter iOutPutWriterMock;
    @Mock
    private OutPutTypeStrInput outPutTypeStrInputMock;

    @Before
    public void setup() {
        //if we don't call below, we will get NullPointerException
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldParseValidCronExpression(){
        String cronExpression = "5 16 8 5 1 usr/bin";
        String[] args = new String[]{cronExpression};

        //Stub the external calls
        doReturn(cronExpressionInputMock).when(modelConvertorMock).convertToInputModel(args);
        doReturn(outPutTypeStrInputMock).when(cronExpressionInputMock).getOutputType();
        doReturn(cronExpressionOutputMock).when(coreCronParserMock).parse(cronExpressionInputMock);
        doReturn(iOutPutWriterMock).when(outputWriterFactoryMock).createOutputWriter(outPutTypeStrInputMock);
        doNothing().when(iOutPutWriterMock).write(cronExpressionOutputMock);

        CommandLineClient commandLineClient = new CommandLineClient(modelConvertorMock, coreCronParserMock, outputWriterFactoryMock);
        commandLineClient.parse(args);

        verify(modelConvertorMock, times(1)).convertToInputModel(args);
        verify(cronExpressionInputMock, times(1)).getOutputType();
        verify(coreCronParserMock, times(1)).parse(cronExpressionInputMock);
        verify(outputWriterFactoryMock, times(1)).createOutputWriter(outPutTypeStrInputMock);
        verify(iOutPutWriterMock, times(1)).write(cronExpressionOutputMock);
    }

    @Test
    public void shouldThrowProperExceptionWhileParsingEmptyCronExpression(){
        String cronExpression = "";
        String[] args = new String[]{cronExpression};

        CommandLineClient commandLineClient = new CommandLineClient();
        assertThrows(InvalidParseCommandException.class, () -> {
            commandLineClient.parse(args);
        });
    }

    @Test
    public void shouldThrowProperExceptionWhileParsingInvalidCronExpression(){
        String cronExpression = "abcd";
        String[] args = new String[]{cronExpression};
        CommandLineClient commandLineClient = new CommandLineClient();
        assertThrows(InvalidParseCommandException.class, () -> {
            commandLineClient.parse(args);
        });
    }
}