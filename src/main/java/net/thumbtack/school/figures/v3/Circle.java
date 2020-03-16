package net.thumbtack.school.figures.v3;

import net.thumbtack.school.iface.v3.HasArea;
import net.thumbtack.school.iface.v3.Movable;

import java.util.Objects;

public class Circle extends Figure implements Movable, HasArea {

    private static final int ZERO_CENTRE = 0;
    private static final int RADIUS_VALUE = 1;
    private int xCenter, yCenter, radius;


    public Circle(Point center, int radius) {
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
    }

    public Circle(int xCenter, int yCenter, int radius) {
        this(new Point(xCenter, yCenter), radius);
    }

    public Circle(int radius) {
        this(new Point(ZERO_CENTRE, ZERO_CENTRE), radius);
    }

    public Circle() {
        this(new Point(ZERO_CENTRE, ZERO_CENTRE), RADIUS_VALUE);
    }

    public Point getCenter() {
        return new Point(xCenter, yCenter);
    }

    public void setCenter(Point center) {
        this.xCenter = center.getX();
        this.yCenter = center.getY();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void moveTo(int x, int y) {
        xCenter = x;
        yCenter = y;
    }

    @Override
    public void moveRel(int dx, int dy) {
        xCenter += dx;
        yCenter += dy;
    }

    @Override
    public void resize(double ratio) {
        radius = (int) (radius * ratio);
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean isInside(int x, int y) {
        return ((Math.pow((x - xCenter), 2) + Math.pow((y - yCenter), 2)) <= Math.pow(radius, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return xCenter == circle.xCenter &&
                yCenter == circle.yCenter &&
                radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCenter, yCenter, radius);
    }
}
