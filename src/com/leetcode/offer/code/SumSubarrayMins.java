package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A <= 30000
 * 1 <= A[i] <= 30000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-subarray-minimums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumSubarrayMins {

    public int sumSubarrayMins(int[] a) {
        int len = a.length;
        int[] leftBigger = new int[len];
        int[] rightBigger = new int[len];

        for (int i = 0; i < len; i++) {
            int leftCount = 1;
            for (int j = i - 1; j >= 0 && a[j] >= a[i]; ) {
                leftCount += leftBigger[j];
                j -= leftBigger[j];
            }
            leftBigger[i] = leftCount;
        }

        for (int i = len - 1; i >= 0; i--) {
            int rightCount = 1;
            for (int j = i + 1; j < len && a[j] > a[i]; ) {
                rightCount += rightBigger[j];
                j += rightBigger[j];
            }
            rightBigger[i] = rightCount;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (a[i] * leftBigger[i] * rightBigger[i]) % (1000000007);
            sum %= 1000000007;
        }

        return sum;
    }
}
