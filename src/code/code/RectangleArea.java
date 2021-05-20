package code.code;

import java.util.*;

/**
 * 我们给出了一个（轴对齐的）矩形列表?rectangles?。 对于?rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是矩形?i?左下角的坐标，（x2，y2）是该矩形右上角的坐标。
 * <p>
 * 找出平面中所有矩形叠加覆盖后的总面积。 由于答案可能太大，请返回它对 10 ^ 9 + 7 取模的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[0,0,2,2],[1,0,2,3],[1,0,3,1]]
 * 输出：6
 * 解释：如图所示。
 * 示例 2：
 * <p>
 * 输入：[[0,0,1000000000,1000000000]]
 * 输出：49
 * 解释：答案是 10^18 对 (10^9 + 7) 取模的结果， 即 (10^9)^2 → (-7)^2 = 49 。
 * 提示：
 * <p>
 * 1 <= rectangles.length <= 200
 * rectanges[i].length = 4
 * 0 <= rectangles[i][j] <= 10^9
 * 矩形叠加覆盖后的总面积不会超越?2^63 - 1?，这意味着可以用一个?64 位有符号整数来保存面积结果。
 * 通过次数2,014提交次数4,621
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RectangleArea {

    public int rectangleArea(int[][] rectangles) {
        Set<Integer> xs = new HashSet<>();
        Set<Integer> ys = new HashSet<>();
        for (int[] rec : rectangles) {
            xs.add(rec[0]);
            xs.add(rec[2]);
            ys.add(rec[1]);
            ys.add(rec[3]);
        }
        Integer[] imapx = xs.toArray(new Integer[0]);
        Arrays.sort(imapx);
        Integer[] imply = ys.toArray(new Integer[0]);
        Arrays.sort(imply);
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        for (int i = 0; i < imapx.length; ++i) {
            mapX.put(imapx[i], i);
        }
        for (int i = 0; i < imply.length; ++i) {
            mapY.put(imply[i], i);
        }
        boolean[][] grid = new boolean[imapx.length][imply.length];
        for (int[] rec : rectangles) {
            for (int x = mapX.get(rec[0]); x < mapX.get(rec[2]); ++x) {
                for (int y = mapY.get(rec[1]); y < mapY.get(rec[3]); ++y) {
                    grid[x][y] = true;
                }
            }
        }
        long ans = 0;
        for (int x = 0; x < grid.length; ++x) {
            for (int y = 0; y < grid[0].length; ++y) {
                if (grid[x][y]) {
                    ans += (long) (imapx[x + 1] - imapx[x]) * (imply[y + 1] - imply[y]);
                }
            }
        }
        return (int) (ans % 1_000_000_007);
    }
}
