package com.company.model;

public class DayOfWeekOutput implements IParserOutput {
    private final int ORDER = Constants.ORDER_DAY_OF_WEEK;
    private String dayOfWeek;

    public DayOfWeekOutput(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String getOutput() {
        return dayOfWeek;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getName() {
        return Constants.CRON_OUTPUT_NAME_DAY_OF_WEEK;
    }
}
