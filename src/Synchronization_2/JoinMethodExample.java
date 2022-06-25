package Synchronization_2;

class Task extends Thread {

    public Task(String threadName) {
        this.setName(threadName);
    }

    @Override
    public void run() {
        for(int i=0; i<=3; i++){
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(e);
            }
            System.out.println("ThreadName: " + Thread.currentThread().getName() + " " + i);
        }
    }
}

public class JoinMethodExample {
    public static void main(String[] args) {
        Task task1 = new Task("TASK-1");
        Task task2 = new Task("TASK-2");
        Task task3 = new Task("TASK-3");

        task1.start();
        try {
            System.out.println("TASK-1 completes its task FIRST!");
            task1.join(); // All threads are waiting until Task-1 completes its execution.
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Now Task-2  and Task-3 will start executing. Unpredictable order");
        task2.start();
        task3.start();
    }
}
