package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class Timing extends JFrame {
    Color DEFAULT_COLOR = Color.lightGray;
    boolean isOn = false;
    int position;

    void increasePosition(){
        position++;
    }

    public Timing(){
        setSize(500, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ColorPanel redPanel = new ColorPanel(Color.red);
        ColorPanel yellowPanel = new ColorPanel(Color.yellow);
        ColorPanel greenPanel = new ColorPanel(Color.green);

        redPanel.setBackground(DEFAULT_COLOR);
        yellowPanel.setBackground(DEFAULT_COLOR);
        greenPanel.setBackground(DEFAULT_COLOR);

        Queue<ColorPanel> sequence = new LinkedList<>();
        sequence.add(redPanel);
        sequence.add(yellowPanel);
        sequence.add(greenPanel);
        sequence.add(yellowPanel);//musi byt, aby z green neskocil na red
         Timer timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pro vse najednou
                if (!isOn){
                    redPanel.setBackground(Color.red);
                    yellowPanel.setBackground(Color.yellow);
                    greenPanel.setBackground(Color.green);
                } else {
                    redPanel.setBackground(DEFAULT_COLOR);
                    yellowPanel.setBackground(DEFAULT_COLOR);
                    greenPanel.setBackground(DEFAULT_COLOR);
                }
                isOn = !isOn;
//                sequence.peek().light();
//                try {
//                    Thread.sleep(1500);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
//                sequence.peek().dim();
//                sequence.add(sequence.poll());
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
class ColorPanel extends JPanel{
    Color lightColor;
    Color DEFAULT_COLOR = Color.lightGray;

    public ColorPanel(Color color){
        this.lightColor = color;
        setBackground(lightColor);
    }

    public void light(){
        setBackground(lightColor);
    }

    public void dim(){
        setBackground(DEFAULT_COLOR);
    }

}
