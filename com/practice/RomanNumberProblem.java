package com.practice;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberProblem {

    static Map<String, Integer> ROMAN_NUMBER = new HashMap<>();

    public static void main(String[] args) {

        ROMAN_NUMBER = new HashMap<>();
        ROMAN_NUMBER.put("I", 1);
        ROMAN_NUMBER.put("V", 5);
        ROMAN_NUMBER.put("X", 10);

        String inputStr = "I";
        Integer expected = 1;
        System.out.printf("Roman:%s, Expected:%d, Value:%d\n", inputStr, expected, toInt(inputStr));

        inputStr = "II";
        expected = 2;
        System.out.printf("Roman:%s, Expected:%d, Value:%d\n", inputStr, expected, toInt(inputStr));

        inputStr = "III";
        expected = 3;
        System.out.printf("Roman:%s, Expected:%d, Value:%d\n", inputStr, expected, toInt(inputStr));

        inputStr = "IV";
        expected = 4;
        System.out.printf("Roman:%s, Expected:%d, Value:%d\n", inputStr, expected, toInt(inputStr));

        inputStr = "V";
        expected = 5;
        System.out.printf("Roman:%s, Expected:%d, Value:%d\n", inputStr, expected, toInt(inputStr));

        inputStr = "VI";
        expected = 6;
        System.out.printf("Roman:%s, Expected:%d, Value:%d\n", inputStr, expected, toInt(inputStr));

        inputStr = "VII";
        expected = 7;
        System.out.printf("Roman:%s, Expected:%d, Value:%d\n", inputStr, expected, toInt(inputStr));

        inputStr = "VIII";
        expected = 7;
        System.out.printf("Roman:%s, Expected:%d, Value:%d\n", inputStr, expected, toInt(inputStr));

        inputStr = "IX";
        expected = 9;
        System.out.printf("Roman:%s, Expected:%d, Value:%d\n", inputStr, expected, toInt(inputStr));

        inputStr = "XXI";
        expected = 21;
        System.out.printf("Roman:%s, Expected:%d, Value:%d\n", inputStr, expected, toInt(inputStr));

        inputStr = "XXIV";
        expected = 24;
        System.out.printf("Roman:%s, Expected:%d, Value:%d\n", inputStr, expected, toInt(inputStr));

    }

    static Integer toInt(String str) {

        Integer ans = 0;

        for(int i=0; i<str.length()-1; i++) {

            char c = str.charAt(i);
            char c2 = str.charAt(i+1);

            Integer v = ROMAN_NUMBER.get(String.valueOf(c));
            Integer v2 = ROMAN_NUMBER.get(String.valueOf(c2));

            if(v < v2) {
                ans -= v;
            } else {
                ans += v;
            }
        }

        return ans + ROMAN_NUMBER.get(String.valueOf( str.charAt(str.length()-1) ));
    }
}


