package com.company.output;

public enum OutputType {

    CONSOLE("console"),
    FILE("file"),
    CUSTOM("custom");

    private String type;
    OutputType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
}
