package practise.stream;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindingDuplicateUsingStream {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1,4,5,9,0,3,0};
        Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(System.out::println);


    }
}
