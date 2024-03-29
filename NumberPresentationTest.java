package edu.phystech.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberPresentationTest {

    private static String convertToBase(int x, int base) {
        if (x == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        while (x > 0) {
            int remainder = x % base;
            if (remainder < 10) {
                result.insert(0, remainder);
            } else {
                char hexDigit = (char) ('a' + (remainder - 10));
                result.insert(0, hexDigit);
            }
            x = x / base;
        }
        return result.toString();
    }

    @Test
    public void binaryPresentation() {
        Assertions.assertEquals("0", convertToBase(0, 2));
        Assertions.assertEquals("1", convertToBase(1, 2));
        Assertions.assertEquals("10", convertToBase(2, 2));
        Assertions.assertEquals("100", convertToBase(4, 2));
        Assertions.assertEquals("10000000", convertToBase(128, 2));
        Assertions.assertEquals("11111111", convertToBase(255, 2));
        Assertions.assertEquals("100101100100110000010", convertToBase(1231234, 2));
    }

    @Test
    public void octPresentation() {
        for (int i = 0; i < 8; ++i) {
            Assertions.assertEquals(String.valueOf(i), convertToBase(i, 8));
        }
        Assertions.assertEquals("10", convertToBase(8, 8));
        Assertions.assertEquals("100", convertToBase(64, 8));
        Assertions.assertEquals("200", convertToBase(128, 8));
        Assertions.assertEquals("377", convertToBase(255, 8));
        Assertions.assertEquals("4544602", convertToBase(1231234, 8));
    }

    @Test
    public void hexPresentation() {
        for (int i = 0; i < 10; ++i) {
            Assertions.assertEquals(String.valueOf(i), convertToBase(i, 16));
        }
        Assertions.assertEquals("10", convertToBase(16, 16));
        Assertions.assertEquals("100", convertToBase(256, 16));
        Assertions.assertEquals("200", convertToBase(512, 16));
        Assertions.assertEquals("21e", convertToBase(542, 16));
        Assertions.assertEquals("45b0c2", convertToBase(4567234, 16));
    }
}
