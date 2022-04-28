package com.company.model;

public class HourOutput implements IParserOutput {
    private final int ORDER = Constants.ORDER_HOUR;
    private String hour;

    public HourOutput(String hour){
        this.hour = hour;
    }

    @Override
    public String getOutput() {
        return hour;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getName() {
        return Constants.CRON_OUTPUT_NAME_HOUR;
    }
}
