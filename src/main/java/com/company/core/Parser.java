package com.company.core;

import com.company.model.IParserInput;
import com.company.utils.CronInputExtractor;

public interface Parser {
    String parse(IParserInput input, int from, int to);
}
