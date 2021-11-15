package dynamic_programming.topdown;

public class Fibonacci_Series {

    public static int fib(int n) {

        if (n < 0) {
            throw new IllegalArgumentException(
                    "Index was negative. No such thing as a negative index in a series.");
        }

        // base cases
        if (n == 0 || n == 1) {
            return n;
        }

        System.out.printf("computing fib(%d)\n", n);
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
/*
References:
https://www.interviewcake.com/concept/java/memoization
 */