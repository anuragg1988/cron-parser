package com.company.core;

import com.company.model.*;
import com.company.output.IOutPutWriter;
import com.company.output.OutputWriterFactory;
import com.company.utils.CronOrderComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CoreCronParser {

    private ParserFactory parserFactory;

    public CoreCronParser(ParserFactory parserFactory) {
        this.parserFactory = parserFactory;
    }

    public CoreCronParser() {
        this.parserFactory = new ParserFactory();
    }

    public CronExpressionOutput parse(CronExpressionInput cronExpressionInput){
        List<CronInput> inputList = cronExpressionInput.getCronInputs();
        Set<IParserOutput> outPutList = new TreeSet<>(CronOrderComparator.outputParserComparator);
        for(CronInput input: inputList){// Can have multiple cron expression commands
            for(IParserInput parserInput: input.getInputs()){
                ICronParser parser = this.parserFactory.getParser(parserInput);
                IParserOutput outPut = parser.parse(parserInput);
                outPutList.add(outPut);
            }
        }
        return new CronExpressionOutput(outPutList);
    }
}
