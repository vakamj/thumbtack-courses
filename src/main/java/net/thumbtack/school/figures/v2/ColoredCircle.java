package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.Colored;

import java.util.Objects;

public class ColoredCircle extends Circle implements Colored {

    private static final int ZERO_CENTRE = 0;
    private static final int RADIUS_VALUE = 1;
    private int color;

    public ColoredCircle(Point center, int radius, int color) {
        super(center, radius);
        this.color = color;
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, int color) {
        super(xCenter, yCenter, radius);
        this.color = color;
    }

    public ColoredCircle(int radius, int color) {
        super(ZERO_CENTRE, ZERO_CENTRE, radius);
        this.color = color;
    }

    public ColoredCircle(int color) {
        super(ZERO_CENTRE, ZERO_CENTRE, RADIUS_VALUE);
        this.color = color;
    }

    public ColoredCircle() {
        super(ZERO_CENTRE, ZERO_CENTRE, RADIUS_VALUE);
        color = 1;
    }

    public Point getCenter() {
        return super.getCenter();
    }

    public void setCenter(Point center) {
        super.setCenter(center);
    }

    public int getRadius() {
        return super.getRadius();
    }

    public void setRadius(int radius) {
        super.setRadius(radius);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        super.resize(ratio);
    }

    public double getArea() {
        return super.getArea();
    }

    public double getPerimeter() {
        return super.getPerimeter();
    }

    public boolean isInside(int x, int y) {
        return super.isInside(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredCircle that = (ColoredCircle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
