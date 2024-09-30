package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridPaint extends JFrame {

    GridPaint(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel();
        JPanel flowPanel = new JPanel();

        gridPanel.setLayout(new GridLayout(10, 10));
        flowPanel.setLayout(new FlowLayout(FlowLayout.CENTER));


        //gridPanel.setBackground(Color.red);
        gridPanel.setOpaque(true);
        flowPanel.setBackground(Color.blue);
        flowPanel.setPreferredSize(new Dimension(100,100));
        JButton paint = new JButton("Paint");
        paint.setFont(new Font("Consolas", Font.BOLD, 28));
        paint.setFocusable(false);
        flowPanel.add(paint);

        for (int i = 1; i <= 100; i++) {
            gridPanel.add(new Piece(Color.magenta));
        }

        this.add(gridPanel, BorderLayout.CENTER);
        this.add(flowPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new GridPaint().setVisible(true);
    }
} class Piece extends JLabel{

    public Piece(Color color) {
        this.setText(" ");
        this.setFont(new Font("Consolas", Font.BOLD, 18));
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setOpaque(true);
        this.setBackground(color);
    }
}
