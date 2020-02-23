package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个只包含 0 和 1 的网格，找出其中角矩形的数量。
 * <p>
 * 一个 角矩形 是由四个不同的在网格上的 1 形成的轴对称的矩形。注意只有角的位置才需要为 1。并且，4 个 1 需要是不同的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid =
 * [[1, 0, 0, 1, 0],
 * [0, 0, 1, 0, 1],
 * [0, 0, 0, 1, 0],
 * [1, 0, 1, 0, 1]]
 * 输出：1
 * 解释：只有一个角矩形，角的位置为 grid[1][2], grid[1][4], grid[3][2], grid[3][4]。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid =
 * [[1, 1, 1],
 * [1, 1, 1],
 * [1, 1, 1]]
 * 输出：9
 * 解释：这里有 4 个 2x2 的矩形，4 个 2x3 和 3x2 的矩形和 1 个 3x3 的矩形。
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid =
 * [[1, 1, 1, 1]]
 * 输出：0
 * 解释：矩形必须有 4 个不同的角。
 *  
 * <p>
 * 注：
 * <p>
 * 网格 grid 中行和列的数目范围为 [1, 200]。
 * Each grid[i][j] will be either 0 or 1.
 * 网格中 1 的个数不会超过 6000。
 *  
 * <p>
 * 通过次数577提交次数793
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-corner-rectangles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountCornerRectangles {

    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        int row = grid.length, col = grid[0].length;
        if (row == 1) {
            return res;
        }
        for (int r1 = 0; r1 < row; r1++) {
            for (int r2 = r1 + 1; r2 < row; r2++) {
                int count = 0;
                for (int j = 0; j < col; j++) {
                    if (grid[r1][j] == 1 && grid[r2][j] == 1) {
                        count++;
                    }
                }
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }
}
