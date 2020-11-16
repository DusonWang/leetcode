package code.code;

/**
 * @author duson
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * <p>
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestSubarray {

    public int shortestSubarray(int[] a, int k) {
        int n = a.length;

        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + a[i];
        }
        int[] deque = new int[n + 1];
        int front = 0, back = 0;
        int minLength = n + 1;
        for (int i = 0; i <= n; i++) {
            while (front < back && preSum[i] - preSum[deque[front]] >= k) {
                minLength = Math.min(minLength, i - deque[front]);
                front++;
            }
            while (front < back && preSum[i] <= preSum[deque[back - 1]]) {
                back--;
            }
            deque[back++] = i;
        }
        return minLength == n + 1 ? -1 : minLength;
    }
}
