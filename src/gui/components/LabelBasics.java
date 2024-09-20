package gui.components;

import javax.swing.*;
import java.awt.*;

public class LabelBasics extends JFrame {

    public LabelBasics(){
        this.setSize(new Dimension(420, 420));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Ukazka label component");
        this.setLayout(null);


        JLabel label = new JLabel();
        label.setText("Tady je nejaky text");
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Consolas", Font.PLAIN, 24));

        label.setOpaque(true);
        label.setBackground(new Color(0xff0005));
        label.setForeground(new Color(101, 3, 3));
        label.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        label.setBounds(100, 100, 300, 60);
        this.add(label);

    }

    public static void main(String[] args) {
        new LabelBasics().setVisible(true);
    }
}
