package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        byte another1 = 2;
        short another2 = 2;
        long another3 = 3;
        double another4 = 4.2;
        boolean another5 = true;
        char another6 = 'c';
        LOG.debug("User info name : {}, age : {}, another1 : {}, another2 : {},"
                + " another3 : {}, another4 : {}, another5 : {},"
                + " another6 : {}", name, age, another1, another2, another3, another4,
                another5, another6);
    }
}