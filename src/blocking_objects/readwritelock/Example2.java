package blocking_objects.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Example2 {

    int n;
    ReadWriteLock lock = new ReentrantReadWriteLock();

    public void increment() {

        try {
            lock.writeLock().lock();
            n++;
        }finally {
            lock.writeLock().unlock();
        }
    }

    public int get() {
        try {
            lock.readLock().lock();
            return n;
        } finally {
            lock.readLock().unlock();
        }
    }
}
