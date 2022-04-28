package com.company.model;

public class CronExpressionRequest {
    /*cron expression core 5 fields*/
    private String minutes;
    private String hours;
    private String dayOfMonth;
    private String month;
    private String dayOfWeek;

    /*additional optional fields for parse command*/
    private String outPutType;
}
