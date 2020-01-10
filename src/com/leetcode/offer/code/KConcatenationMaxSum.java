package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个整数数组 arr 和一个整数 k。
 * <p>
 * 首先，我们要对该数组进行修改，即把原数组 arr 重复 k 次。
 * <p>
 * 举个例子，如果 arr = [1, 2] 且 k = 3，那么修改后的数组就是 [1, 2, 1, 2, 1, 2]。
 * <p>
 * 然后，请你返回修改后的数组中的最大的子数组之和。
 * <p>
 * 注意，子数组长度可以是 0，在这种情况下它的总和也是 0。
 * <p>
 * 由于 结果可能会很大，所以需要 模（mod） 10^9 + 7 后再返回。 
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2], k = 3
 * 输出：9
 * 示例 2：
 * <p>
 * 输入：arr = [1,-2,1], k = 5
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：arr = [-1,-2], k = 7
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= k <= 10^5
 * -10^4 <= arr[i] <= 10^4
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-concatenation-maximum-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KConcatenationMaxSum {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1_000_000_007;
        int headMax = 0;
        int sum = 0;
        for (int value : arr) {
            sum += value;
            headMax = Math.max(headMax, sum);
        }
        int tailMax = 0;
        sum = 0;
        for (int i = arr.length - 1; i >= 0; --i) {
            sum += arr[i];
            tailMax = Math.max(tailMax, sum);
        }
        int max = 0;
        int cur = 0;
        for (int value : arr) {
            cur += value;
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }

        if (k == 1) {
            return max;
        }
        return Math.max(max, Math.max((headMax + tailMax) % mod, (int) (((long) sum * (k - 2)) % mod + headMax + tailMax) % mod));
    }

}

