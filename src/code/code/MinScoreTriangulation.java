package code.code;

/**
 * @author duson
 * 给定?N，想象一个凸?N?边多边形，其顶点按顺时针顺序依次标记为?A[0], A[i], ..., A[N-1]。
 * <p>
 * 假设您将多边形剖分为 N-2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 N-2 个三角形的值之和。
 * <p>
 * 返回多边形进行三角剖分后可以得到的最低分。
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[3,7,4,5]
 * 输出：144
 * 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 * 示例 3：
 * <p>
 * 输入：[1,3,1,4,1,5]
 * 输出：13
 * 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 * ?
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 50
 * 1 <= A[i] <= 100
 * 通过次数2,098提交次数4,128
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-score-triangulation-of-polygon
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinScoreTriangulation {

    public int minScoreTriangulation(int[] a) {
        int l = a.length;
        int[][] dp = new int[l][l];
        for (int i = l - 3; i >= 0; i--) {
            for (int j = i + 2; j < l; j++) {
                for (int k = i + 1; k < j; k++) {
                    if (dp[i][j] == 0) {
                        dp[i][j] = dp[i][k] + dp[k][j] + a[i] * a[j] * a[k];
                    } else {
                        dp[i][j] = Math.min(dp[i][k] + dp[k][j] + a[i] * a[j] * a[k], dp[i][j]);
                    }
                }
            }
        }
        return dp[0][l - 1];
    }
}
