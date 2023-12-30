package executor_service.submit;

import java.util.concurrent.*;

public class Example2 {

    public static void main(String[] args) {

        //TODO : Difference between Callable and Runnable is that Runnable is kind of tasks that dont return value
        //TODO: and Callable returns value. Both are functional Interfaces.
        ExecutorService service =
                Executors.newFixedThreadPool(4);

        Callable<String> c = () -> "Hello!";

        Future<String> f = service.submit(c);

        try {
            String value =  f.get();
            System.out.println(value);
        }catch (InterruptedException | ExecutionException e) {

        }finally {
            service.shutdown();
        }
    }
}
