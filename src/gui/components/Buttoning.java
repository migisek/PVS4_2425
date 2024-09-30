package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttoning extends JFrame implements ActionListener {
    JButton button, onButton;
    public Buttoning() {
        super();
        this.setSize(500, 500);
        this.setTitle("Ukazka buttons");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(null);

        button = new JButton();
        button.setText("Press me");
        button.setFont(new Font("Consolas", Font.BOLD, 32));
        button.setFocusable(false);

//        button.setEnabled(false);
        button.setBounds(150, 50, 200, 170);
        button.setBackground(Color.magenta);
        button.setForeground(new Color(0x00ff00));

        //varianta 1 - na tlacitko
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button was pressed");
//            }
//        });

        //nebude fungovat - potrebuje komponentu k obarveni
        //this.setBackground(new Color(0, 0, 255));

        onButton = new JButton("change");
        onButton.setFont(new Font("Consolas", Font.BOLD, 18));
        onButton.setFocusable(false);

        //chci to hodit pod button 'press me'
        //y = y pro button 'press me' + vyska buttonu
        onButton.setBounds(200, 220, 100, 100);


        button.addActionListener(this);
        onButton.addActionListener(this);

        this.add(button);
        this.add(onButton);
    }

    public static void main(String[] args) {
        new Buttoning().setVisible(true);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Button was pressed");
        }

        if (e.getSource() == onButton){
//            if (button.isEnabled()){
//             button.setEnabled(false);
//            } else {
//             button.setEnabled(true);
//            }
            //ekvivaletne:
            button.setEnabled(!button.isEnabled());
        }
    }
}
