package code.code;

/**
 * 给你一个整数数组?arr，每一次操作你都可以选择并删除它的一个 回文 子数组?arr[i], arr[i+1], ..., arr[j]（ i <= j）。
 * <p>
 * 注意，每当你删除掉一个子数组，右侧元素都会自行向前移动填补空位。
 * <p>
 * 请你计算并返回从数组中删除所有数字所需的最少操作次数。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,4,1,5]
 * 输出：3
 * 解释：先删除 [4]，然后删除 [1,3,1]，最后再删除 [5]。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 20
 * 通过次数1,072提交次数2,384
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-removal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumMoves {

    public int minimumMoves(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (i == j - 1) {
                    dp[i][j] = arr[i] == arr[j] ? 1 : 2;
                    continue;
                }
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][len - 1];
    }
}
