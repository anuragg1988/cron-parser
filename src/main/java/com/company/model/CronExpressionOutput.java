package com.company.model;

import com.company.exception.InvalidOutPutException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CronExpressionOutput {

    private List<CronOutput> cronOutputs;

    public CronExpressionOutput(Set<IParserOutput> outPutList) {
        cronOutputs = new ArrayList<>();
        CronOutput cronOutput = new CronOutput(outPutList);
        cronOutputs.add(cronOutput);
    }

    public List<CronOutput> getCronOutputs() {
        return cronOutputs;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(CronOutput output: cronOutputs){
            string.append("\n" + output.toString());
        }
        return string.toString();
    }
}

