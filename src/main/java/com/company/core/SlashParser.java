package com.company.core;

import com.company.model.IParserInput;
import com.company.utils.CronInputExtractor;

public class SlashParser implements Parser {
    private static final String  SEPERATOR = "/";
    @Override
    public String parse(IParserInput input, int from, int to) {
        int[] leftRightNums = CronInputExtractor.getLeftRightNumbersBySeperator(input.getInput(),SEPERATOR,from);
        StringBuilder output = new StringBuilder();
        int init = Math.max(from,leftRightNums[0]);
        int num = Math.max(from,leftRightNums[0]);
        while(num <= to){
            if(num != init) output.append(",");
            output.append(num);
            num += leftRightNums[1];
        }
        return output.toString();
    }
}
