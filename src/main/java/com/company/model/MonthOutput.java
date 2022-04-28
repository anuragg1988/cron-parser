package com.company.model;

public class MonthOutput implements IParserOutput  {
    private final int ORDER = Constants.ORDER_MONTH;
    private String month;

    public MonthOutput(String month) {
        this.month = month;
    }

    @Override
    public String getOutput() {
        return month;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getName() {
        return Constants.CRON_OUTPUT_NAME_MONTH;
    }
}
