package race_condition.CheckThenAct;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {

        Map<String,String> sharedMap = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(getRunnable(sharedMap));
        Thread thread2 = new Thread(getRunnable(sharedMap));

        thread1.start();
        thread2.start();

    }

    private static Runnable getRunnable(Map<String, String > sharedMap) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
/*                synchronized (sharedMap) {
    todo:  synchronized block to make atomic. synchronized block case.
            from the output we never have a situation where threads go into the if statement at the same time.
            ( if(sharedMap.contains("key") )  -> when this if-statement is true
            Output is nothing , nothing will be printed.
*/
                    if(sharedMap.containsKey("key")) {
                        String val = sharedMap.remove("key");
                        if(val == null) {
                            System.out.println("Iteration: " + i + ": Value for 'key' was null");
                        }
                    } else {
                        sharedMap.put("key", "value");
                    }
                }
//            }
        };
    }
}
