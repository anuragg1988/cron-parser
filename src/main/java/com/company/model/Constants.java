package com.company.model;

public class Constants {
    public static final String INVALID_PARSER_COMMAND_ERROR_MESSAGE = "Invalid parser command input provided";

    // Cron expression order for comparator
    public static final int ORDER_MINUTE = 1;
    public static final int ORDER_HOUR = 2;
    public static final int ORDER_DAY_OF_MONTH = 3;
    public static final int ORDER_MONTH = 4;
    public static final int ORDER_DAY_OF_WEEK = 5;
    public static final int ORDER_COMMAND = 6;
    public static final int ORDER_OUTPUT_TYPE = 7;

    // cron expression identifier
    public static final String CRON_EXP_STAR = "*";
    public static final String CRON_EXP_HYPHEN = "-";
    public static final String CRON_EXP_SLASH = "/";
    public static final String CRON_EXP_COMMA = ",";
    public static final String CRON_EXP_QUESTION_MARK = "?";

    //Output cron names
    public static final String CRON_OUTPUT_NAME_MINUTE = "minute";
    public static final String CRON_OUTPUT_NAME_HOUR = "hour";
    public static final String CRON_OUTPUT_NAME_DAY_OF_MONTH = "day of month";
    public static final String CRON_OUTPUT_NAME_MONTH = "month";
    public static final String CRON_OUTPUT_NAME_DAY_OF_WEEK = "day of week";
    public static final String CRON_OUTPUT_NAME_COMMAND = "command";

    // Defaults
    public static final String DEFAULT_OUTPUT_TYPE = "console";

}
