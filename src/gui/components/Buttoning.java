package gui.components;

import javax.swing.*;
import java.awt.*;

public class Buttoning extends JFrame {

    public Buttoning(){
        this.setSize(500, 500);
        this.setTitle("Ukazka buttons");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(null);

        JButton button = new JButton();
        button.setText("Press me");
        button.setFont(new Font("Consolas", Font.BOLD,32));
        button.setFocusable(false);

//        button.setEnabled(false);
        button.setBounds(150, 50, 200,170);
        button.setBackground(Color.magenta);
        button.setForeground(new Color(0x00ff00));
        //nebude fungovat - potrebuje komponentu k obarveni
        //this.setBackground(new Color(0, 0, 255));

        JButton onButton = new JButton("change");
        onButton.setFont(new Font("Consolas", Font.BOLD,18));
        onButton.setFocusable(false);

        //chci to hodit pod button 'press me'
        //y = y pro button 'press me' + vyska buttonu
        onButton.setBounds(200, 220, 100,100);



        this.add(button);
        this.add(onButton);
    }

    public static void main(String[] args) {
        new Buttoning().setVisible(true);
    }
}
