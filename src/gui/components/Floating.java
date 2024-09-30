package gui.components;

import javax.swing.*;
import java.awt.*;

public class Floating extends JFrame {
    Floating(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(700, 700);
        this.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBounds(250, 250, 300, 300);

        for (int i = 0; i < 10; i++) {
            panel.add(new JButton(String.valueOf(i)));
        }
        this.add(panel);
    }

    public static void main(String[] args) {
        new Floating().setVisible(true);
    }
}
