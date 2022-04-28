package com.company.utils;

import com.company.model.CronInput;
import com.company.model.IParserInput;
import com.company.model.IParserOutput;

import java.util.Comparator;
import java.util.Set;

public class CronOrderComparator {

    public static Comparator<IParserInput> inputParserComparator = new Comparator<IParserInput>() {
        @Override
        public int compare(IParserInput input1, IParserInput input2) {
            return input1.getOrder() - input2.getOrder();
        }
    };

    public static Comparator<IParserOutput> outputParserComparator = new Comparator<IParserOutput>() {
        @Override
        public int compare(IParserOutput output1, IParserOutput output2) {
            return output1.getOrder() - output2.getOrder();
        }
    };
}
