package integration.com.company.clients;

import com.company.clients.CommandLineClient;
import com.company.clients.TestUtils;
import com.company.output.ConsoleOutPutWriter;
import com.company.output.OutputWriterFactory;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

/*
Integration test for clients/user to check/test end to end flow, Not using any mocks here
 */
public class CommandLineClientIntTest {


    @Test
    public void shouldParseAllValidCronExpression(){
        String cronExpressionNormal = "5 6 8 1 6";
        String cronExpressionWithRange = "1-5 6 8 1 6";
        String cronExpressionOutRangeFrom = "3-4 6 8 1 0-4";
        String cronExpressionOutRangeTo = "58-64 6 8 1 6";
        String cronExpressionWithComma = "1,5 6 8 1 6";
        String cronExpressionNormalWithCommand = "5 6 8 1 6 usr/bin";
        String cronExpressionHyphen = "1-5 2-6 1-8 1-5 1-6 usr/bin";
        String cronExpressionSlash = "0/15 2-6 1-8 1-5 1-6 usr/bin";
        String cronExpressionSlashStar = "*/15 2-6 1-8 1-5 1-6 usr/bin";
        String cronExpressionAllSlash = "*/15 2/6 1/10 3/4 2/3 usr/bin";
        String cronExpressionAllCombination = "1/5 6-10 8,10 1 6 usr/bin";
        ArrayList<String> expressions = new ArrayList<>();
        expressions.add(cronExpressionNormal);
        expressions.add(cronExpressionWithRange);
        expressions.add(cronExpressionOutRangeFrom);
        expressions.add(cronExpressionOutRangeTo);
        expressions.add(cronExpressionWithComma);
        expressions.add(cronExpressionNormalWithCommand);
        expressions.add(cronExpressionHyphen);
        expressions.add(cronExpressionSlash);
        expressions.add(cronExpressionSlashStar);
        expressions.add(cronExpressionAllSlash);
        expressions.add(cronExpressionAllCombination);

        int success = 0;

        for(String exp: expressions){
            boolean shouldTrue = shouldParseValidCronExpression(exp);
            assertTrue(shouldTrue);
            success += 1;
        }
        assertEquals(expressions.size(),success);
    }

    public boolean shouldParseValidCronExpression(String expression){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        ConsoleOutPutWriter consoleOutPutWriter = new ConsoleOutPutWriter(outputStream);
        OutputWriterFactory outputWriterFactory = OutputWriterFactory.withCustomOutputWriter(consoleOutPutWriter);
        CommandLineClient commandLineClient = CommandLineClient.commandLineClientWithOutputWriterFactory(outputWriterFactory);

        String cronExpression = expression;
        String[] args = new String[]{cronExpression};
        String expected = TestUtils.createExpectedCron(cronExpression)+"\n"; // Not sure why byteArrayOutputStream appends extra \n. So for now we need to add this

        commandLineClient.parse(args);
        String actual = byteArrayOutputStream.toString();
        System.out.println(actual);

        return expected.equals(actual);
    }
}