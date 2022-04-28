package com.company.utils;

import com.company.exception.InvalidCronExpressionException;
import com.company.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CronInputExtractor {

    private String[] inputCommands;

    public CronInputExtractor(String[] inputCommands) {
        this.inputCommands = inputCommands;
    }

    public  List<CronInput> extract(){
        String[] commands = this.inputCommands[0].split(" ");
        //cron expression core 5 fields
        MinuteInput minuteInput = new MinuteInput(commands[0]);
        HourInput hourInput = new HourInput(commands[1]);
        DayOfMonthInput dayOfMonthInput = new DayOfMonthInput(commands[2]);
        MonthInput monthInput = new MonthInput(commands[3]);
        DayOfWeekInput dayOfWeekInput = new DayOfWeekInput(commands[4]);

        List<CronInput> cronInputs = new ArrayList<>();
        // TODO support multiple cron jobs commands in one execution
        CronInput cronInput = new CronInput(minuteInput, hourInput, dayOfMonthInput, monthInput, dayOfWeekInput);
        int commandLength = commands.length;
        switch (commandLength){
            case 6: { // have input command from user
                CommandInput commandInput = new CommandInput(commands[5]);
                cronInput = new CronInput(minuteInput, hourInput, dayOfMonthInput, monthInput, dayOfWeekInput, commandInput);
                break;
            }
            case 7: {// have additional parse command from input, eg output type
                CommandInput commandInput = new CommandInput(commands[5]);
                OutPutTypeStrInput outPutType = new OutPutTypeStrInput(commands[6]);
                cronInput = new CronInput(minuteInput, hourInput, dayOfMonthInput, monthInput, dayOfWeekInput, commandInput,outPutType);
                break;
            }
            default:break;
        }
        cronInputs.add(cronInput);
        return cronInputs;
    }

    public static boolean isNumeric(String input){
        for(char c: input.toCharArray()){
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static int[] getLeftRightNumbersBySeperator(String inputString, String seperator,int from){
        String[] seperatedArray = inputString.split(seperator);
        if(seperatedArray.length != 2) throw new InvalidCronExpressionException("Invalid cron expression with : "+inputString);

        int[] result = new int[seperatedArray.length];
        int i = 0;
        if(seperatedArray[0].equals("*")){
            seperatedArray[0] = from+"";
        }
        // Check for all valid numbers and range
        for(String str: seperatedArray){
            if(!CronInputExtractor.isNumeric(str)){
                throw new InvalidCronExpressionException("Not valid number provided with comma cron expression: "+inputString);
            }
            int num = Integer.parseInt(str);;
            result[i++] = num;
        }
        return result;
    }
}
