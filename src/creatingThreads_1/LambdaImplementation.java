package creatingThreads_1;

//todo : How to use Java Lambda expression to create thread via Runnable
public class LambdaImplementation {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i <= 10; i++) {
                System.out.println("Lambda Runnable running with number: " + i);
            }
        };
        new Thread(runnable).start();
    }
}
