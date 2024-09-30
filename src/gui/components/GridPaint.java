package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridPaint extends JFrame {

    static int dimension = 9;

    GridPaint(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel();
        JPanel flowPanel = new JPanel();
        JTextField dimField = new JTextField("TMP");
        dimField.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel dimLabel = new JLabel("Dimension:");
        flowPanel.setLayout(new FlowLayout(FlowLayout.CENTER));


        //gridPanel.setBackground(Color.red);
        gridPanel.setOpaque(true);
        flowPanel.setBackground(Color.blue);
        flowPanel.setPreferredSize(new Dimension(100,100));
        JButton paint = new JButton("Paint");
        paint.setFont(new Font("Consolas", Font.BOLD, 28));
        paint.setFocusable(false);


        dimField.setFont(new Font("Consolas", Font.BOLD, 28));
        dimLabel.setFont(new Font("Consolas", Font.BOLD, 28));
        flowPanel.add(dimLabel);
        flowPanel.add(dimField);
        flowPanel.add(paint);


        paint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dimension = Integer.parseInt(dimField.getText());
                gridPanel.setLayout(new GridLayout(dimension, dimension));
                for (int i = 0; i < dimension; i++) {
                    for (int j = 0; j < dimension; j++) {
                        if ((i+j) % 2 == 1)
                            gridPanel.add(new Piece(Color.yellow));
                        else
                            gridPanel.add(new Piece(Color.cyan));

                    }
                }


                paint.setEnabled(false);
                revalidate();
                repaint();
            }
        });


        this.add(gridPanel, BorderLayout.CENTER);
        this.add(flowPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new GridPaint().setVisible(true);
    }
} class Piece extends JLabel{

    public Piece(Color color) {
        this.setText(" ");
        this.setFont(new Font("Consolas", Font.BOLD, 18));
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setOpaque(true);
        this.setBackground(color);
    }
}
