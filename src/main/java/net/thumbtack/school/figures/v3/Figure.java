package net.thumbtack.school.figures.v3;

import net.thumbtack.school.iface.v3.HasArea;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;

abstract class Figure implements HasArea, Resizable, Movable {

    abstract public void moveTo(int x, int y);

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    abstract public void moveRel(int dx, int dy);

    abstract public void resize(double ratio);

    abstract public double getArea();

    abstract public double getPerimeter();

    abstract public boolean isInside(int x, int y);

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

}
