package net.thumbtack.school.figures.v3;

import net.thumbtack.school.iface.v3.HasArea;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.iface.v3.Stretchable;

import java.util.Objects;

public class Ellipse extends Figure implements Movable, Resizable, Stretchable, HasArea {
    private static final int ZERO_CENTRE = 0;
    private static final int AXIS_VALUE = 1;
    private static final int CONSTANT_TWO = 2;
    private int xCenter, yCenter, xAxis, yAxis;

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(Point center, int xAxis, int yAxis) {
        this(center.getX(), center.getY(), xAxis, yAxis);
    }

    public Ellipse(int xAxis, int yAxis) {
        this(ZERO_CENTRE, ZERO_CENTRE, xAxis, yAxis);
    }

    public Ellipse() {
        this(ZERO_CENTRE, ZERO_CENTRE, AXIS_VALUE, AXIS_VALUE);
    }

    public Point getCenter() {
        return (new Point(xCenter, yCenter));
    }

    public void setCenter(Point center) {
        this.xCenter = center.getX();
        this.yCenter = center.getY();
    }

    public int getXAxis() {
        return xAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
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
        xAxis = (int) (xAxis * ratio);
        yAxis = (int) (yAxis * ratio);
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        xAxis = (int) (xAxis * xRatio);
        yAxis = (int) (yAxis * yRatio);
    }

    @Override
    public double getArea() {
        return Math.PI * xAxis * yAxis / 4;
    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * Math.sqrt((Math.pow(xAxis, CONSTANT_TWO) + Math.pow(yAxis, CONSTANT_TWO)) / 8.0));
    }

    @Override
    public boolean isInside(int x, int y) {
        return ((Math.pow((x - xCenter), CONSTANT_TWO)) / (Math.pow(xAxis, 2) / 4) +
                (Math.pow((y - yCenter), CONSTANT_TWO)) / (Math.pow(yAxis, CONSTANT_TWO) / 4)) <= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return xCenter == ellipse.xCenter &&
                yCenter == ellipse.yCenter &&
                xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCenter, yCenter, xAxis, yAxis);
    }
}
