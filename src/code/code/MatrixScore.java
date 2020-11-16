package code.code;

/**
 * @author duson
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MatrixScore {

    public int matrixScore(int[][] a) {
        int rr = a.length, cc = a[0].length;
        int ans = 0;
        for (int c = 0; c < cc; ++c) {
            int col = 0;
            for (int[] ints : a) {
                col += ints[c] ^ ints[0];
            }
            ans += Math.max(col, rr - col) * (1 << (cc - 1 - c));
        }
        return ans;
    }
}
