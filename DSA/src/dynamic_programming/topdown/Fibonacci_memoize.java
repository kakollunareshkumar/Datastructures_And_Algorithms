package dynamic_programming.topdown;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci_memoize {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static  int fib(int n) {

        if (n < 0) {
            throw new IllegalArgumentException(
                    "Index was negative. No such thing as a negative index in a series.");

            // base cases
        } else if (n == 0 || n == 1) {
            return n;
        }

        // see if we've already calculated this
        if (memo.containsKey(n)) {
            System.out.printf("grabbing memo[%d]\n", n);
            return memo.get(n);
        }

        System.out.printf("computing fib(%d)\n", n);
        int result = fib(n - 1) + fib(n - 2);

        // memoize
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        Fibonacci_memoize fm= new Fibonacci_memoize();
        System.out.println(fib(5));
    }
}

/*
References:
https://www.interviewcake.com/concept/java/memoization
 */