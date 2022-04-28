package com.company.core;

import com.company.model.IParserInput;

public class StarParser implements Parser {

    @Override
    public String parse(IParserInput input, int from, int to) {
        StringBuilder output = new StringBuilder();
        for(int i = from; i <= to;i++){
            output.append(i);
            if(i != to) output.append(", ");
        }
        return output.toString();
    }
}
