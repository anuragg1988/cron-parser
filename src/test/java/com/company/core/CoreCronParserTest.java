package com.company.core;

import com.company.clients.TestUtils;
import com.company.exception.InvalidCronExpressionException;
import com.company.model.CronExpressionInput;
import com.company.model.CronExpressionOutput;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class CoreCronParserTest {


    @Mock
    private ParserFactory parserFactory;

    @Before
    public void setup() {
        //if we don't call below, we will get NullPointerException
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldSuccesfullyParseValidInRangeCronExpression(){
        String cronExpression = "5 3 8 5 1 usr/bin";

        //Create expected output
        String expectedOutput = TestUtils.createExpectedCron(cronExpression);
        String[] args = new String[]{cronExpression};

        ModelConvertor modelConvertor = new ModelConvertor();
        CronExpressionInput cronExpressionInput  = modelConvertor.convertToInputModel(args);

        CoreCronParser cronParser = new CoreCronParser();
        CronExpressionOutput cronExpressionOutput = cronParser.parse(cronExpressionInput);
        String actualOutput = TestUtils.getOutPut(cronExpressionOutput);
        assertEquals("CoreCronParser did not parsed the cron expression: "+ cronExpression + " correctly.", expectedOutput, actualOutput);
    }

    @Test // Test Max Range 5-16 for month
    public void shouldSuccesfullyParseValidOutMaxRangeCronExpression(){
        String cronExpression = "5 3 8 5-16 1 usr/bin";

        //Create expected output
        String expectedOutput = TestUtils.createExpectedCron(cronExpression);
        String[] args = new String[]{cronExpression};

        ModelConvertor modelConvertor = new ModelConvertor();
        CronExpressionInput cronExpressionInput  = modelConvertor.convertToInputModel(args);

        CoreCronParser cronParser = new CoreCronParser();
        CronExpressionOutput cronExpressionOutput = cronParser.parse(cronExpressionInput);
        String actualOutput = TestUtils.getOutPut(cronExpressionOutput);
        assertEquals("CoreCronParser did not parsed the cron expression: "+ cronExpression + " correctly.", expectedOutput, actualOutput);
    }

    // @Test //TODO Support Test Min Range negative number ?
    public void shouldSuccesfullyParseValidOutMinRangeCronExpression(){
        String cronExpression = "5 3 8 -5-16 1 usr/bin";

        //Create expected output
        String expectedOutput = TestUtils.createExpectedCron(cronExpression);
        String[] args = new String[]{cronExpression};

        ModelConvertor modelConvertor = new ModelConvertor();
        CronExpressionInput cronExpressionInput  = modelConvertor.convertToInputModel(args);

        CoreCronParser cronParser = new CoreCronParser();
        CronExpressionOutput cronExpressionOutput = cronParser.parse(cronExpressionInput);
        String actualOutput = TestUtils.getOutPut(cronExpressionOutput);
        assertEquals("CoreCronParser did not parsed the cron expression: "+ cronExpression + " correctly.", expectedOutput, actualOutput);
    }

    @Test
    public void shouldThrowProperExceptionWhileParsingInValidCronExpression(){
        String cronExpression = "5 30 8 500 1 usr/bin";
        String[] args = new String[]{cronExpression};

        ModelConvertor modelConvertor = new ModelConvertor();
        CronExpressionInput cronExpressionInput  = modelConvertor.convertToInputModel(args);

        CoreCronParser cronParser = new CoreCronParser();

        assertThrows(InvalidCronExpressionException.class, () -> {
            cronParser.parse(cronExpressionInput);
        });
    }
}