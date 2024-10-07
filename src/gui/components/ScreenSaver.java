package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenSaver extends JFrame {
    Canvas panel;

    ScreenSaver() {
        panel = new Canvas();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
        add(panel);
        pack();//zmensi okno tak, aby vse v nem bylo videt
    }

    public static void main(String[] args) {
        new ScreenSaver().setVisible(true);
    }

}

class Canvas extends JPanel implements ActionListener {
    final int CANVAS_WIDTH = 1200;
    final int CANVAS_HEIGHT = 1200;
    Image bouncing;
    Timer timer;
    int x = 0;
    int y = 0;
    int xVelocity = 5;
    int yVelocity = 2;

    Canvas() {
        this.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.setBackground(Color.black);
        bouncing = new ImageIcon("dvd.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // vykresli treba pozadi
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(bouncing, x, y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (y >= CANVAS_HEIGHT - bouncing.getHeight(null) || y < 0) {
            yVelocity *= -1;
        }
        y = y + yVelocity;

        if (x >= CANVAS_WIDTH - bouncing.getWidth(null) || x < 0) {
            xVelocity *= -1;
        }
        x = x + xVelocity;
        repaint();
    }
}
