package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mousing extends JFrame {

    public Mousing(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        this.setLayout(null);

        panel.setBackground(Color.magenta);


        panel.setBounds(100, 100, 350, 500);
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                panel.setBackground(Color.blue);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panel.setBackground(Color.yellow);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panel.setBackground(Color.green);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(Color.orange);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(Color.magenta);
            }
        });


        this.add(panel);
    }

    public static void main(String[] args) {
        new Mousing().setVisible(true);
    }
}