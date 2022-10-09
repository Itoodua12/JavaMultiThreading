package VolatileKeyword;


public class Volatile {

    public static int target;

    static class Reader extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Reading " + target);
        }
    }

    static class IncrementingThread extends Thread {
        @Override
        public void run() {
            while (true) {
                if (target == 5000) break;
                System.out.println("Starts to increment " + target);
                target++;
            }
        }

    }

    public static void main(String[] args) {
        new IncrementingThread().start();
        new Reader().start();


    }
}
