package com.leetcode.offer.code;

/**
 * @author duson
 * 在?R?行?C?列的矩阵上，我们从?(r0, c0)?面朝东面开始
 * <p>
 * 这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
 * <p>
 * 现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。
 * <p>
 * 每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。
 * <p>
 * 最终，我们到过网格的所有?R * C?个空间。
 * <p>
 * 按照访问顺序返回表示网格位置的坐标列表。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：R = 1, C = 4, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1],[0,2],[0,3]]
 * <p>
 * <p>
 * ?
 * <p>
 * 示例 2：
 * <p>
 * 输入：R = 5, C = 6, r0 = 1, c0 = 4
 * 输出：[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 * 通过次数2,013提交次数3,062
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrixIII {

    public int[][] spiralMatrixIII(int r, int c, int r0, int c0) {
        int[][] res = new int[r * c][2];
        res[0] = new int[]{r0, c0};
        int count = 1;
        int step = 0;
        int[] dirs = {0, 1, 0, -1, 0};
        int dx = r0;
        int dy = c0;
        int k = 0;
        while (count < r * c) {
            if (k == 0 || k == 2) {
                step++;
            }
            for (int i = 0; i < step; i++) {
                dx += dirs[k];
                dy += dirs[k + 1];
                if (dx >= 0 && dx < r && dy >= 0 && dy < c) {
                    res[count][0] = dx;
                    res[count][1] = dy;
                    count++;
                }
            }
            k = (k + 1) % 4;
        }
        return res;
    }
}
