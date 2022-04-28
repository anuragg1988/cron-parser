package com.company.core;

import com.company.model.*;

public class MonthParser extends ICronParser  {

    static final int ORDER = 4;

    public MonthParser() {
        super(ORDER);
    }

    @Override
    public MonthOutput parse(IParserInput input) {
        String outPut = parseWithRange(input,1,12);
        return new MonthOutput(outPut);
    }
}
