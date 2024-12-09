package threads.fileread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReaderThread extends Thread{
    String fileName;

    public ReaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        doStuff();
    }

    void doStuff(){
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            int[] nums = new int[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                nums[i] = Integer.parseInt(lines.get(i));
            }
            Arrays.sort(nums);
            System.out.println("Sorted array done: " + this.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
