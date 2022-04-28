package com.company.model;

public class DayOfMonthInput implements IParserInput {
    private final int ORDER = Constants.ORDER_DAY_OF_MONTH;

    private String dayOfMonth;

    public DayOfMonthInput(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getInput() {
        return dayOfMonth;
    }
}
