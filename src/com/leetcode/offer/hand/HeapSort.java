package com.leetcode.offer.hand;

import java.util.Arrays;

/**
 * @author duson
 * <p>
 * maxheap 升序
 * minheap 降序
 */
public class HeapSort {

    private void maxHeapSift(int[] a, int start, int end) {
        int c = start;
        int l = 2 * c + 1;
        int tmp = a[c];
        for (; l <= end; c = l, l = 2 * l + 1) {
            if (l < end && a[l] < a[l + 1]) {
                l++;
            }
            if (tmp >= a[l]) {
                break;
            } else {
                a[c] = a[l];
                a[l] = tmp;
            }
        }
    }

    private void heapSortAsc(int[] a, int n) {
        int i, tmp;
        for (i = n / 2 - 1; i >= 0; i--) {
            maxHeapSift(a, i, n - 1);
        }

        for (i = n - 1; i > 0; i--) {
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            maxHeapSift(a, 0, i - 1);
        }
    }

    private void minHeapDown(int[] a, int start, int end) {
        int c = start;
        int l = 2 * c + 1;
        int tmp = a[c];
        for (; l <= end; c = l, l = 2 * l + 1) {
            if (l < end && a[l] > a[l + 1]) {
                l++;
            }
            if (tmp <= a[l]) {
                break;
            } else {
                a[c] = a[l];
                a[l] = tmp;
            }
        }
    }

    private void heapSortDesc(int[] a, int n) {
        int i, tmp;

        for (i = n / 2 - 1; i >= 0; i--) {
            minHeapDown(a, i, n - 1);
        }

        for (i = n - 1; i > 0; i--) {
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            minHeapDown(a, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        HeapSort heapSort = new HeapSort();

        System.out.println("[before]" + Arrays.toString(a));

        heapSort.heapSortAsc(a, a.length);
        //heapSortDesc(a, a.length);

        System.out.println("[after]" + Arrays.toString(a));

    }
}
