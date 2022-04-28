package com.company.model;

public class MinuteInput implements IParserInput {
    private final int ORDER = Constants.ORDER_MINUTE;

    private String minute;

    public MinuteInput(String minutes){
        this.minute = minutes;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getInput() {
        return minute;
    }
}
