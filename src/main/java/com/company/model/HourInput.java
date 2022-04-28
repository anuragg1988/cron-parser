package com.company.model;

public class HourInput implements IParserInput {
    private final int ORDER = Constants.ORDER_HOUR;

    private String hour;

    public HourInput(String hour){
        this.hour = hour;
    }

    public String getHour() {
        return hour;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getInput() {
        return hour;
    }
}
