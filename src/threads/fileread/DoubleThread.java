package threads.fileread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DoubleThread {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        String basePath = "num";

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 25; i++) {
                    processFile(basePath + i + ".txt");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 25; i < 50; i++) {
                processFile(basePath + i + ".txt");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long endTime = System.currentTimeMillis();

        System.out.println("Two threads time: " + (endTime - startTime) + " ms");
    }

    static void processFile(String fileName){
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            int[] nums = new int[lines.size()];
            for (int j = 0; j < lines.size(); j++) {
                nums[j] = Integer.parseInt(lines.get(j));
            }
            Arrays.sort(nums);
            System.out.println("Soubor: " + fileName + ", Zpracoval" + Thread.currentThread());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
