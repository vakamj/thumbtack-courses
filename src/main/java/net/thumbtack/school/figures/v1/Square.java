package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Square {

    private int xLeft, yTop, xRight, yBottom;
    private static final int ZERO_CENTRE = 0;
    private static final int SIDE_VALUE = 1;

    public Square(int xLeft, int yTop, int size) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.xRight = xLeft + size;
        this.yBottom = yTop + size;
    }

    public Square(Point leftTop, int size) {
        this(leftTop.getX(), leftTop.getY(), size);
    }

    public Square(int size) {
        this(ZERO_CENTRE, -size, size);
    }

    public Square() {
        this(ZERO_CENTRE, -SIDE_VALUE, SIDE_VALUE);
    }

    public Point getTopLeft() {
        return (new Point(xLeft, yTop));
    }

    public void setTopLeft(Point topLeft) {
        this.yBottom = topLeft.getY() + getLength();
        this.xRight = topLeft.getX() + getLength();
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
    }

    public Point getBottomRight() {
        return (new Point(xRight, yBottom));
    }

    public int getLength() {
        return Math.abs(xRight - xLeft);
    }

    public void moveTo(int x, int y) {
        yBottom = y + getLength();
        xRight = x + getLength();
        xLeft = x;
        yTop = y;
    }

    public void moveTo(Point point) {
        yBottom = point.getY() + getLength();
        xRight = point.getX() + getLength();
        xLeft = point.getX();
        yTop = point.getY();
    }

    public void moveRel(int dx, int dy) {
        xLeft += dx;
        yTop += dy;
        xRight += dx;
        yBottom += dy;
    }

    public void resize(double ratio) {
        yBottom = (int) (getLength() * ratio) + yTop;
        xRight = (int) (getLength() * ratio) + xLeft;
    }

    public double getArea() {
        return getLength() * getLength();
    }

    public double getPerimeter() {
        return 4 * getLength();
    }

    public boolean isInside(int x, int y) {
        return (x >= xLeft && x <= xRight && y >= yTop && y <= yBottom);
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Square square) {
        boolean result;
        if ((Math.abs(square.getBottomRight().getX()) - Math.abs(square.getTopLeft().getX())) <= (Math.abs(xRight) - Math.abs(xLeft))) {
            result =
                    (((square.getTopLeft().getX() >= xLeft && square.getTopLeft().getX() <= xRight) ||
                            (square.getBottomRight().getX() >= xLeft && square.getBottomRight().getX() <= xRight)) &&
                            ((square.getTopLeft().getY() >= yTop && square.getTopLeft().getY() <= yBottom) ||
                                    (square.getBottomRight().getY() >= yTop && square.getBottomRight().getY() <= yBottom)));
        } else {
            result =
                    (((xLeft >= square.getTopLeft().getX() && xRight <= square.getBottomRight().getX()) ||
                            (xRight >= square.getTopLeft().getX() && xRight <= square.getBottomRight().getX())) &&
                            ((yTop >= square.getBottomRight().getY() && yTop <= square.getBottomRight().getY()) ||
                                    (yBottom >= square.getTopLeft().getY() && yBottom <= square.getBottomRight().getY())));
        }
        return result;
    }

    public boolean isInside(Square square) {
        return (isInside(square.getTopLeft()) && isInside(square.getBottomRight()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return xLeft == square.xLeft &&
                yTop == square.yTop &&
                xRight == square.xRight &&
                yBottom == square.yBottom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xLeft, yTop, xRight, yBottom);
    }
}
