package gui.components;

import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    final int ROWS = 5;
    final int COLS = 5;

    public Grid(){
        this.setSize(700, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new GridLayout(5,5, 10, 5));

        for (int i = 1; i <= ROWS * COLS ; i++) {
            JLabel label = new JLabel(String.valueOf(i));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Consolas", Font.BOLD,18));
            label.setBorder(BorderFactory.createLineBorder(Color.black, 3));
            label.setOpaque(true);
            label.setPreferredSize(new Dimension(100, 50));
            label.setBackground(Color.white);
            this.add(label);
        }
    }

    public static void main(String[] args) {
        new Grid().setVisible(true);
    }
}
