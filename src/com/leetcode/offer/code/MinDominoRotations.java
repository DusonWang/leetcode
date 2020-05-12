package com.leetcode.offer.code;

/**
 * @author duson
 * 在一排多米诺骨牌中，A[i] 和 B[i]?分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的?—— 该平铺的每一半上都有一个数字。）
 * <p>
 * 我们可以旋转第?i?张多米诺，使得?A[i] 和?B[i]?的值交换。
 * <p>
 * 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。
 * <p>
 * 如果无法做到，返回?-1.
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * 输出：2
 * 解释：
 * 图一表示：在我们旋转之前， A 和 B 给出的多米诺牌。
 * 如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
 * 示例 2：
 * <p>
 * 输入：A = [3,5,1,2,3], B = [3,6,3,3,4]
 * 输出：-1
 * 解释：
 * 在这种情况下，不可能旋转多米诺牌使一行的值相等。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 * 通过次数2,828提交次数6,388
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-domino-rotations-for-equal-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDominoRotations {

    public int minDominoRotations(int[] A, int[] B) {
        int min = A.length;
        min = Math.min(min, count(A, B, A[0]));
        if (A[0] != B[0]) {
            min = Math.min(min, count(A, B, B[0]));
        }
        return min == A.length ? -1 : min;
    }

    private int count(int[] A, int[] B, int number) {
        int commons = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != number && B[i] != number) {
                return A.length;
            } else if (A[i] != B[i]) {
                if (A[i] == number) {
                    a++;
                } else {
                    b++;
                }
            }
        }
        return Math.min(a, b);
    }
}
