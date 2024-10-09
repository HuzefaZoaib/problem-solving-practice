package practise.stream;

import java.util.Arrays;

public class SumTwoArray {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{3,4}};
        System.out.println(Arrays.stream(arr).flatMapToInt(Arrays::stream).sum());
    }
}
