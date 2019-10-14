package LaboratoryWork1_2;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class PerfectNumber {

    public enum STATE {
        DEFICIENT,
        PERFECT,
        ABUNDANT;
    }

    public static STATE detect(int n) {
        Set<Integer> sets = divisors(n);

        Integer sum = sets.stream()
                .collect(Collectors.summingInt(Integer::intValue));

        STATE result = sum > n ? STATE.ABUNDANT : (sum < n ? STATE.DEFICIENT : STATE.PERFECT);

        // Debug
        System.out.println(n + " - " + sum + " = " + result);

        return result;
    }

    public static Set<Integer> divisors(int n) {

        HashSet<Integer> set =
                IntStream
                        .range(1, (int) Math.ceil(Math.sqrt(n)))
                        .filter(i -> n % i == 0)
                        .boxed()
                        .collect(Collectors.toCollection(HashSet::new));

        set.addAll(IntStream
                .rangeClosed(2, (int) Math.ceil(Math.sqrt(n)))
                .filter(i -> n % i == 0)
                .map(i -> n / i)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new)));

        return set;
    }

    public static STATE process(int n) {
        return detect(n);
    }

    public static void main(String[] args) {
        PerfectNumber.detect(28);

    }
}