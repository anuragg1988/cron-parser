package com.company.core;

import com.company.model.IParserInput;
import com.company.utils.CronInputExtractor;

public abstract class RangeParser implements Parser {

    protected  String  getFromToRange(String input,String seperator, int fromLimit, int toLimit){
        int[] leftRightNums = CronInputExtractor.getLeftRightNumbersBySeperator(input,seperator,fromLimit);
        int[] range = new int[2];
        range[0] = Math.max(leftRightNums[0],fromLimit);
        range[1] = Math.min(leftRightNums[1],toLimit);
        StringBuilder output = new StringBuilder();
        for(int i = range[0]; i <= range[1];i++){
            output.append(i);
            if(i != range[1]) output.append(", ");
        }
        return output.toString();
    }
}
