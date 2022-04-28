package com.company.core;

import com.company.exception.InvalidCronExpressionException;
import com.company.model.IParserInput;
import com.company.utils.CronInputExtractor;

public class NumberParser implements Parser {

    @Override
    public String parse(IParserInput input, int from, int to) {
        String inputStr = input.getInput();
        if(!CronInputExtractor.isNumeric(inputStr)){
            throw new InvalidCronExpressionException("Invalid number provided for parsing cron expression: "+inputStr);
        }
        int num = Integer.parseInt(inputStr);
        if(num < from || num > to){
            throw new InvalidCronExpressionException("Invalid number range provided for parsing cron expression: "+inputStr);
        }
        return input.getInput();
    }
}
