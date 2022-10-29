package RaceCondition.ReadModifyWrite;

public class Counter {

    private long count = 0;

    public long incrementAndGet() {
        this.count++; // read-modify -> critical section
        return this.count; // critical section  where race condition occurs
    }

    public long get() {
        return this.count;
    }
}
