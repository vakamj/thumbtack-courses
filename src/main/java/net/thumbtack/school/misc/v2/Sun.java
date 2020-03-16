package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Point;
import net.thumbtack.school.iface.v2.Colored;

import java.util.Objects;

public class Sun implements Colored {

    private static final int ZERO_CENTRE = 0;
    private static final int RADIUS_VALUE = 1;
    private int color, xCenter, yCenter, radius;

    public Sun(Point center, int radius, int color) {
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
        this.color = color;
    }

    public Sun(int xCenter, int yCenter, int radius, int color) {
        this(new Point(xCenter, yCenter), radius, color);
    }

    public Sun(int radius, int color) {
        this(new Point(ZERO_CENTRE, ZERO_CENTRE), radius, color);
    }

    public Sun(int color) {
        this(new Point(ZERO_CENTRE, ZERO_CENTRE), RADIUS_VALUE, color);
    }

    public Sun() {
        this(new Point(ZERO_CENTRE, ZERO_CENTRE), RADIUS_VALUE, 1);
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
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sun sun = (Sun) o;
        return color == sun.color &&
                xCenter == sun.xCenter &&
                yCenter == sun.yCenter &&
                radius == sun.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, xCenter, yCenter, radius);
    }
}
