package com.company.output;

import com.company.model.CronExpressionOutput;

public class FileOutPutWriter implements IOutPutWriter {

    @Override
    public void write(CronExpressionOutput cronExpressionOutput) {
        System.out.println("output");
    }
}
