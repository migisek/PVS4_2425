package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonControl extends JFrame {
    public ButtonControl(){
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        JLabel label = new JLabel("Secret");
        label.setFont(new Font("Consolas", Font.BOLD, 28));
        label.setBounds(100,200,300,80);
        label.setBorder(BorderFactory.createEtchedBorder());
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button = new JButton();
        button.setText("Hide");
        button.setBounds(150, label.getY()+label.getHeight(), 200, 50);
        button.setFocusable(false);
        button.setFont(new Font("Consolas", Font.BOLD, 28));


        label.setBackground(new Color(0xffffff));
        label.setOpaque(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (label.getBackground().equals(Color.white)){
                    label.setBackground(Color.black);
                    button.setText("Show");
                } else {
                    label.setBackground(Color.white);
                    button.setText("Hide");
                }
            }
        });

        this.add(button);
        this.add(label);

    }

    public static void main(String[] args) {
        new ButtonControl().setVisible(true);
//        System.out.println(new Color(0xffffff) == Color.white);
    }
}
