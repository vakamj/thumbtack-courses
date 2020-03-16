package net.thumbtack.school.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public int sum(int[] array) {
        int sum = 0;
        for (int anArray : array) {
            sum = sum + anArray;
        }
        return sum;
    }

    public int mul(int[] array) {
        int mul = 1;
        if (array.length == 0) {
            mul = 0;
        }
        for (int anArray : array) {
            mul = mul * anArray;
        }
        return mul;
    }

    public int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = array[0];
            if (array[i] < array[0]) {
                array[0] = array[i];
                min = array[0];
            }
        }
        return min;
    }

    public int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = array[0];
            if (array[i] > array[0]) {
                array[0] = array[i];
                max = array[0];
            }
        }
        return max;
    }

    public double average(int[] array) {
        double average = 0;
        double sum = 0;
        for (int anArray : array) {
            sum = sum + anArray;
            average = sum / (array.length);
        }
        return average;
    }

    public boolean isSortedDescendant(int[] array) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i - 1]) {
                break;
            }
            count++;
        }
        return array.length - 1 == count || array.length == 0;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        boolean isValue = false;
        for (int anArray : array) {
            if (anArray == value) {
                isValue = true;
                break;
            }
        }
        return isValue;
    }

    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int n = array[i];
            int m = array[array.length - i - 1];
            array[i] = m;
            array[array.length - i - 1] = n;
        }
    }

    public boolean isPalindrome(int[] array) {
        boolean isPalindrome = true;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - i - 1]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                sum = sum + anAMatrix;
            }
        }
        return sum;
    }

    public int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (max < aMatrix[j]) {
                    max = aMatrix[j];
                }
            }
        }
        return max;
    }

    public int diagonalMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j && max < matrix[i][j]) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        boolean isSortedMatrix = true;
        for (int[] aMatrix : matrix) {
            if (!isSortedDescendant(aMatrix)) {
                isSortedMatrix = false;
                break;
            }
        }
        return isSortedMatrix;
    }
}
