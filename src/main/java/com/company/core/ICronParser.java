package com.company.core;

import com.company.exception.InvalidCronExpressionException;
import com.company.model.Constants;
import com.company.model.IParserInput;
import com.company.model.IParserOutput;
import com.company.utils.CronInputExtractor;

public abstract class ICronParser {

    protected int order = Integer.MAX_VALUE;

    public ICronParser(int order){
        this.order = order;
    }

    protected abstract IParserOutput parse(IParserInput input);

    protected String parseWithRange(IParserInput input, int from, int to){
        Parser parser = getParser(input);
        return parser.parse(input,from,to);
    }

    protected Parser getParser(IParserInput input){
        String inputStr = input.getInput();

        if(inputStr.contains(Constants.CRON_EXP_HYPHEN)) {// Should first check for / and - before checking *
            return new HyphenParser();
        }
        if(inputStr.contains(Constants.CRON_EXP_SLASH)) {
            return new SlashParser();
        }
        if(inputStr.contains(Constants.CRON_EXP_STAR)) {
            return new StarParser();
        }
        if(inputStr.contains(Constants.CRON_EXP_COMMA)) {
            return new CommaParser();
        }
        if(inputStr.contains(Constants.CRON_EXP_QUESTION_MARK)) {
            return new QuestionMarkParser();
        }
        if(CronInputExtractor.isNumeric(inputStr)) {
            return new NumberParser();
        }

        throw new InvalidCronExpressionException("Invalid cron expression provided: "+input);
    }

    public int getOrder() {
        return order;
    }
}
