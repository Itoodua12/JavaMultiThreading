package BlockingObjects.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Example1 {


    private final Semaphore semaphore = new Semaphore(4);

    public static void main(String[] args) {


    }
    // initial threads -> t1, t2, t3, t4, t5
    public void m() throws InterruptedException {
        // t5 -> blocked because it has only 4 permits
        try {
            semaphore.acquire();
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        // t1, t2, t3, t4
    }
}
