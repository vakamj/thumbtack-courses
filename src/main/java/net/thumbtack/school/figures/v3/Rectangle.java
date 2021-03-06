package net.thumbtack.school.figures.v3;

import net.thumbtack.school.iface.v3.HasArea;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.iface.v3.Stretchable;

import java.util.Objects;

public class Rectangle extends Figure implements Movable, Resizable, Stretchable, HasArea {

    private static final int ZERO_CENTRE = 0;
    private static final int SIDE_VALUE = 1;
    private int xLeft, yTop, xRight, yBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.xLeft = leftTop.getX();
        this.xRight = rightBottom.getX();
        this.yTop = leftTop.getY();
        this.yBottom = rightBottom.getY();
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom));
    }

    public Rectangle(int length, int width) {
        this(ZERO_CENTRE, -width, length, ZERO_CENTRE);
    }

    public Rectangle() {
        this(ZERO_CENTRE, -SIDE_VALUE, SIDE_VALUE, ZERO_CENTRE);
    }

    public Point getTopLeft() {
        return (new Point(xLeft, yTop));
    }

    public void setTopLeft(Point topLeft) {
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
    }

    public Point getBottomRight() {
        return (new Point(xRight, yBottom));
    }

    public void setBottomRight(Point bottomRight) {
        this.xRight = bottomRight.getX();
        this.yBottom = bottomRight.getY();
    }

    public int getLength() {
        return (xRight - xLeft);
    }

    public int getWidth() {
        return (yBottom - yTop);
    }

    @Override
    public void moveTo(int x, int y) {
        xRight = x + getLength();
        yBottom = y + getWidth();
        xLeft = x;
        yTop = y;
    }

    @Override
    public void moveRel(int dx, int dy) {
        xLeft += dx;
        yTop += dy;
        xRight += dx;
        yBottom += dy;
    }

    @Override
    public void resize(double ratio) {
        xRight = (int) (getLength() * ratio) + xLeft;
        yBottom = (int) (getWidth() * ratio) + yTop;
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        xRight = (int) (getLength() * xRatio) + xLeft;
        yBottom = (int) (getWidth() * yRatio) + yTop;
    }

    @Override
    public double getArea() {
        return getWidth() * getLength();
    }

    @Override
    public double getPerimeter() {
        return (2 * (xRight - xLeft) + 2 * (yBottom - yTop));
    }

    @Override
    public boolean isInside(int x, int y) {
        return (x >= xLeft && x <= xRight && y >= yTop && y <= yBottom);
    }

    public boolean isIntersects(Rectangle rectangle) {
        boolean result;
        int getAreaRectangle = (rectangle.getBottomRight().getX() - rectangle.getTopLeft().getX()) * (rectangle.getBottomRight().getY() - rectangle.getTopLeft().getY());
        if (getAreaRectangle <= getArea()) {
            result = (((rectangle.getTopLeft().getX() >= xLeft && rectangle.getTopLeft().getX() <= xRight) ||
                    (rectangle.getBottomRight().getX() >= xLeft && rectangle.getBottomRight().getX() <= xRight)) &&
                    ((rectangle.getTopLeft().getY() >= yTop && rectangle.getTopLeft().getY() <= yBottom) ||
                            (rectangle.getBottomRight().getY() >= yTop && rectangle.getBottomRight().getY() <= yBottom)));
        } else {
            result = (((xLeft >= rectangle.getTopLeft().getX() && xRight <= rectangle.getBottomRight().getX()) ||
                    (xRight >= rectangle.getTopLeft().getX() && xRight <= rectangle.getBottomRight().getX())) &&
                    ((yTop >= rectangle.yTop && yBottom <= rectangle.getTopLeft().getY()) ||
                            (yTop >= rectangle.getTopLeft().getY() && yBottom <= rectangle.getBottomRight().getY())));
        }
        return result;
    }

    public boolean isInside(Rectangle rectangle) {
        return (isInside(rectangle.getTopLeft()) && isInside(rectangle.getBottomRight()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(xLeft, yTop, xRight, yBottom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return xLeft == rectangle.xLeft &&
                yTop == rectangle.yTop &&
                xRight == rectangle.xRight &&
                yBottom == rectangle.yBottom;
    }
}
