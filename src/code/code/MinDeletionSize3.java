package code.code;

import java.util.Arrays;

/**
 * 给定由N个小写字母字符串组成的数组A，其中每个字符串长度相等。
 * <p>
 * 选取一个删除索引序列，对于A中的每个字符串，删除对应每个索引处的字符。
 * <p>
 * 比如，有A = ["babca","bbazb"]，删除索引序列{0, 1, 4}，删除后A为["bc","az"]。
 * <p>
 * 假设，我们选择了一组删除索引D，那么在执行删除操作之后，最终得到的数组的行中的每个元素都是按字典序排列的。
 * <p>
 * 清楚起见，A[0]是按字典序排列的（即，A[0][0] <= A[0][1] <= ... <= A[0][A[0].length - 1]），A[1]是按字典序排列的（即，A[1][0] <= A[1][1] <= ... <= A[1][A[1].length - 1]），依此类推。
 * <p>
 * 请你返回D.length的最小可能值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["babca","bbazb"]
 * 输出：3
 * 解释：
 * 删除 0、1 和 4 这三列后，最终得到的数组是 A = ["bc", "az"]。
 * 这两行是分别按字典序排列的（即，A[0][0] <= A[0][1] 且 A[1][0] <= A[1][1]）。
 * 注意，A[0] > A[1] —— 数组 A 不一定是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：["edcba"]
 * 输出：4
 * 解释：如果删除的列少于 4 列，则剩下的行都不会按字典序排列。
 * 示例 3：
 * <p>
 * 输入：["ghi","def","abc"]
 * 输出：0
 * 解释：所有行都已按字典序排列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * 通过次数1,792提交次数3,253
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-columns-to-make-sorted-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDeletionSize3 {

    public int minDeletionSize(String[] a) {
        int m = a.length;
        int n = a[0].length();
        int res = n - 1;
        int k;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < j; ++i) {
                for (k = 0; k < m; ++k) {
                    if (a[k].charAt(i) > a[k].charAt(j)) {
                        break;
                    }
                }
                if (k == m && dp[i] + 1 > dp[j]) {
                    dp[j] = dp[i] + 1;
                }
            }
            res = Math.min(res, n - dp[j]);
        }
        return res;
    }

}
