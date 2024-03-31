package edu.phystech.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RemoveNumberTest {

    private static int[] removeElements(int[] input, int element) {
        int count = 0;
        for (int num : input) {
            if (num == element) {
                count++;
            }
        }

        int[] result = new int[input.length - count];
        int index = 0;
        for (int num : input) {
            if (num != element) {
                result[index++] = num;
            }
        }

        return result;
    }

    @Test
    public void testRemoveN() {
        Assertions.assertArrayEquals(new int[]{1}, removeElements(new int[]{1, 2}, 2));
        Assertions.assertArrayEquals(new int[]{}, removeElements(new int[]{1}, 1));
    }

    @Test
    public void testRemoveReturnsNewArray() {
        int[] input = {9, 1, 3, 11, 3, 45, 499};
        int[] copy = Arrays.copyOf(input, input.length);

        int[] removed = removeElements(input, 3);

        Assertions.assertArrayEquals(new int[]{9, 1, 11, 45, 499}, removed);
        Assertions.assertArrayEquals(copy, input);
    }
}
