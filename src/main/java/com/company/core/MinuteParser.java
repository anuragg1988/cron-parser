package com.company.core;

import com.company.model.HourOutput;
import com.company.model.IParserInput;
import com.company.model.IParserOutput;
import com.company.model.MinuteOutput;

public class MinuteParser extends ICronParser {
    static final int ORDER = 1;

    public MinuteParser() {
        super(ORDER);
    }

    @Override
    public MinuteOutput parse(IParserInput input) {
        String outPut = parseWithRange(input,0,59);
        return new MinuteOutput(outPut);
    }
}
