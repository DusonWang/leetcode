package code.hand;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author duson
 */
public class SortArray {

    private int partition(int[] array, int start, int end) {
        int temp = array[start];
        while (start < end) {
            while (start < end && array[end] >= temp) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] <= temp) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = temp;
        return start;
    }

    private void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }
        System.arraycopy(temp, 0, a, low, temp.length);
    }

    private void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int index = i - 1;
            while (index >= 0 && value < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = value;
        }
    }

    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int index = partition(array, start, end);
            quickSort(array, start, index - 1);
            quickSort(array, index + 1, end);
        }
    }

    private void quickSort2(int[] array, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        if (start < end) {
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(array, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r < index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }

    public static void main(String[] args) {

        SortArray sortArray = new SortArray();
        int[] array = new int[]{2, 1, 4, 5, 6};
        //quickSort2(array, 0, 4);
//        sortArray.insertSort(array);
        sortArray.mergeSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }
}
