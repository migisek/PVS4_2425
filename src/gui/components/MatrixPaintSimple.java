package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MatrixPaintSimple extends JFrame {

    static MyLabel clickedLabel = null;

    public MatrixPaintSimple(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 800);

        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 10, 3,3));
        JLabel topLabel = new JLabel("Labels below");
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topLabel.setFont(new Font("Consolas", Font.BOLD,32));
        this.add(topLabel, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);

        for (int i = 1; i <= 100 ; i++) {
            MyLabel label = new MyLabel(String.valueOf(i));
            panel.add(label);
        }

    }


    public static void main(String[] args) {
        new MatrixPaintSimple().setVisible(true);
    }
}
class MyLabel extends JLabel{
    boolean clicked;

    Color DEFAULT_BACKGROUND = Color.white;
    Color MOUSE_OVER_BG = Color.magenta;
    Color CLICK_BG = Color.cyan;

    MyLabel(String text){
        super(text);
        clicked = false;
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("Consolas", Font.BOLD,18));
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(100, 50));
        this.setBackground(DEFAULT_BACKGROUND);


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (MatrixPaintSimple.clickedLabel != null){
                   MatrixPaintSimple.clickedLabel.setBackground(DEFAULT_BACKGROUND);
                   MatrixPaintSimple.clickedLabel.clicked = false;
               }
                setBackground(CLICK_BG);
                clicked = true;
                MatrixPaintSimple.clickedLabel = MyLabel.this;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!clicked)
                    setBackground(MOUSE_OVER_BG);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!clicked)
                    setBackground(DEFAULT_BACKGROUND);
            }

        });
    }
}