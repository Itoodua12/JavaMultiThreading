package executor_service.submit;

import java.util.concurrent.*;

public class Example3 {
    public static void main(String[] args) {
        ExecutorService service =
                Executors.newFixedThreadPool(4);

        //TODO: -> this is the example how to pass the parameters to Callable
        //TODO: solution is two create class which implements Callable interface
        //TODO: describe its fields which will be linked into the business logic
        Callable<Integer> c =
                new SummingNumbersCallable(3,5);

        Future<Integer> f = service.submit(c);

        try {
            Integer value =  f.get(); // sum of two numbers
            System.out.println(value);
        }catch (InterruptedException | ExecutionException e) {

        }finally {
            service.shutdown();
        }
    }
}
