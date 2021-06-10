package code.code;

/**
 * 给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
 * <p>
 * 在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
 * <p>
 * 返回 最大非负积 对 109+ 7 取余 的结果。如果最大积为负数，则返回 -1 。
 * <p>
 * 注意，取余是在得到最大积之后执行的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[-1,-2,-3],
 * [-2,-3,-3],
 * [-3,-3,-2]]
 * 输出：-1
 * 解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1
 * 示例 2：
 * <p>
 * 输入：grid = [[1,-2,1],
 * [1,-2,1],
 * [3,-4,1]]
 * 输出：8
 * 解释：最大非负积对应的路径已经用粗体标出 (1 * 1 * -2 * -4 * 1 = 8)
 * 示例 3：
 * <p>
 * 输入：grid = [[1, 3],
 * [0,-4]]
 * 输出：0
 * 解释：最大非负积对应的路径已经用粗体标出 (1 * 0 * -4 = 0)
 * 示例 4：
 * <p>
 * 输入：grid = [[ 1, 4,4,0],
 * [-2, 0,0,1],
 * [ 1,-1,1,1]]
 * 输出：2
 * 解释：最大非负积对应的路径已经用粗体标出 (1 * -2 * 1 * -1 * 1 * 1 = 2)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= rows, cols <= 15
 * -4 <= grid[i][j] <= 4
 * 通过次数3,735提交次数12,108
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-non-negative-product-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProductPath {

    private long result = -1;

    public int maxProductPath(int[][] grid) {
        dfs(grid, 0, 0, grid[0][0]);
        return (int) (result % 1000000007);
    }

    private void dfs(int[][] grid, int i, int j, long curr) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            result = Math.max(result, curr);
            return;
        }
        if (grid[i][j] == 0) {
            result = Math.max(result, 0);
            return;
        }
        if (i + 1 < grid.length) {
            dfs(grid, i + 1, j, curr * grid[i + 1][j]);
        }
        if (j + 1 < grid[0].length) {
            dfs(grid, i, j + 1, curr * grid[i][j + 1]);
        }
    }

}
