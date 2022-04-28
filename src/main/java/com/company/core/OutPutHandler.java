package com.company.core;

import com.company.model.CronExpressionOutput;
import com.company.model.OutPutTypeStrInput;
import com.company.output.IOutPutWriter;
import com.company.output.OutputWriterFactory;

public class OutPutHandler {


    public OutPutHandler() {
    }

    public void handle(CronExpressionOutput cronExpressionOutput,OutPutTypeStrInput outputType){
        OutputWriterFactory outputWriterFactory = new OutputWriterFactory();
        IOutPutWriter outputWriter = outputWriterFactory.createOutputWriter(outputType);
        outputWriter.write(cronExpressionOutput);
    }
}
