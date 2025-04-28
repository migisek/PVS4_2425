package recap.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Formular extends JFrame {
    public Formular() {
        JFrame frame = new JFrame();
        frame.setTitle("Formular");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3,2));
        JLabel label = new JLabel("Dementi ve třídě");
        label.setFont(label.getFont().deriveFont(20f));
        JPanel panel2 = new JPanel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel jmeno = new JLabel("Jméno žáka");
        jmeno.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField tf1 = new JTextField();
        JLabel vek = new JLabel("Věk žáka");
        vek.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField tf2 = new JTextField();
        JLabel demence = new JLabel("Trpí demencí");
        demence.setHorizontalAlignment(SwingConstants.CENTER);
        JCheckBox cb1 = new JCheckBox();

        JButton b1 = new JButton("Odeslat");
        b1.setSize(150,50);
        b1.setFocusable(false);

        JButton b2 = new JButton("Zrušit");
        b2.setSize(150,50);
        b2.setFocusable(false);

        panel.add(jmeno);
        panel.add(tf1);
        panel.add(vek);
        panel.add(tf2);
        panel.add(demence);
        panel.add(cb1);
        panel2.add(b2);
        panel2.add(b1);

        frame.add(label,BorderLayout.NORTH);
        frame.add(panel,BorderLayout.CENTER);
        frame.add(panel2,BorderLayout.SOUTH);

        frame.setVisible(true);

        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tf2.getText().equals("")&& tf1.getText().equals("")) {
                        JOptionPane.showMessageDialog(frame,"Chybí jméno a věk");
                    } else if (tf1.getText().equals("")) {
                        JOptionPane.showMessageDialog(frame,"Chybí věk");
                    } else if (tf2.getText().equals("")) {
                        JOptionPane.showMessageDialog(frame,"Chybí jméno");
                    } else {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("data/formular.txt",true));
                    bw.write(tf1.getText() + "," + Integer.parseInt(tf2.getText()) + "," + cb1.isSelected() + "\n");
                    bw.close();
                    JOptionPane.showMessageDialog(frame,"Vše proběhlo v pořádku!");
                }} catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText("");
                tf2.setText("");
                cb1.setSelected(false);
            }
        });
    }

    public static void main(String[] args) {
        Formular form = new Formular();
    }

}
