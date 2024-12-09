package threads.fileread;

public class SingleRead {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) { //single thread varianta, vytvori, seradi, jeden po jednom
            ReaderThread singleRead = new ReaderThread("num"+i+".txt");
            singleRead.doStuff();
        }
        long stop = System.currentTimeMillis();
        System.out.println("Duration (single): " + (stop-start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            ReaderThread singleRead = new ReaderThread("num"+i+".txt");
            singleRead.doStuff();
        }
        stop = System.currentTimeMillis();
        System.out.println("Duration (single): " + (stop-start));

//        for (int i = 0; i < 10; i++) { // multithread
//            ReaderThread singleRead = new ReaderThread("num"+i+".txt");
//            singleRead.start();
//            singleRead.join();
//        }

    }
}
