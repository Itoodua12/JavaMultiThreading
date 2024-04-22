package race_condition.ReadModifyWrite;

public class SynchronizedCounter {

    private long count = 0;

    public long incrementAndGet() {
        synchronized (this) {
            this.count++;
            return this.count;
        }
    }

    public long get() {
        synchronized (this) {
            return this.count;
        }
    }
}
