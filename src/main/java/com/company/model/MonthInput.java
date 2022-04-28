package com.company.model;

public class MonthInput implements IParserInput {
    private final int ORDER = Constants.ORDER_MONTH;

    private String month;

    public MonthInput(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getInput() {
        return month;
    }
}
