package synchronization.deadlocks.example2;

public class A {


    public void m1() {
        synchronized (this) {
            System.out.println("A");
        }
    }

    public synchronized void m2() {
        System.out.println("B");
    }
}
