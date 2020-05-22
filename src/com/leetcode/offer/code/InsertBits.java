package com.leetcode.offer.code;

/**
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 * <p>
 * 示例1:
 * <p>
 * 输入：N = 10000000000, M = 10011, i = 2, j = 6
 * 输出：N = 10001001100
 * 示例2:
 * <p>
 * 输入： N = 0, M = 11111, i = 0, j = 4
 * 输出：N = 11111
 * 通过次数1,554提交次数3,241
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertBits {

    public int insertBits(int n, int m, int i, int j) {
        for (int k = i; k < j + 1; k++) {
            n = n & Integer.rotateLeft(~1, k);
        }
        return n | (m << i);
    }

}
