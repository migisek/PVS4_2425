package threads.fileread.syncing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThread {

    static List<Integer> evenNumbers;
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        String fileName = "num";
        evenNumbers = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 50; i++) {
            int fileIndex = i;
            executor.submit(() -> {
               processFile(fileName + fileIndex + ".txt");
            });
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        long end = System.currentTimeMillis();
        System.out.println("Doba trvani pro vice vlaken: " + (end-start) + " ms");
        System.out.println("Sudych cisel: " + evenNumbers.size());
    }

    static void processFile(String fileName){
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines){
                int number = Integer.parseInt(line);
                if (number % 2 == 0)
                    evenNumbers.add(number);
            }
            System.out.println("Soubor: " + fileName + ", Zpracoval" + Thread.currentThread());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
