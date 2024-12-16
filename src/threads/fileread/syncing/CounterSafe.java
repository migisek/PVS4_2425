package threads.fileread.syncing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CounterSafe {
    public static void main(String[] args) throws InterruptedException {
        CounterSynced counter = new CounterSynced();

        int threadCount = 5;
        int threadIncrease = 10000;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                for (int j = 0; j < threadIncrease; j++) {
                    counter.increase();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        int expected = threadIncrease * threadCount;
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + counter.getCount());
    }
}
class CounterSynced{
    private int count = 0;

    public synchronized int getCount() {
        return count;
    }

    public synchronized void increase(){
        count++;
    }
}
