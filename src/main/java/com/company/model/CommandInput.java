package com.company.model;

public class CommandInput implements IParserInput {
    private final int ORDER = Constants.ORDER_COMMAND;

    private String command;


    public CommandInput(String command){
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getInput() {
        return command;
    }
}
