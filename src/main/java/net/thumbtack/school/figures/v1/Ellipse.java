package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Ellipse {
    private int xCenter, yCenter, xAxis, yAxis;
    private static final int ZERO_CENTRE = 0;
    private static final int AXIS_VALUE = 1;


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

    public void moveTo(int x, int y) {
        xCenter = x;
        yCenter = y;
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        xCenter += dx;
        yCenter += dy;
    }

    public void resize(double ratio) {
        xAxis = (int) (xAxis * ratio);
        yAxis = (int) (yAxis * ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        xAxis = (int) (xAxis * xRatio);
        yAxis = (int) (yAxis * yRatio);
    }

    public double getArea() {
        return Math.PI * xAxis * yAxis / 4;
    }

    public double getPerimeter() {
        return (2 * Math.PI * Math.sqrt((Math.pow(xAxis, 2) + Math.pow(yAxis, 2)) / 8.0));
    }

    public boolean isInside(int x, int y) {
        return ((Math.pow((x - xCenter), 2)) / (Math.pow(xAxis, 2) / 4) + (Math.pow((y - yCenter), 2)) / (Math.pow(yAxis, 2) / 4)) <= 1;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
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
