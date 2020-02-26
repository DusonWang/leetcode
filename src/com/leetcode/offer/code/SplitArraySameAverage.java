package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）
 * <p>
 * 返回true ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空。
 * <p>
 * 示例:
 * 输入:
 * [1,2,3,4,5,6,7,8]
 * 输出: true
 * 解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
 * 注意:
 * <p>
 * A 数组的长度范围为 [1, 30].
 * A[i] 的数据范围为 [0, 10000].
 * 通过次数819提交次数3,280
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-with-same-average
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitArraySameAverage {

    private boolean check(int[] aa, int leftSum, int leftNum, int startIndex) {
        if (leftNum == 0) {
            return leftSum == 0;
        }
        if ((aa[startIndex]) > leftSum / leftNum) {
            return false;
        }
        for (int i = startIndex; i < aa.length - leftNum + 1; i++) {
            if (i > startIndex && aa[i] == aa[i - 1]) {
                continue;
            }
            if (check(aa, leftSum - aa[i], leftNum - 1, i + 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean splitArraySameAverage(int[] aa) {
        if (aa.length == 1) {
            return false;
        }
        int sumA = 0;
        for (int a : aa) {
            sumA += a;
        }
        Arrays.sort(aa);
        for (int lenOfB = 1; lenOfB <= aa.length / 2; lenOfB++) {
            if ((sumA * lenOfB) % aa.length == 0) {
                if (check(aa, (sumA * lenOfB) / aa.length, lenOfB, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
