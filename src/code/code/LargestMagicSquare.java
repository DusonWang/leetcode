package code.code;

/**
 * 一个k x k的幻方指的是一个k x k填满整数的方格阵，且每一行、每一列以及两条对角线的和 全部相等。幻方中的整数 不需要互不相同。显然，每个1 x 1的方格都是一个幻方。
 * <p>
 * 给你一个m x n的整数矩阵grid，请你返回矩阵中最大幻方的尺寸（即边长 k）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
 * 输出：3
 * 解释：最大幻方尺寸为 3 。
 * 每一行，每一列以及两条对角线的和都等于 12 。
 * - 每一行的和：5+1+6 = 5+4+3 = 2+7+3 = 12
 * - 每一列的和：5+5+2 = 1+4+7 = 6+3+3 = 12
 * - 对角线的和：5+4+3 = 6+4+2 = 12
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j] <= 106
 * 通过次数1,527提交次数2,930
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-magic-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestMagicSquare {

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 1;
        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int step = result; i + step < m && j + step < n; step++) {
                    if (isMagic(grid, rowSum, colSum, i, j, step)) {
                        result = step + 1;
                    }
                }
            }
        }
        return result;
    }

    private boolean isMagic(int[][] grid, int[][] rowSum, int[][] colSum, int x1, int y1, int step) {
        int sum = 0;
        int subsum = 0;
        for (int i = 0; i <= step; i++) {
            sum += grid[x1 + i][y1 + i];
            subsum += grid[x1 + step - i][y1 + i];
        }
        if (sum != subsum) {
            return false;
        }
        for (int i = 0; i <= step; i++) {
            if (sum != rowSum[x1 + i][y1 + step + 1] - rowSum[x1 + i][y1]) {
                return false;
            }
            if (sum != colSum[x1 + step + 1][y1 + i] - colSum[x1][y1 + i]) {
                return false;
            }
        }
        return true;
    }

}
