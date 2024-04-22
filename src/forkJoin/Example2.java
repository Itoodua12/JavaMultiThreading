package forkJoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Example2 {

    /*
        Having a list of integers , get back the sum for all values
     */

    public static void main(String[] args) {
        List<Integer> input = List.of(1,2,3,4,5,6,7,8);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int sum  = forkJoinPool.invoke(new SumNumbersRecursiveTask(input));
        System.out.println(sum);

    }
}

class SumNumbersRecursiveTask extends RecursiveTask<Integer> {

    private final List<Integer> input;

    public SumNumbersRecursiveTask(List<Integer> input) {
        this.input = input;
    }

    @Override
    protected Integer compute() {
        if(input.size() <= 2) {
            return input.stream().mapToInt(i -> i).sum();
        } else {
            int mid = input.size() / 2;
            List<Integer> list1 = input.subList(0, mid);
            List<Integer> list2 = input.subList(mid, input.size());

            SumNumbersRecursiveTask t1 = new SumNumbersRecursiveTask(list1);
            SumNumbersRecursiveTask t2 = new SumNumbersRecursiveTask(list2);

//            t1.fork(); // t1 to be executed on a separate thread
            t2.fork(); // t2 to be executed on a separate thread

            return t1.compute() + t2.join(); // t1.join() + t2.join();
        }
    }
}
