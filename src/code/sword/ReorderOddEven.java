package com.leetcode.offer.sword;

import java.util.Arrays;

/**
 * @author duson
 */
public class ReorderOddEven {

    private static void reorder(int[] array, int length) {
        if (array == null || length <= 0) {
            return;
        }
        int start = 0;
        int end = length - 1;
        while (start < end) {

            while (start < end && !isEven(array[start])) {
                start++;
            }

            while (start < end && isEven(array[end])) {
                end--;
            }

            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    private static boolean isEven(int value) {
        return (value & 1) == 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};

        System.out.println("start order is " + Arrays.toString(array));

        reorder(array, array.length);

        System.out.println("end order is " + Arrays.toString(array));
    }

}
