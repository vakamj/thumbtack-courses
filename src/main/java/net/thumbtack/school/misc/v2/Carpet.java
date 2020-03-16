package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Point;
import net.thumbtack.school.iface.v2.Movable;

import java.util.Objects;

public class Carpet implements Movable {

    private static final int ZERO_CENTRE = 0;
    private static final int SIDE_VALUE = 1;
    private int xLeft, yTop, xRight, yBottom;

    public Carpet(Point leftTop, Point rightBottom) {
        this.xLeft = leftTop.getX();
        this.xRight = rightBottom.getX();
        this.yTop = leftTop.getY();
        this.yBottom = rightBottom.getY();
    }

    public Carpet(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom));
    }

    public Carpet(int length, int width) {
        this(ZERO_CENTRE, -width, length, ZERO_CENTRE);
    }

    public Carpet() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carpet carpet = (Carpet) o;
        return xLeft == carpet.xLeft &&
                yTop == carpet.yTop &&
                xRight == carpet.xRight &&
                yBottom == carpet.yBottom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xLeft, yTop, xRight, yBottom);
    }
}
