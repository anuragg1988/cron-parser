package com.company.model;

public class CommandOutput implements IParserOutput {
    private final int ORDER = Constants.ORDER_COMMAND;

    private String command;

    public CommandOutput(String command){
        this.command = command;
    }

    @Override
    public String getOutput() {
        return command;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getName() {
        return Constants.CRON_OUTPUT_NAME_COMMAND;
    }
}
