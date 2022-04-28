package com.company.core;

import com.company.model.DayOfMonthOutput;
import com.company.model.HourOutput;
import com.company.model.IParserInput;
import com.company.model.IParserOutput;

public class DayOfMonthParser extends ICronParser  {

    static final int ORDER = 3;

    public DayOfMonthParser() {
        super(ORDER);
    }

    @Override
    public DayOfMonthOutput parse(IParserInput input) {
        String outPut = parseWithRange(input,1,31);
        return new DayOfMonthOutput(outPut);
    }
}
