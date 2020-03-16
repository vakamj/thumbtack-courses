package net.thumbtack.school.iface.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;

public interface Colored {
    Color getColor();

    void setColor(Color color) throws ColorException;

    void setColor(String colorString) throws ColorException;
}
