package RaceCondition.ReadModifyWrite;

public class Main {

    public static void main(String[] args) {

//        Counter counter = new Counter();
        SynchronizedCounter counter = new SynchronizedCounter();

        Thread thread1 = new Thread(getRunnable(counter, "Thread1 final count"));
        Thread thread2 = new Thread(getRunnable(counter, "Thread2 final count"));

        thread1.start();
        thread2.start();
    }

    private static Runnable getRunnable(Counter counter, String message) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incrementAndGet();
            }
            System.out.println(message + "= " + counter.get());
        };
    }

    private static Runnable getRunnable(SynchronizedCounter counter, String message) { // for synchronized counter
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incrementAndGet();
            }
            System.out.println(message + "= " + counter.get());
        };
    }
}


