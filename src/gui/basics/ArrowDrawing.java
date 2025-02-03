package gui.basics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

public class ArrowDrawing extends JFrame {
    ArrowDrawing() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Ukazka grafiky");
        getContentPane().add(new Canvas());
        pack();
    }

    public static void main(String[] args) {
        new ArrowDrawing().setVisible(true);
    }
}

class Canvas extends JPanel {
    final int H = 400;
    final int W = 600;

    Canvas() {
        setPreferredSize(new Dimension(W, H));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.black);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.drawLine(0,0, getWidth(), getHeight());
//        g2.drawRect(100, 100, 150, 150);


//        g2.drawOval(100, 100, 150, 150);

//        drawArrow(g2, 100, 100, 500, 200, 40);
        drawStar(g2, getWidth()/2, getHeight()/2, 160, 80, 5);
//        int width = 160;
//        int height = 160;
//        g2.drawOval((getWidth()/2) - (width/2), (getHeight()/2) - (height/2), width, height);
//
//        width = 240;
//        height = 240;
//        g2.drawOval((getWidth()/2) - (width/2), (getHeight()/2) - (height/2), width, height);

    }

    void drawArrow(Graphics2D g, double x1, double y1, double x2, double y2, double arrowLength) {
        double vx = x2 - x1;
        double vy = y2 - y1;

//        double vLength = Math.sqrt((vx*vx) + (vy*vy));
        double vLength = Math.hypot(vx, vy);

        double vNormX = vx / vLength;
        double vNormY = vy / vLength;

        double vArrowX = arrowLength * vNormX;
        double vArrowY = arrowLength * vNormY;

        //kolmy vektor
        double kx = -vArrowY;
        double ky = vArrowX;

        //relativni dylka
        kx *= 0.25;
        ky *= 0.25;

        //hlavni cast sipky
        g.draw(new Line2D.Double(x1, y1, x2, y2));

        //bocni casti
        g.draw(new Line2D.Double(x2, y2, x2 - vArrowX + kx, y2 - vArrowY + ky));
        g.draw(new Line2D.Double(x2, y2, x2 - vArrowX - kx, y2 - vArrowY - ky));
    }

    void drawStar(Graphics2D g, double centerX, double centerY, double outerRadius, double innerRadius, int points) {
        double angleIncrement = 2 * Math.PI / points;
        double halfIncrement = angleIncrement / 2;

        Path2D star = new Path2D.Double();
        for (int i = 0; i < points; i++) {
            double outerX = centerX + outerRadius * Math.cos(i * angleIncrement);
            double outerY = centerY + outerRadius * Math.sin(i * angleIncrement);

            double innerX = centerX + innerRadius * Math.cos(i * angleIncrement + halfIncrement);
            double innerY = centerY + innerRadius * Math.sin(i * angleIncrement + halfIncrement);

            if (i == 0) {
                star.moveTo(outerX, outerY);
            } else {
                star.lineTo(outerX, outerY);
            }
            star.lineTo(innerX, innerY);

        }
        star.closePath();
        g.draw(star);
    }
}
