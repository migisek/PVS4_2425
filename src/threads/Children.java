package threads;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Children {
    static SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
    public static void main(String[] args) {
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println(
                                timeFormat.format(Calendar.getInstance().getTime())
                        );
                        Thread.sleep(3000);
                    } catch (InterruptedException e){
                        System.out.println(":/");
                    }
                }
            }
        });
        System.out.println("Je daemon?" + timer.isDaemon());

        //nastav jako daemona vuci vlaknu currentThread
        timer.setDaemon(true);

        System.out.println("Je daemon?" + timer.isDaemon());
        timer.start();
        String input = JOptionPane.showInputDialog("Neco zadej...");
        System.out.println("Zadal jsi: " + input);
//        System.exit(1);
    }
}
