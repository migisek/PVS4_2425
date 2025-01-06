package threads.fileread.syncing;

import javax.swing.*;
import java.util.Scanner;

public class CountDownDemo {

    static boolean timeExpired = false;
    static boolean inputReceived = false;
    static final Object LOCK = new Object();

    public static void main(String[] args) {
        String code = "secret";
        int countdown = 10;

        Thread countdownThread = new Thread(() -> {
            try {
                for (int i = 0; i < countdown; i++) {
                    synchronized (LOCK) {
                        if (inputReceived) {
                            return;
                        }
                    }
                    System.out.println("Zbyva: " + (countdown - i));
                    Thread.sleep(1000);
                }

                synchronized (LOCK) {
                    timeExpired = true;
                }
            } catch (InterruptedException ignored) {
            }
        });

        Thread inputRead = new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            System.out.println("Zadej heslo:");
            String input = sc.nextLine();
            synchronized (LOCK) {
                if (!timeExpired) {
                    if (input != null && input.equals(code)) {
                    inputReceived = true;
                        System.out.println("Correct");
                    } else {
                        System.out.println("Wrong :(");
                    }
                } else {
                    System.out.println("Out of time");
                }
            }
        });

        inputRead.start();
        countdownThread.start();


        try {
            countdownThread.join();
            inputRead.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Happy ending!");
    }
}
