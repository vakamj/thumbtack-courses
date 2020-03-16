package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {

    private static final int ZERO_CENTRE = 0;
    private static final int SIDE_VALUE = 1;
    private static final Color BASE_COLOR = Color.RED;
    private Color color;

    public ColoredRectangle(Point leftTop, Point rightBottom, Color color) throws ColorException {
        super(leftTop, rightBottom);
        setColor(color);
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {
        super(xLeft, yTop, xRight, yBottom);
        setColor(color);
    }

    public ColoredRectangle(int length, int width, Color color) throws ColorException {
        super(ZERO_CENTRE, -width, length, ZERO_CENTRE);
        setColor(color);
    }

    public ColoredRectangle(Color color) throws ColorException {
        super(ZERO_CENTRE, -SIDE_VALUE, SIDE_VALUE, ZERO_CENTRE);
        setColor(color);
    }

    public ColoredRectangle(Point leftTop, Point rightBottom, String colorString) throws ColorException {
        super(leftTop, rightBottom);
        setColor(colorString);
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, String colorString) throws ColorException {
        super(xLeft, yTop, xRight, yBottom);
        setColor(colorString);
    }

    public ColoredRectangle(int length, int width, String colorString) throws ColorException {
        super(ZERO_CENTRE, -width, length, ZERO_CENTRE);
        setColor(colorString);
    }

    public ColoredRectangle(String colorString) throws ColorException {
        super(ZERO_CENTRE, -SIDE_VALUE, SIDE_VALUE, ZERO_CENTRE);
        setColor(colorString);
    }

    public ColoredRectangle() {
        super(ZERO_CENTRE, -SIDE_VALUE, SIDE_VALUE, ZERO_CENTRE);
        this.color = BASE_COLOR;
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

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        } else if ((color != Color.RED) && (color != Color.GREEN) && (color != Color.BLUE)) {
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        } else
            this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        if (colorString == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        } else if ((colorString != "GREEN") && (colorString != "RED") && (colorString != "BLUE")) {
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        } else
            this.color = Color.colorFromString(colorString);
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
