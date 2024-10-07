package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timing extends JFrame {
    Color DEFAULT_COLOR = Color.lightGray;
    boolean isOn = false;

    public Timing(){
        setSize(500, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel redPanel = new JPanel();
        JPanel yellowPanel = new JPanel();
        JPanel greenPanel = new JPanel();

        redPanel.setBackground(DEFAULT_COLOR);
        yellowPanel.setBackground(DEFAULT_COLOR);
        greenPanel.setBackground(DEFAULT_COLOR);
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pro vse najednou
//                if (!isOn){
//                    redPanel.setBackground(Color.red);
//                    yellowPanel.setBackground(Color.yellow);
//                    greenPanel.setBackground(Color.green);
//                } else {
//                    redPanel.setBackground(DEFAULT_COLOR);
//                    yellowPanel.setBackground(DEFAULT_COLOR);
//                    greenPanel.setBackground(DEFAULT_COLOR);
//                }
//                isOn = !isOn;
            }
        });

        setLayout(new GridLayout(3,1, 1, 1));

        timer.start();

        add(redPanel);
        add(yellowPanel);
        add(greenPanel);
    }

    public static void main(String[] args) {
        new Timing().setVisible(true);
    }
}
