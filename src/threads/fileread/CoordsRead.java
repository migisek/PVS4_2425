package threads.fileread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CoordsRead {
    static List<Coordinates> validCoordinates = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        //5 vlaken
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            int fileIndex = i;//nutne, na i nevidi
            executorService.submit(() -> {
               getValidCoords("data\\coords\\coords" + fileIndex + ".txt");
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println(validCoordinates.size());
    }

    static void getValidCoords(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            //x > 100 & y negative
            String[] doubleLine = null;
            for (String line : lines) {
                doubleLine = line.split(",");
                Coordinates coords = new Coordinates(
                        Double.parseDouble(doubleLine[0]),
                        Double.parseDouble(doubleLine[1]));
                if (coords.x > 100 && coords.y < 0){
                    validCoordinates.add(coords);
                }
            }
            System.out.println("Soubor " + path + " zpracoval: " + Thread.currentThread());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Coordinates {
    double x, y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
