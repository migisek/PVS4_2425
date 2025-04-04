package recap;

import java.time.LocalDateTime;

public class Geometry {
    static class Square implements Shape{
        double sideLength;

        public Square(double sideLength) {
            this.sideLength = sideLength;
        }

        @Override
        public double getArea() {
            return sideLength * sideLength;
        }
    }

    public static void main(String[] args) {
        Square s = new Square(6.3);
        System.out.println(s.getArea());
        LocalDateTime now = LocalDateTime.now();

    }

}
