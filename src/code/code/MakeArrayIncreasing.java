package code.code;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author duson
 * 给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。
 * <p>
 * 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j < arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。
 * <p>
 * 如果无法让 arr1 严格递增，请返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
 * 输出：1
 * 解释：用 2 来替换 5，之后 arr1 = [1, 2, 3, 6, 7]。
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [4,3,1]
 * 输出：2
 * 解释：用 3 来替换 5，然后用 4 来替换 3，得到 arr1 = [1, 3, 4, 6, 7]。
 * 示例 3：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
 * 输出：-1
 * 解释：无法使 arr1 严格递增。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 2000
 * 0 <= arr1[i], arr2[i] <= 10^9
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/make-array-strictly-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MakeArrayIncreasing {

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length <= 1) {
            return 0;
        }
        int n = arr1.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] array : dp) {
            Arrays.fill(array, Integer.MAX_VALUE);
        }

        dp[0][0] = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr2) {
            set.add(num);
        }
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i <= j; i++) {
                if (arr1[j - 1] > dp[i][j - 1]) {
                    dp[i][j] = arr1[j - 1];
                }
                if (i > 0 && dp[i - 1][j - 1] != Integer.MAX_VALUE) {
                    Integer tempMin = set.ceiling(dp[i - 1][j - 1] + 1);
                    if (tempMin != null) {
                        dp[i][j] = Math.min(dp[i][j], tempMin);
                    }
                }
                if (j == n && dp[i][j] != Integer.MAX_VALUE) {
                    return i;
                }
            }
        }
        return -1;
    }
}
