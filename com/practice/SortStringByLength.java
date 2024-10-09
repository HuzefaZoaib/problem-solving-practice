package com.practice;

import java.util.Arrays;
import java.util.Comparator;

public class SortStringByLength {

    public static void main(String[] args) {

        String[] animalNames = {"cat", "rabbit", "horse", "goat", "rooster", "ooooooooooooooo"};
        Arrays.stream(animalNames).sorted(Comparator.comparing(String::length)).forEach(System.out::println);

    }
}
