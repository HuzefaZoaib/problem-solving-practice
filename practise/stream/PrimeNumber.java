package practise.stream;

import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args) {

        IntStream.range(1,100).filter(PrimeNumber::isPrime).forEach(System.out::println);

    }

    static boolean isPrime(int num) {
        if(num == 1 || num == 2 || num == 3) return true;
        return !IntStream.rangeClosed(2,num/2).anyMatch(n -> num%n == 0);
    }
}
