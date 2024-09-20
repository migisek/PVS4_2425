package gui.basics;

import javax.swing.*;

public class BasicWindows {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);
        frame.setTitle("Tytl");

        frame.setVisible(true);
    }
}
