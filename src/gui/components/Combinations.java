package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Combinations extends JFrame {

    public Combinations() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        String[] choices = {"Borders", "Grids", "Flows"};

        JComboBox<String> comboBox = new JComboBox<>(choices);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox.getSelectedItem());
                System.out.println(comboBox.getSelectedIndex());
            }
        });



//        comboBox.setEditable(true);
        JButton windowButton = new JButton("OPEN");
        windowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame reference = null;
                switch (comboBox.getSelectedIndex()){
                    case 0:
                        reference = new BordersInserted();

                        break;
                    case 1:
                        reference = new Grid();

                        break;
                    case 2:
                        reference = new Floating();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Not yet implemented :(");
                }
                if (reference != null){
                    reference.setVisible(true);
                    reference.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            }
        });

        comboBox.addItem("Last one");
        this.add(comboBox);
        add(windowButton);
        this.pack();
    }

    public static void main(String[] args) {
        new Combinations().setVisible(true);
    }

}