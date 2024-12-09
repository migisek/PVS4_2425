package threads;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ControlledAppend {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("outAppend.txt"));
        pw.println("Lines below are appended:");
        pw.close();


        PrintWriter append = new PrintWriter(new FileWriter("outAppend.txt", true));
        Scanner sc = new Scanner(System.in);
        String input;

        Thread keepAlive = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        if ( new File("outAppend.txt").exists()){
                            System.out.println("Soubor ok");
                        } else {
                            throw new InterruptedException();
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("reading interrupted");
                }
            }
        });
        keepAlive.setDaemon(true);

        keepAlive.start();
        while (!(input = JOptionPane.showInputDialog("Append: ")).equals("konec") && keepAlive.isAlive()) {
            append.println(input);
            append.flush();
        }
        append.close();

    }
}
