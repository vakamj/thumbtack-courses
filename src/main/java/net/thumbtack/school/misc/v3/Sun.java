package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.Point;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class Sun implements Colored {

    private static final int ZERO_CENTRE = 0;
    private static final int RADIUS_VALUE = 1;
    private Color color;
    private int xCenter, yCenter, radius;

    public Sun(Point center, int radius, Color color) {
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
        this.color = color;
    }

    public Sun(int xCenter, int yCenter, int radius, Color color) {
        this(new Point(xCenter, yCenter), radius, color);
    }

    public Sun(int radius, Color color) {
        this(new Point(ZERO_CENTRE, ZERO_CENTRE), radius, color);
    }

    public Sun(Color color) {
        this(new Point(ZERO_CENTRE, ZERO_CENTRE), RADIUS_VALUE, color);
    }

    public Sun() {
        this(new Point(ZERO_CENTRE, ZERO_CENTRE), RADIUS_VALUE, Color.GREEN);
    }

    public Sun(Point center, int radius, String colorString) throws ColorException {
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
        setColor(colorString);
    }

    public Sun(int xCenter, int yCenter, int radius, String colorString) throws ColorException {
        this(new Point(xCenter, yCenter), radius, colorString);
    }

    public Sun(int radius, String colorString) throws ColorException {
        this(new Point(ZERO_CENTRE, ZERO_CENTRE), radius, colorString);
    }

    public Sun(String colorString) throws ColorException {
        this(new Point(ZERO_CENTRE, ZERO_CENTRE), RADIUS_VALUE, colorString);
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
    public Color getColor() {
        return color;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sun sun = (Sun) o;
        return color == sun.color &&
                xCenter == sun.xCenter &&
                yCenter == sun.yCenter &&
                radius == sun.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, xCenter, yCenter, radius);
    }
}
