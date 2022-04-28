package com.company.output;

import com.company.model.CronExpressionOutput;

public interface IOutPutWriter {
    void write(CronExpressionOutput cronExpressionOutput);
}
