package com.company.model;

public class OutPutTypeStrInput implements IParserInput {
    private final int ORDER = Constants.ORDER_OUTPUT_TYPE;

    private String outPutType;

    public OutPutTypeStrInput(String outPutType) {
        this.outPutType = outPutType;
    }

    public String getOutputType() {
        return outPutType;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    public String getInput() {
        return outPutType;
    }
}
