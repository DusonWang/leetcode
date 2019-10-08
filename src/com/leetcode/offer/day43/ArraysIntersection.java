package com.leetcode.offer.day43;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。
 * <p>
 * 返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * 输出: [1,5]
 * 解释: 只有 1 和 5 同时在这三个数组中出现.
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-three-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArraysIntersection {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        for (; i < arr1.length && j < arr2.length && k < arr3.length; i++, j++, k++) {
            int a = arr1[i];
            int b = arr2[j];
            int c = arr3[k];
            if (a == b && b == c) {
                list.add(a);
            }
            if (a > b || a > c) {
                i--;
            }
            if (b > a || b > c) {
                j--;
            }
            if (c > a || c > b) {
                k--;
            }
        }
        return list;
    }

    public List<Integer> arraysIntersection2(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[2001];
        if (arr1 == null || arr2 == null || arr3 == null) {
            return res;
        }
        for (int i = arr1.length - 1; i >= 0; i--) {
            map[arr1[i]]++;
        }
        for (int i = arr2.length - 1; i >= 0; i--) {
            map[arr2[i]]++;
        }
        for (int value : arr3) {
            if (map[value] == 2) {
                res.add(value);
            }
        }
        return res;
    }
}
