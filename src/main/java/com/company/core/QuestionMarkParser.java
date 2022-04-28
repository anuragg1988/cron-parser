package com.company.core;

import com.company.model.IParserInput;

public class QuestionMarkParser implements Parser {

    @Override
    public String parse(IParserInput input, int from, int to) {
        return "any";
    }
}
