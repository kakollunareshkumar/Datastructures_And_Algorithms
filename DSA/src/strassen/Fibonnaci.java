package strassen;

 class Fibonacci {
    public static long fibonacci(long n) {
        if(n==0 ){
            return 0;
        }else if(n==1){
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    public static void main(String args[]) {
        long preTime=System.currentTimeMillis();
        System.out.println("Value of 55th number in fibonacci series->"+fibonacci(5));
        long postTime=System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds->"+(postTime-preTime));
    }
}