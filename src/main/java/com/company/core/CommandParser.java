package com.company.core;

import com.company.model.CommandOutput;
import com.company.model.HourOutput;
import com.company.model.IParserInput;
import com.company.model.IParserOutput;

public class CommandParser extends ICronParser{

    static final int ORDER = 6;

    public CommandParser() {
        super(ORDER);
    }

    @Override
    public CommandOutput parse(IParserInput input) {
        return new CommandOutput(input.getInput());
    }
}
