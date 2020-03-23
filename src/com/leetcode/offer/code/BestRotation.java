package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个数组 A，我们可以将它按一个非负整数 K 进行轮调，这样可以使数组变为 A[K], A[K+1], A{K+2], ... A[A.length - 1], A[0], A[1], ..., A[K-1] 的形式。此后，任何值小于或等于其索引的项都可以记作一分。
 * <p>
 * 例如，如果数组为 [2, 4, 1, 3, 0]，我们按 K = 2 进行轮调后，它将变成 [1, 3, 0, 2, 4]。这将记作 3 分，因为 1 > 0 [no points], 3 > 1 [no points], 0 <= 2 [one point], 2 <= 3 [one point], 4 <= 4 [one point]。
 * <p>
 * 在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调索引 K。如果有多个答案，返回满足条件的最小的索引 K。
 * <p>
 * 示例 1：
 * 输入：[2, 3, 1, 4, 0]
 * 输出：3
 * 解释：
 * 下面列出了每个 K 的得分：
 * K = 0,  A = [2,3,1,4,0],    score 2
 * K = 1,  A = [3,1,4,0,2],    score 3
 * K = 2,  A = [1,4,0,2,3],    score 3
 * K = 3,  A = [4,0,2,3,1],    score 4
 * K = 4,  A = [0,2,3,1,4],    score 3
 * 所以我们应当选择 K = 3，得分最高。
 *  
 * <p>
 * 示例 2：
 * 输入：[1, 3, 0, 2, 4]
 * 输出：0
 * 解释：
 * A 无论怎么变化总是有 3 分。
 * 所以我们将选择最小的 K，即 0。
 * 提示：
 * <p>
 * A 的长度最大为 20000。
 * A[i] 的取值范围是 [0, A.length]。
 * 通过次数428提交次数1,146
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-rotation-with-highest-score
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestRotation {

    public int bestRotation(int[] a) {
        int n = a.length;
        int[] change = new int[n];
        for (int i = 0; i < n; ++i) {
            change[(i - a[i] + 1 + n) % n] -= 1;
        }
        int maxI = 0;
        for (int i = 1; i < n; ++i) {
            change[i] += change[i - 1] + 1;
            maxI = change[i] > change[maxI] ? i : maxI;
        }
        return maxI;
    }
}
