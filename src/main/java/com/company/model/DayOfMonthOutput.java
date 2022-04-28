package com.company.model;

public class DayOfMonthOutput implements IParserOutput  {
    private final int ORDER = Constants.ORDER_DAY_OF_MONTH;
    private String dayOfMonth;

    public DayOfMonthOutput(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Override
    public String getOutput() {
        return dayOfMonth;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getName() {
        return Constants.CRON_OUTPUT_NAME_DAY_OF_MONTH;
    }
}
