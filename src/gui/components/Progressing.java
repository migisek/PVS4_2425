package gui.components;

import javax.swing.*;
import java.awt.*;

public class Progressing extends JFrame {
    JProgressBar bar;
    Progressing(){
        bar = new JProgressBar(0, 150);
        bar.setValue(0);
        bar.setStringPainted(true);
        bar.setBounds(0,0, 420, 50);
        bar.setFont(new Font("MV Boli", Font.BOLD, 25));
        bar.setForeground(Color.red);
        bar.setBackground(Color.black);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 420);
        setLayout(null);
        add(bar);

    }

    public void fill(){
        int counter = 150;

        while (counter > 0){
            bar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Thread died :(");
            }
            counter--;
        }
        bar.setString("Done!");
    }

    public static void main(String[] args) {
        Progressing p = new Progressing();
        p.setVisible(true);
        p.fill();
    }
}
