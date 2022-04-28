package com.company.core;

import com.company.model.CronExpressionInput;
import com.company.utils.CommandToModelConverter;

public class ModelConvertor {

    public CronExpressionInput convertToInputModel(String[] args){
        CommandToModelConverter commandToModelConverter =  new CommandToModelConverter();
        CronExpressionInput cronExpressionInput = commandToModelConverter.convert(args);
        return cronExpressionInput;
    }
}
