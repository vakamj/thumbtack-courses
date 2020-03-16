package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class ColoredRectangle extends Rectangle {

    private int color;
    private static final int ZERO_CENTRE = 0;
    private static final int SIDE_VALUE = 1;
    private static final int BASE_COLOR = 1;

    public ColoredRectangle(Point leftTop, Point rightBottom, int color) {
        super(leftTop, rightBottom);
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        super(xLeft, yTop, xRight, yBottom);
        this.color = color;
    }

    public ColoredRectangle(int length, int width, int color) {
        super(ZERO_CENTRE, -width, length, ZERO_CENTRE);
        this.color = color;
    }

    public ColoredRectangle(int color) {
        super(ZERO_CENTRE, -SIDE_VALUE, SIDE_VALUE, ZERO_CENTRE);
        this.color = color;
    }

    public ColoredRectangle() {
        super(ZERO_CENTRE, -SIDE_VALUE, SIDE_VALUE, ZERO_CENTRE);
        color = BASE_COLOR;
    }

    public Point getTopLeft() {
        return super.getTopLeft();
    }

    public void setTopLeft(Point topLeft) {
        super.setTopLeft(topLeft);
    }

    public Point getBottomRight() {
        return super.getBottomRight();
    }

    public void setBottomRight(Point bottomRight) {
        super.setBottomRight(bottomRight);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getLength() {
        return super.getLength();
    }

    public int getWidth() {
        return super.getWidth();
    }

    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        super.resize(ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        super.stretch(xRatio, yRatio);
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

    public boolean isInside(Point point) {
        return super.isInside(point);
    }

    public boolean isIntersects(ColoredRectangle rectangle) {
        return super.isIntersects(rectangle);
    }

    public boolean isInside(ColoredRectangle rectangle) {
        return super.isInside(rectangle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
