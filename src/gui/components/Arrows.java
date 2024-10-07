package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Arrows extends JFrame {
    static final int VELOCITY = 10;

    Arrows(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 700);
        setLayout(null);

        JLabel text = new JLabel("TBD");
        text.setFont(new Font("Consolas", Font.BOLD, 22));
        text.setBounds(getWidth()/2, 0, 100, 50);

        JLabel moving = new JLabel();
         moving.setBounds(0,0, 100, 100);
         moving.setBackground(Color.red);
         moving.setOpaque(true);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyChar()){
                    case 'a': moving.setLocation(moving.getX()-VELOCITY, moving.getY()); break;
                    case 'w': moving.setLocation(moving.getX(), moving.getY()-VELOCITY); break;
                    case 's': moving.setLocation(moving.getX(), moving.getY()+VELOCITY); break;
                    case 'd': moving.setLocation(moving.getX()+VELOCITY, moving.getY()); break;
                }


                //System.out.println("Pressed: " +e.getKeyCode());
                text.setText(String.valueOf(e.getKeyChar()));
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println("Released: " + e.getKeyCode());

            }
        });


        add(moving);
        add(text);
    }

    public static void main(String[] args) {
        new Arrows().setVisible(true);
    }
}
