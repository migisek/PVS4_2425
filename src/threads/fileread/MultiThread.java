package threads.fileread;

import gui.components.ButtonControl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThread {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        String fileName = "num";
        ExecutorService executor = Executors.newFixedThreadPool(50);
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
