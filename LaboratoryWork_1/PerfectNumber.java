package LaboratoryWork_1;

import java.util.HashSet;
import java.util.Set;

public class PerfectNumber {

    public enum STATE {
        DEFICIENT,
        PERFECT,
        ABUNDANT;
    }

    public static STATE detect(int n) {
        Set<Integer> set = divisors(n);
        STATE result;

        int counter = 0;

        for (Integer number: set) {
            if (number == n) continue;
            counter += number;
        }

        if (counter > n) {
            result = STATE.ABUNDANT;
        } else if (counter < n) {
            result = STATE.DEFICIENT;
        } else {
            result = STATE.PERFECT;
        }

        // Debug
        System.out.println(n + " - " + counter + " = " + result);

        return result;
    }

    public static Set<Integer> divisors(int n){

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {
                set.add(n / i);
            }
        }

        return set;
    }

    public static STATE process(int n){
        return detect(n);
    }

    public static void main(String[] args) {
        PerfectNumber.detect(20);
    }
}