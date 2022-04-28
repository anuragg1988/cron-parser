package com.company.validation;

import com.company.exception.InvalidParseCommandException;

import java.util.Arrays;

public class CommandValidator {

    // To validate the provided parse cron expression command
    public void validate(String[] command){
        // If command param itself is null or empty, throw exception
        if(command == null || command.length == 0){
            throw new InvalidParseCommandException("Cron expression command/param is missing or empty");
        }
        
        // Get space seperated cron expression + command params
        String[] commands = command[0].split(" ");
        
        if(commands.length < 5) {// cron expression needs minimum 5 element as specified in com.company.model.CronExpressionModel
            throw new InvalidParseCommandException("Cron expression command/param are not valid: "+ Arrays.toString(commands)+" , needs minimum 5 element as per the readme/example");        
        }
        // Validate each param seperately here
    }
}
