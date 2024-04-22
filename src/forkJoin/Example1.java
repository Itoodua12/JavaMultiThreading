package forkJoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Example1 {
    /*
        ForkJoinPool -> thread pool

        Task -> T1 (T1.1, T1.2), T2 (T2.1, T2.2)
        -> RecursiveAction --------> Runnable
        -> RecursiveTask<T> -------> Callable<T>

        Scenario:
         having a list of integers, print in the console the values from the list doubled.

         [1,2,3,4,5,6,7,8,9]
         [1,2,3,4,5]  [6,7,8,9]
         [1,2,3], [4,5]  [6,7] [8,9]
         [1,2] [3] [4,5]  [6,7] [8,9]

     */

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new DoubleNumbersRecursiveAction(List.of(1,2,3,4,5,6,7,8,9)));
    }

}



class DoubleNumbersRecursiveAction extends RecursiveAction {

    private final List<Integer> input;

    public DoubleNumbersRecursiveAction(List<Integer> input) {
        this.input = input;
    }

    @Override
    protected void compute() {
      if(input.size() <= 2) {
          input.stream().map(n -> 2 * n).forEach(System.out::println);
      } else {
          int middle = input.size() / 2;
          List<Integer> list1 = input.subList(0, middle);
          List<Integer> list2 = input.subList(middle, input.size());

          DoubleNumbersRecursiveAction t1 = new DoubleNumbersRecursiveAction(list1);
          DoubleNumbersRecursiveAction t2 = new DoubleNumbersRecursiveAction(list2);

          invokeAll(t1, t2);
      }
    }
}