package com.company.model;

import com.company.utils.CronOrderComparator;

import java.util.Set;
import java.util.TreeSet;

public class CronInput {

    private Set<IParserInput> inputs = new TreeSet<>(CronOrderComparator.inputParserComparator);
    private OutPutTypeStrInput outputType;

    public CronInput(MinuteInput minuteInput, HourInput hourInput, DayOfMonthInput dayOfMonthInput, MonthInput monthInput, DayOfWeekInput dayOfWeekInput) {
        this.inputs.add(minuteInput);
        this.inputs.add(hourInput);
        this.inputs.add(dayOfMonthInput);
        this.inputs.add(monthInput);
        this.inputs.add(dayOfWeekInput);
        this.outputType = new OutPutTypeStrInput(Constants.DEFAULT_OUTPUT_TYPE);
    }

    public CronInput(MinuteInput minuteInput, HourInput hourInput, DayOfMonthInput dayOfMonthInput, MonthInput monthInput, DayOfWeekInput dayOfWeekInput, CommandInput commandInput) {
        this.inputs.add(minuteInput);
        this.inputs.add(hourInput);
        this.inputs.add(dayOfMonthInput);
        this.inputs.add(monthInput);
        this.inputs.add(dayOfWeekInput);
        this.inputs.add(commandInput);
        this.outputType = new OutPutTypeStrInput(Constants.DEFAULT_OUTPUT_TYPE);
    }

    public CronInput(MinuteInput minuteInput, HourInput hourInput, DayOfMonthInput dayOfMonthInput, MonthInput monthInput, DayOfWeekInput dayOfWeekInput, CommandInput commandInput, OutPutTypeStrInput outPutType) {
        this.inputs.add(minuteInput);
        this.inputs.add(hourInput);
        this.inputs.add(dayOfMonthInput);
        this.inputs.add(monthInput);
        this.inputs.add(dayOfWeekInput);
        this.inputs.add(commandInput);
        this.outputType = outPutType;
    }

    public Set<IParserInput> getInputs() {
        return inputs;
    }

    public OutPutTypeStrInput getOutputType() {
        return outputType;
    }
}
