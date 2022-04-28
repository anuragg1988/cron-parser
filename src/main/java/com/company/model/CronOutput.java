package com.company.model;

import com.company.exception.InvalidOutPutException;

import java.util.List;
import java.util.Set;

public class CronOutput {
    private Set<IParserOutput> outputs;

    public CronOutput(Set<IParserOutput> outPutList) {
        this.outputs = outPutList;
    }

    public Set<IParserOutput> getOutputs() {
        return outputs;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(IParserOutput output: outputs){
            string.append(output.getName()+"->"+output.getOutput());
        }
        return string.toString();
    }
}
