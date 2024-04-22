package synchronization;

class Operations {
    public int count;

    public synchronized void increment() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("count = " + count + " " + Thread.currentThread().getName());
            count++;
        }
        System.out.println("count value = " + count);
    }

    public synchronized void decrement() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("count = " + count + " " + Thread.currentThread().getName());
            count--;
        }
        System.out.println("count value = " + count);
    }
}

public class SynchronizedCounter {
    public static void main(String[] args) {
        Operations operations = new Operations();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                operations.increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                operations.decrement();
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

        System.out.println("Final answer -> [" + operations.count + " = 0]");
    }
}
