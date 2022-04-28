package com.company.model;

import com.company.utils.CronOrderComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CronExpressionInput {

    private List<CronInput> cronInputs;

    public CronExpressionInput(List<CronInput> cronInputs) {
        this.cronInputs = cronInputs;
    }
    public List<CronInput> getCronInputs() {
        return cronInputs;
    }

    public OutPutTypeStrInput getOutputType() {
        if(cronInputs.size() == 0) return new OutPutTypeStrInput(Constants.DEFAULT_OUTPUT_TYPE);
        // Currently only supporting one output/writer type, not diff for multiple commands
        return cronInputs.get(0).getOutputType();
    }
}

