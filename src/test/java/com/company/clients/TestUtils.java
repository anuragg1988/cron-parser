package com.company.clients;

import com.company.model.*;
import com.company.utils.CronOrderComparator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestUtils {


    public static String createExpectedCron(String cronExpression){
        String[] params = cronExpression.split(" ");
        String minute = params[0];
        String hour = params[1];
        String dayOfMonth = params[2];
        String month = params[3];
        String dayOfWeek = params[4];
        String command = params.length > 5 ? params[5]:null;
        String outputType = params.length > 6 ? params[6]:null;

        Set<IParserOutput> parserOutput = new TreeSet<>(CronOrderComparator.outputParserComparator);


        if(minute != null) {
            parserOutput.add(new MinuteOutput(convertIfNeeded(minute,0,59)));
        }
        if(hour != null) parserOutput.add(new HourOutput(convertIfNeeded(hour,0,23)));
        if(dayOfMonth != null) parserOutput.add(new DayOfMonthOutput(convertIfNeeded(dayOfMonth,1,31)));
        if(month != null) parserOutput.add(new MonthOutput(convertIfNeeded(month,1,12)));
        if(dayOfWeek != null) parserOutput.add(new DayOfWeekOutput(convertIfNeeded(dayOfWeek,1,7)));
        if(command != null) parserOutput.add(new CommandOutput(command));
        if(outputType != null) parserOutput.add(new OutPutTypeStrOutput(outputType));

        CronExpressionOutput cronExpressionOutput = new CronExpressionOutput(parserOutput);
        String result = getOutPut(cronExpressionOutput);

        return result;
    }

    private static String convertIfNeeded(String str, int from, int to){
        StringBuilder builder = new StringBuilder();

        if(str.contains(",")){//Have comma expression
            String[] leftRight = str.split(",");
            if(leftRight.length == 1) return str;
            int left = Math.max(from,Integer.parseInt(leftRight[0]));
            int right = Math.min(to,Integer.parseInt(leftRight[1]));
            for(int n = left; n <= right; n++){
                builder.append(n);
                if(n != right) builder.append(", ");
            }
            return builder.toString();
        }
        else if(str.contains("-")){//Have range expression
            String[] leftRight = str.split("-");
            if(leftRight.length == 1) return str;
            int left = Math.max(from,Integer.parseInt(leftRight[0]));
            int right = Math.min(to,Integer.parseInt(leftRight[1]));
            for(int n = left; n <= right; n++){
                builder.append(n);
                if(n != right) builder.append(", ");
            }
            return builder.toString();
        }
        else if(str.contains("/")){// Have slash expression
            String[] leftRight = str.split("/");
            if(leftRight.length == 1) return str;
            if(leftRight[0].equals("*")){
                leftRight[0] = "0";
            }
            int leftNum = Integer.parseInt(leftRight[0]);
            int rightNum = Integer.parseInt(leftRight[1]);
            int num = Math.max(from,leftNum);
            while(num <= to){
                if(num != leftNum) builder.append(",");
                builder.append(num);
                num += rightNum;
            }
            return builder.toString();
        }
        return str;

    }

    public static String getOutPut(CronExpressionOutput cronExpressionOutput){
        StringBuilder result = new StringBuilder();
        List<CronOutput> list = cronExpressionOutput.getCronOutputs();
        int totalOutputcounter = 1;
        int noOfCronExpOutput = list.size();

        for(CronOutput cronOutput: list){
            int lineCounterSameExpr = 1;
            for(IParserOutput output: cronOutput.getOutputs()){
                String name = output.getName();
                int remLength = 14-name.length();
                StringBuilder space = new StringBuilder();
                for(int i=0;i<remLength;i++) space.append(" ");
                String currentOutputString = output.getName() + space + output.getOutput();
                if(lineCounterSameExpr != 1) result.append("\n");
                result.append(currentOutputString);
                lineCounterSameExpr += 1;
            }
            if(totalOutputcounter < noOfCronExpOutput){
                result.append("\n");
            }
            totalOutputcounter += 1;
        }

        return result.toString();
    }
}
