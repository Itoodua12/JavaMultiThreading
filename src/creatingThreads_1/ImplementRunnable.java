package creatingThreads_1;

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 10 ; ++i) {
            System.out.println("ThreadName: " + Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ImplementRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runner());
        Thread thread1 = new Thread(new Runner());
        thread.start();
        thread1.start();
    }
}
