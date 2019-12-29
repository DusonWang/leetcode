package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：[-1,0,1]
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumZero {

    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n / 2; i++) {
            res[i * 2] = i + 1;
            res[i * 2 + 1] = -(i + 1);
        }
        return res;
    }
}
