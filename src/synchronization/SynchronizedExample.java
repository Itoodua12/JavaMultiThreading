package synchronization;

/**
 * When two or more threads need access to a shared resource,
 * they need some way to ensure that the resource will be used by only one thread at a time.
 * The process by which this is achieved is called synchronization.
 */

class Counter {
    int count = 0;

    /**
     * If we remove synchronized on increment() method, both t1 and t2 are fetching the value.
     * and maybe both of them are incrementing it at the same time.
     * multiple threads can access the same method at the same time.
     * That's the reason why count is not 1000 in most of the cases.
     */

    /**
     * We want only one thread use this method at a time..
     * So when t1 is executing increment t2 will not interfere , t2 will wait and vice versa.
     */

    public synchronized void increment() {
        count++;
    }

    /**
     * increment() and increment1() are equivalent!!!
     */

    public void increment1() {
        synchronized (this) {
            count++;
        }
    }
}

public class SynchronizedExample {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 500; i++) {
                    counter.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 500; i++) {
                    counter.increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter value: " + counter.count);

    }
}
