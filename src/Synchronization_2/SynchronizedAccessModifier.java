package Synchronization_2;


class Power {

    public synchronized void printPower(int number) {
        int curr = 1;
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + number + "^" + i + " value:"
                    + number * curr);

            curr = number * curr;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadPower extends Thread {
    Power p;
    int targetNumber;

    public ThreadPower(int targetNumber, Power p) {
        this.targetNumber = targetNumber;
        this.p = p;
    }

    @Override
    public void run() {
        p.printPower(targetNumber);
    }

}

public class SynchronizedAccessModifier {
    public static void main(String[] args) {
        Power p = new Power();
        ThreadPower threadPower = new ThreadPower(5, p);
        ThreadPower threadPower1 = new ThreadPower(8, p);
        threadPower.start();
        threadPower1.start();
    }
}
