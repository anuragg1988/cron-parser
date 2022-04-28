package com.company.model;

public class OutPutTypeStrOutput implements IParserOutput  {
    private final int ORDER = Constants.ORDER_OUTPUT_TYPE;
    private String outPutType;

    public OutPutTypeStrOutput(String outPutType) {
        this.outPutType = outPutType;
    }

    @Override
    public String getOutput() {
        return outPutType;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getName() {
        return "";
    }
}
