package code.code;

/**
 * 给你一个只包含 0 和 1 的?rows * columns?矩阵?mat?，请你返回有多少个?子矩形?的元素全部都是 1 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,0,1],
 * ?           [1,1,0],
 * ?           [1,1,0]]
 * 输出：13
 * 解释：
 * 有 6?个 1x1 的矩形。
 * 有 2 个 1x2 的矩形。
 * 有 3 个 2x1 的矩形。
 * 有 1 个 2x2 的矩形。
 * 有 1 个 3x1 的矩形。
 * 矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13?。
 * 示例 2：
 * <p>
 * 输入：mat = [[0,1,1,0],
 * ?           [0,1,1,1],
 * ?           [1,1,1,0]]
 * 输出：24
 * 解释：
 * 有 8 个 1x1 的子矩形。
 * 有 5 个 1x2 的子矩形。
 * 有 2 个 1x3 的子矩形。
 * 有 4 个 2x1 的子矩形。
 * 有 2 个 2x2 的子矩形。
 * 有 2 个 3x1 的子矩形。
 * 有 1 个 3x2 的子矩形。
 * 矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
 * 示例 3：
 * <p>
 * 输入：mat = [[1,1,1,1,1,1]]
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：mat = [[1,0,1],[0,1,0],[1,0,1]]
 * 输出：5
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= rows?<= 150
 * 1 <= columns?<= 150
 * 0 <= mat[i][j] <= 1
 * 通过次数6,269提交次数10,674
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-submatrices-with-all-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSubmat {

    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int height = mat[0].length;
        int[][] count = new int[row][height];
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < height; j++) {
                if (mat[i][j] == 0 || j == 0) {
                    count[i][j] = mat[i][j];
                } else {
                    count[i][j] = count[i][j - 1] + 1;
                }
                int col = count[i][j];
                for (int k = i; k >= 0 && col != 0; k--) {
                    col = Math.min(col, count[k][j]);
                    sum += col;
                }
            }
        }
        return sum;
    }
}
