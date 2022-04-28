package com.company.core;

import com.company.exception.InvalidParseCommandException;
import com.company.model.*;

public class ParserFactory {

    private MinuteParser minuteParser;
    private HourParser hourParser;
    private DayOfMonthParser dayOfMonthParser;
    private MonthParser monthParser;
    private DayOfWeekParser dayOfWeekParser;
    private CommandParser commandParser;

    public ParserFactory() {
        this.minuteParser = new MinuteParser();
        this.hourParser = new HourParser();
        this.dayOfMonthParser = new DayOfMonthParser();
        this.monthParser = new MonthParser();
        this.dayOfWeekParser = new DayOfWeekParser();
        this.commandParser = new CommandParser();
    }

    public ParserFactory(MinuteParser minuteParser, HourParser hourParser, DayOfMonthParser dayOfMonthParser, MonthParser monthParser, DayOfWeekParser dayOfWeekParser, CommandParser commandParser) {
        this.minuteParser = minuteParser;
        this.hourParser = hourParser;
        this.dayOfMonthParser = dayOfMonthParser;
        this.monthParser = monthParser;
        this.dayOfWeekParser = dayOfWeekParser;
        this.commandParser = commandParser;
    }

    public ICronParser getParser(IParserInput input) {
        if(input == null) throw new InvalidParseCommandException(Constants.INVALID_PARSER_COMMAND_ERROR_MESSAGE);
        if(input instanceof MinuteInput) return this.minuteParser;
        if(input instanceof HourInput) return this.hourParser;
        if(input instanceof DayOfMonthInput) return this.dayOfMonthParser;
        if(input instanceof MonthInput) return this.monthParser;
        if(input instanceof DayOfWeekInput) return this.dayOfWeekParser;
        if(input instanceof CommandInput) return this.commandParser;

        throw new InvalidParseCommandException(Constants.INVALID_PARSER_COMMAND_ERROR_MESSAGE);
    }
}
