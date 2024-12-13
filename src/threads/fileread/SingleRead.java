package threads.fileread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SingleRead {

    public static void main(String[] args) throws InterruptedException {

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 50; i++) {
                String fileName = "num" + i + ".txt";
                try {
                    List<String> lines = Files.readAllLines(Paths.get(fileName));
                    int[] nums = new int[lines.size()];
                    for (int j = 0; j < lines.size(); j++) {
                        nums[j] = Integer.parseInt(lines.get(j));
                    }
                    Arrays.sort(nums);
                    System.out.println("Soubor: " + fileName);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Single-thread duration: " + (endTime - startTime) + " ms");
        }
}
