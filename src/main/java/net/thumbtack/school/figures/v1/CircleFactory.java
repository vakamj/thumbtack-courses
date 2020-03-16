package net.thumbtack.school.figures.v1;

public class CircleFactory {
    private static int count = 0;

    public static Circle createCircle(Point center, int radius) {
        Circle circle = new Circle(center.getX(), center.getY(), radius);
        count++;
        return circle;
    }

    public static int getCircleCount() {
        return count;
    }

    public static void reset() {
        count = 0;
    }

}
