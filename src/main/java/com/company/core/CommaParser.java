package com.company.core;

import com.company.model.IParserInput;
import com.company.utils.CronInputExtractor;

public class CommaParser extends RangeParser {
    private static final String  SEPERATOR = ",";

    @Override
    public String parse(IParserInput input, int from, int to) {
        return getFromToRange(input.getInput(),SEPERATOR,from,to);
    }
}
