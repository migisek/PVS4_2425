package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Radios extends JFrame {
    Radios(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(),northPanel = new JPanel();

        JRadioButton greenButton = new JRadioButton("Green");
        JRadioButton blueButton = new JRadioButton("Blue");
        JRadioButton redButton = new JRadioButton("Red");

        JCheckBox checkBox = new JCheckBox("Border");
        ButtonGroup group = new ButtonGroup();
        group.add(greenButton);
        group.add(redButton);
        group.add(blueButton);

        JButton button = new JButton("Paint");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (greenButton.isSelected()){
                    centerPanel.setBackground(Color.green);
                }if (blueButton.isSelected()){
                    centerPanel.setBackground(Color.blue);
                }if (redButton.isSelected()){
                    centerPanel.setBackground(Color.red);
                }

                if (checkBox.isSelected()){
                    centerPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));
                }

            }
        });


        northPanel.setLayout(new FlowLayout());
        northPanel.add(redButton);
        northPanel.add(greenButton);
        northPanel.add(blueButton);
        northPanel.add(checkBox);
        northPanel.add(button);



        centerPanel.setBackground(Color.magenta);
        add(centerPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);

    }
    public static void main(String[] args) {
        new Radios().setVisible(true);
    }
}
