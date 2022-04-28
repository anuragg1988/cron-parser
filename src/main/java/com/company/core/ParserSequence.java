package com.company.core;

import com.company.exception.InvalidParserOrderException;

import java.util.*;

public class ParserSequence {
    
    public List<ICronParser> getParserList(){
        MinuteParser minuteParser = new MinuteParser();
        HourParser hourParser = new HourParser();
        DayOfMonthParser dayOfMonthParser = new DayOfMonthParser();
        MonthParser monthParser = new MonthParser();
        DayOfWeekParser dayOfWeekParser = new DayOfWeekParser();
        CommandParser commandParser = new CommandParser();

        List<ICronParser> list = new ArrayList<>();
        list.add(minuteParser);
        list.add(hourParser);
        list.add(dayOfMonthParser);
        list.add(monthParser);
        list.add(dayOfWeekParser);
        list.add(commandParser);
        Collections.sort(list, (Comparator.comparingInt(a -> a.order)));

        Set<Integer> uniqueOrders = new HashSet<>();
        StringBuilder errorMessage = new StringBuilder();
        for(ICronParser parser: list){
            uniqueOrders.add(parser.getOrder());
            errorMessage.append(parser.order);
        }

        if(uniqueOrders.size() < list.size()){
            throw new InvalidParserOrderException("Invalid ORDER of all parser: "+errorMessage+"  , please correct the order");
        }
        return list;
    }
}
