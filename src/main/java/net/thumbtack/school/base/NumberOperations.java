package net.thumbtack.school.base;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberOperations {

    public static Integer find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return null;
    }

    public static Integer find(double[] array, double value, double eps) {
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >= value - (value % eps)) && (array[i] <= value + (value % eps))) {
                return i;
            }
        }
        return null;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        double density = weight / volume;
        if ((density >= min) && (density <= max)) {
            return density;
        }
        return null;
    }

    public static Integer find(BigInteger[] array, BigInteger value) {
        for (Integer i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return null;
    }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min,
                                              BigDecimal max) {
        BigDecimal density = weight.divide(volume);
        if ((density.floatValue() >= min.floatValue()) && (density.floatValue() <= max.floatValue())) {
            return density;
        }
        return null;
    }
}
