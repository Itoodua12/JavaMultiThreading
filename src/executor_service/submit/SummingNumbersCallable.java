package executor_service.submit;

import java.util.concurrent.Callable;

public class SummingNumbersCallable implements Callable<Integer> {

    int a, b;

    public SummingNumbersCallable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() {
        return a + b;
    }
}
