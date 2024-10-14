package gui.components;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Sliding extends JFrame {

    public Sliding(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(200, 400);


        JPanel panel = new JPanel();
        JSlider slider = new JSlider(0, 100, 50);
        JLabel label = new JLabel();
        slider.setPreferredSize(new Dimension(200, 200));

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintLabels(true);

        slider.setOrientation(SwingConstants.VERTICAL);

        label.setText("°C = " + slider.getValue());

        slider.setFont(new Font("MV Boli", Font.PLAIN, 15));
        label.setFont(new Font("MV Boli", Font.PLAIN, 15));

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText("°C = " + slider.getValue());
            }
        });

        panel.add(slider);
        panel.add(label);
        add(panel);
    }

    public static void main(String[] args) {
        new Sliding().setVisible(true);
    }
}
