package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Texting extends JFrame {

    Texting(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));
        this.setSize(420, 420);
        this.setLocationRelativeTo(null);

        JButton button = new JButton("Press");
        JTextField textField = new JTextField("TMP");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText());
            }
        });
        JButton hide = new JButton("Hide/reveal");

        hide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setEnabled(!textField.isEnabled());
            }
        });

        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Consolas", Font.BOLD, 18));
        textField.setBackground(Color.green);
        textField.setForeground(Color.magenta);

        this.add(textField);
        this.add(button);
        this.add(hide);
    }


    public static void main(String[] args) {
        new Texting().setVisible(true);
    }
}
