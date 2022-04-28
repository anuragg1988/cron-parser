package com.company.model;

public class DayOfWeekInput implements IParserInput{
    private final int ORDER = Constants.ORDER_DAY_OF_WEEK;

    private String dayOfWeek;

    public DayOfWeekInput(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getInput() {
        return dayOfWeek;
    }
}
