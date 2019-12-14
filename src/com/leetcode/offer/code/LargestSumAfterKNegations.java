package com.leetcode.offer.code;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * <p>
 * 以这种方式修改数组后，返回数组可能的最大和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：
 * <p>
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * 示例 3：
 * <p>
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations2(int[] A, int K) {
        int len = A.length;
        Arrays.sort(A);
        for (int i = 0; i < len; i++) {
            if (A[i] == 0) {
                break;
            }
            if (K <= 0) {
                break;
            }
            if (A[i] < 0) {
                A[i] = (-1) * A[i];
                K--;
            }
        }
        Arrays.sort(A);
        int sum = 0;
        for (int value : A) {
            sum += value;
        }
        if (K % 2 == 1) {
            sum -= 2 * A[0];
        }
        return sum;
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int a : A) {
            q.add(a);
        }
        while (K > 0) {
            q.add(-q.poll());
            K--;
        }
        int res = 0;
        while (!q.isEmpty()) {
            res += q.poll();
        }
        return res;
    }
}
