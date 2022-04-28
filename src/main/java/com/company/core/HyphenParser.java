package com.company.core;

import com.company.model.IParserInput;

public class HyphenParser extends RangeParser {
    private static final String  SEPERATOR = "-";

    @Override
    public String parse(IParserInput input, int from, int to) {
        return getFromToRange(input.getInput(),SEPERATOR,from,to);
    }
}
