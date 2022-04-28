package com.company.core;

import com.company.model.*;

public class DayOfWeekParser extends ICronParser  {

    static final int ORDER = 5;

    public DayOfWeekParser() {
        super(ORDER);
    }

    @Override
    public DayOfWeekOutput parse(IParserInput input) {
        String outPut = parseWithRange(input,1,7);
        return new DayOfWeekOutput(outPut);
    }
}
