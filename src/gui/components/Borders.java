package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Borders extends JFrame {

    public Borders(){
        this.setSize(700, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        JPanel redPanel = new JPanel();
        JPanel greenPanel = new JPanel();
        JPanel bluePanel = new JPanel();
        JPanel magPanel = new JPanel();
        redPanel.setBackground(Color.red);
        greenPanel.setBackground(Color.green);
        bluePanel.setBackground(Color.blue);
        magPanel.setBackground(Color.magenta);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));


        redPanel.setPreferredSize(new Dimension(100,100));
        greenPanel.setPreferredSize(new Dimension(100,100));
        bluePanel.setPreferredSize(new Dimension(100,100));
        magPanel.setPreferredSize(new Dimension(100,100));

        JButton counterButton = new JButton("Counter");
        counterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color tmp = redPanel.getBackground();
                redPanel.setBackground(magPanel.getBackground());
                magPanel.setBackground(greenPanel.getBackground());
                greenPanel.setBackground(bluePanel.getBackground());
                bluePanel.setBackground(tmp);
            }
        });

        JButton clockButton = new JButton("Clock");
        clockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color tmp = redPanel.getBackground();
                redPanel.setBackground(bluePanel.getBackground());
                bluePanel.setBackground(greenPanel.getBackground());
                greenPanel.setBackground(magPanel.getBackground());
                magPanel.setBackground(tmp);
            }
        });


        this.add(redPanel, BorderLayout.NORTH);
        this.add(greenPanel, BorderLayout.SOUTH);
        this.add(bluePanel, BorderLayout.WEST);
        this.add(magPanel, BorderLayout.EAST);
        this.add(buttonPanel, BorderLayout.CENTER);

        buttonPanel.add(counterButton);
        buttonPanel.add(clockButton);
    }


    public static void main(String[] args) {
           new Borders().setVisible(true);
    }
}
