package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindTwoMinAndMax {

    public static void main(String[] args) {

        int[] nums = new int[]{3,8,9,1,2,10,11};
        List<Integer> sortedDistinct = Arrays.stream(nums).sorted().distinct().boxed().collect(Collectors.toList());

        System.out.println("First Min: " +sortedDistinct.get(0));
        System.out.println("Second Min: " +sortedDistinct.get(1));
        System.out.println("First Max " +sortedDistinct.get(sortedDistinct.size()-1));
        System.out.println("Second Max " +sortedDistinct.get(sortedDistinct.size()-2));
    }
}
