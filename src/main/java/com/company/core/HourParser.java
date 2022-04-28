package com.company.core;

import com.company.model.HourOutput;
import com.company.model.IParserInput;
import com.company.model.MinuteOutput;

public class HourParser extends ICronParser {

    static final int ORDER = 2;

    public HourParser() {
        super(ORDER);
    }

    @Override
    public HourOutput parse(IParserInput input) {
        String outPut = parseWithRange(input,0,23);
        return new HourOutput(outPut);
    }
}
