package net.thumbtack.school.base;

import java.text.DecimalFormat;


public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int arrayLength = 0;
        for (String string : strings) {
            arrayLength += string.length();
        }
        return arrayLength;
    }

    public static String getFirstAndLastLetterString(String string) {
        return string.substring(0, 1) + string.substring(string.length() - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.substring(index, index + 1).equals(string2.substring(index, index + 1));
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return (string1.compareTo(string2) < 0);
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return (string1.compareToIgnoreCase(string2) < 0);
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; (i < string1.length() && i < string2.length()); i++) {
            if (string1.charAt(i) == string2.charAt(i)) {
                sb.append(string1.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static String reverse(String string) {
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return string.equalsIgnoreCase(reverse(string));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String longestPalindrome = "";
        for (String string : strings) {
            if (string.equalsIgnoreCase(reverse(string))) {
                if (string.length() > longestPalindrome.length()) {
                    longestPalindrome = string;
                }
            }
        }
        return longestPalindrome;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        return (index + length) <= string1.length() && (index + length) <= string2.length() &&
                string1.subSequence(index, index + length).equals(string2.subSequence(index, index + length));
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char
            replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        string1 = string1.replace(replaceInStr1, replaceByInStr1);
        string2 = string2.replace(replaceInStr2, replaceByInStr2);
        return string1.equals(string2);
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String
            replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        string1 = string1.replace(replaceInStr1, replaceByInStr1);
        string2 = string2.replace(replaceInStr2, replaceByInStr2);
        return string1.equals(string2);
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        StringBuilder sb = new StringBuilder(string.replaceAll(" ", ""));
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != (array.length - 1)) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#0.00");
        for (int i = 0; i < array.length; i++) {
            sb.append(df.format(array[i]));
            if (i != (array.length - 1)) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        return new StringBuilder(makeCsvStringFromInts(array));
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        return new StringBuilder(makeCsvStringFromDoubles(array));
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            boolean flag = true;
            for (int position : positions) {
                if (i == position) {
                    flag = false;
                }
            }
            if (flag) {
                sb.append(string.charAt(i));
            }
        }
        return sb;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < positions.length; j++) {
                if (i == positions[j]) {
                    sb.append(characters[j]);
                }
            }
            sb.append(string.charAt(i));
        }
        return sb;
    }
}
