package com.leetcode.offer.day41;

/**
 * @author duson
 * 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：A = [1,0,1,0,1], S = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] 为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSubarraysWithSum {

    public int numSubarraysWithSum(int[] a, int s) {
        int[] count = new int[30001];
        int result = 0;
        count[0] = 1;
        int total = 0;
        for (int aa : a) {
            total += aa;
            if (total >= s) {
                result += count[total - s];
            }
            count[total]++;
        }
        return result;
    }
}
