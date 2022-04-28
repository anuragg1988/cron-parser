package com.company.model;

public class MinuteOutput implements IParserOutput  {
    private final int ORDER = Constants.ORDER_MINUTE;
    private String minute;

    public MinuteOutput(String minutes){
        this.minute = minutes;
    }

    @Override
    public String getOutput() {
        return minute;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getName() {
        return Constants.CRON_OUTPUT_NAME_MINUTE;
    }
}
