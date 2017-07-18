package functionalthinking.ch2;

import java.util.stream.IntStream;

/**
 * Created by dj on 2017/7/7.
 */
public class PerfectNumberClassifierInJava8 {

    public static IntStream factorsOf(int number) {
        return IntStream.range(1,number+1).filter(i -> number % i == 0);
    }

    public static int aliquotSum(int number) {
        return factorsOf(number).sum() - number;
    }

    public static  boolean isPerfect(int number) {
        return aliquotSum(number) == number;
    }
}
