package creatingThreads_1;

class Task extends Thread {

    public Task(String threadName) {
        this.setName(threadName);
    }

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

public class ExtendsThread {

    public static void main(String[] args) {
        Task task = new Task("Task1");
        task.start();
    }

}
