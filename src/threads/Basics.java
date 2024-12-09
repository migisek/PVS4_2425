package threads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Basics {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread());
        System.out.println(Thread.activeCount());
        FirstThread thread = new FirstThread();
        FirstThread otherThread = new FirstThread();
        otherThread.setName("Prvni");
        thread.setName("Druhy");
        thread.setPriority(1);

        System.out.println( thread.isDaemon());
        System.out.println( otherThread.isDaemon());

        otherThread.setPriority(10);
        otherThread.start();
        thread.start();
//        for (int i = 1; i <= 10; i++) {
//            System.out.println("Main thread: " + i);
//        }
        System.out.println(Thread.activeCount());

        IThread th = new IThread();
        Thread implemented = new Thread(th);

        implemented.start();;

        Thread anonymous = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
class FirstThread extends Thread {
    @Override
    public void run() {
        System.out.println(this.getName());
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(getName()+".txt")));
            System.out.println(Thread.currentThread());
            for (int i = 1; i <= 1000000; i++) {
               pw.println(this.getName() + ": " + i);
            }
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getName() + " finished");
    }
}
class IThread implements Runnable{

    @Override
    public void run() {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("example.txt")));
            System.out.println(Thread.currentThread());
            for (int i = 1; i <= 1000000; i++) {
                pw.println(": " + i);
            }
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" finished");
    }
}