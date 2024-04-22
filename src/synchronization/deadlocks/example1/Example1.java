package synchronization.deadlocks.example1;

public class Example1 {


    private final Object monitor = new Object();

    public void a() {
        synchronized (monitor) {

        }
    }

    public void b() {
        synchronized (this) {

        }
    }

    public synchronized /* this */ void c() {}

    public static synchronized void d() {

    }

    public static void e() {
        synchronized (Example1.class) {}
    }
}
