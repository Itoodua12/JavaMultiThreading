package forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Example3 {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int n  = 10;
        int result = forkJoinPool.invoke(new FibonacciTask(n));
        System.out.println("Fibonacci number(" + n + ") = " + result);
    }

}


class FibonacciTask extends RecursiveTask<Integer> {


    private final int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if(n <= 1) {
            return n;
        }else {
            FibonacciTask t1 = new FibonacciTask(n - 1);
            FibonacciTask t2 = new FibonacciTask(n - 2);
            t1.fork();
            t2.fork();
            return t1.join() + t2.join();
        }
    }
}
