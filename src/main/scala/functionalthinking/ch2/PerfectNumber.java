package functionalthinking.ch2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by dj on 2017/7/7.
 */
public class PerfectNumber {

    private int number;
    private Map<Integer,Integer> cache;

    public PerfectNumber(int number) {
        this.number = number;
        this.cache = new HashMap();
    }

    public boolean isFactor(int i) {
        return number % i == 0;
    }

    public Set<Integer> getFactors() {
        Set<Integer> result = new HashSet<>();
        result.add(1);
        result.add(number);
        for (int i=2;i<number;i++) {
            if (isFactor(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public int aliquotSum() {
        if (cache.get(number) == null) {
            int sum = 0;
            for (int i : getFactors()) {
                sum += i;
            }
            cache.put(number,sum - number);
        }
        return cache.get(number);
    }

    public boolean isPerfect() {
        return aliquotSum() == number;
    }

    public boolean isAbundant() {
        return aliquotSum() > number;
    }

    public boolean isDeficient() {
        return aliquotSum() < number;
    }

}
