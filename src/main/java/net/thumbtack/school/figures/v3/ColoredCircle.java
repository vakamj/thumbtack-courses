package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class ColoredCircle extends Circle implements Colored {

    private static final int ZERO_CENTRE = 0;
    private static final int RADIUS_VALUE = 1;
    private Color color;

    public ColoredCircle(Point center, int radius, Color color) throws ColorException {
        super(center, radius);
        setColor(color);
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, Color color) throws ColorException {
        super(xCenter, yCenter, radius);
        setColor(color);
    }

    public ColoredCircle(int radius, Color color) {
        super(ZERO_CENTRE, ZERO_CENTRE, radius);
        this.color = color;
    }

    public ColoredCircle(Color color) throws ColorException {
        super(ZERO_CENTRE, ZERO_CENTRE, RADIUS_VALUE);
        setColor(color);
    }

    public ColoredCircle() {
        super(ZERO_CENTRE, ZERO_CENTRE, RADIUS_VALUE);
        this.color = Color.RED;
    }

    public ColoredCircle(Point center, int radius, String colorString) throws ColorException {
        super(center, radius);
        setColor(colorString);
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, String colorString) throws ColorException {
        super(xCenter, yCenter, radius);
        setColor(colorString);
    }

    public ColoredCircle(int radius, String colorString) throws ColorException {
        super(ZERO_CENTRE, ZERO_CENTRE, radius);
        setColor(colorString);
    }

    public ColoredCircle(String colorString) throws ColorException {
        super(ZERO_CENTRE, ZERO_CENTRE, RADIUS_VALUE);
        setColor(colorString);
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
