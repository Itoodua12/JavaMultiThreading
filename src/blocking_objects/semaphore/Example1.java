package blocking_objects.semaphore;

import java.util.concurrent.Semaphore;

public class Example1 {

    private final Semaphore semaphore = new Semaphore(4);

    public static void main(String[] args) {


    }

    /*
        before acquire() and release() only u can maximum 4 threads active
     */
    public void m() {
        //  T5  -> will be available to enter block of code when T1...T4 any of them will be released
        try {
            semaphore.acquire();
            // T1, T2, T3, T4
        } catch (InterruptedException e) {

        } finally {
            semaphore.release();
        }
    }
}
