package code.code;

/**
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * <p>
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * <p>
 * ?
 * <p>
 * 示例? 1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],
 * ?           [4,5,6],
 * ?           [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * 示例? 2：
 * <p>
 * 输入：mat = [[1,1,1,1],
 * ?           [1,1,1,1],
 * ?           [1,1,1,1],
 * ?           [1,1,1,1]]
 * 输出：8
 * 示例 3：
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 * ?
 * <p>
 * 提示：
 * <p>
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 * 通过次数14,614提交次数18,111
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-diagonal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiagonalSum {


    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int len = mat.length;
        for (int i = 0; i < len; i++) {
            if (i != len - i - 1) {
                sum += (mat[i][i] + mat[i][len - i - 1]);
            } else {
                sum += mat[i][i];
            }
        }
        return sum;
    }
}
