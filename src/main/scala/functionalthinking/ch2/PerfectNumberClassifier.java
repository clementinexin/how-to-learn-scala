package functionalthinking.ch2;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dj on 2017/7/7.
 */
public class PerfectNumberClassifier {

    public static boolean isFactor(int number,int i) {
        return number % i == 0;
    }

    public static Set<Integer> getFactors(int number) {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(number);
        for (int i=2;i<number;i++) {
            if (isFactor(number,i)) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static int aliquotSum(Collection<Integer> factors) {
        int sum = 0;
        for (int i : factors) {
            sum += i;
        }
        return sum - Collections.max(factors);
    }

    public static boolean isPerfect(int number) {
        return aliquotSum(getFactors(number)) == number;
    }
}
