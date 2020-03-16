package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Point;
import net.thumbtack.school.iface.v2.HasArea;

import java.util.Objects;

public class ProhibitingRoadSign implements HasArea {
    private int xCenter, yCenter, radius;


    public ProhibitingRoadSign(Point center, int radius) {
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
    }

    public ProhibitingRoadSign(int xCenter, int yCenter, int radius) {
        this(new Point(xCenter, yCenter), radius);
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
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProhibitingRoadSign that = (ProhibitingRoadSign) o;
        return xCenter == that.xCenter &&
                yCenter == that.yCenter &&
                radius == that.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCenter, yCenter, radius);
    }
}
