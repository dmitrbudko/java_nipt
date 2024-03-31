package edu.phystech.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FindNumberTest {
    private static int findNumber(int[] input, int element) {
        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (input[mid] == element) {
                return mid;
            } else if (input[mid] < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Элемент не найден
    }


    @Test
    public void justWorks() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < 5; ++i) {
            Assertions.assertEquals(i, findNumber(array, i + 1));
        }
        Assertions.assertEquals(-1, findNumber(array, 10));
    }

    @Test
    public void worksCornerCases() {
        Assertions.assertEquals(-1, findNumber(new int[] {}, 10));
        Assertions.assertEquals(0, findNumber(new int[] {1}, 1));
    }
}