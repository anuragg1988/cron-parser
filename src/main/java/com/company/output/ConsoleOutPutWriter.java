package com.company.output;

import com.company.model.CronExpressionOutput;
import com.company.model.CronOutput;
import com.company.model.IParserOutput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

public class ConsoleOutPutWriter implements IOutPutWriter {
    private PrintStream outputStream;

    public ConsoleOutPutWriter(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public ConsoleOutPutWriter() {
        this.outputStream = System.out;
    }

    private static final int SPACE = 14;
    private static final String DIFF_EXP_SEPERATOR = "---------------";
    @Override
    public void write(CronExpressionOutput cronExpressionOutput) {
        List<CronOutput> list = cronExpressionOutput.getCronOutputs();
        int counter = 1;// Keep track of total no of cron expression to format/output
        int noOfCronExpOutput = list.size();
        for(CronOutput cronOutput: list){
            for(IParserOutput output: cronOutput.getOutputs()){
                String name = output.getName();
                int remLength = SPACE-name.length();
                StringBuilder space = new StringBuilder();
                for(int i=0;i<remLength;i++) space.append(" ");
                String currentOutputString = output.getName() + space + output.getOutput();
                outputStream.println(currentOutputString);
            }
            if(counter < noOfCronExpOutput){
                outputStream.println(DIFF_EXP_SEPERATOR);
            }
            counter += 1;
        }
    }
}
