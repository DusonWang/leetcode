package com.leetcode.offer.day49;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            while (i < j && ((a[i] & 1) == 0)) {
                i++;
            }
            while (i < j && ((a[j] & 1) != 0)) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 2, 4};
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(a)));
    }
}
