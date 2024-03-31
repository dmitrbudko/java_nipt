package edu.phystech.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;

public class ReverseTest {

    private static int[] reverseArray(int[] nums) {
        int[] reversedArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reversedArray[i] = nums[nums.length - 1 - i];
        }
        return reversedArray;
    }

    @Test
    public void testReverseWorks() {
        Assertions.assertArrayEquals(new int[]{1}, reverseArray(new int[]{1}));
        Assertions.assertArrayEquals(new int[]{5, 4, 3, 2, 1}, reverseArray(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testReverseReturnsNewArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(input, input.length);

        int[] reversed = reverseArray(input);

        Assertions.assertArrayEquals(new int[]{5, 4, 3, 2, 1}, reversed);
        Assertions.assertArrayEquals(copy, input);
    }
}
