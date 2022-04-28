package com.company.utils;

import com.company.model.*;
import com.company.validation.CommandValidator;

import java.util.List;
import java.util.Set;

public class CommandToModelConverter {

    public CronExpressionInput convert(String[] inputCommands){
        // Validate provided command first
        CommandValidator commandValidator = new CommandValidator();
        commandValidator.validate(inputCommands);

        CronInputExtractor cronInputExtractor = new CronInputExtractor(inputCommands);
        List<CronInput> cronInputs = cronInputExtractor.extract();

        CronExpressionInput cronExpressionInput = new CronExpressionInput(cronInputs);
        return cronExpressionInput;
    }
}
