package gui.components;

import javax.swing.*;
import java.awt.*;

public class Floating extends JFrame {
    Floating(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(700, 700);
        //JPanel panel = new JPanel();
        this.setBackground(Color.gray);

        this.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));

        for (int i = 0; i < 10; i++) {
            this.add(new JButton(String.valueOf(i)));
        }
    }

    public static void main(String[] args) {
        new Floating().setVisible(true);
    }
}
