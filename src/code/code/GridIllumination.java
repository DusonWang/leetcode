package code.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 在N x N的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。
 * <p>
 * 数组lamps 表示打开的灯的位置。lamps[i] = [rowi, coli] 表示 打开 位于 grid[rowi][coli] 的第 i 盏灯 。每盏灯都照亮自身单元格以及同一行、同一列和两条对角线上的所有其他单元格。
 * <p>
 * 查询数组 queries 中，第 i 次查询queries[i] = [rowi, coli]，如果单元格 [rowi, coli] 是被照亮的，则查询结果为 1 ，否则为 0 。在第 i 次查询之后 [按照查询的顺序] ，关闭 位于单元格 grid[rowi][coli] 上或其相邻 8 个方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。
 * <p>
 * 返回答案数组 ans ， answer[i] 应等于第 i次查询queries[i]的结果，1 表示照亮，0 表示未照亮。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
 * 输出：[1,0]
 * 解释：最初所有灯都是关闭的。在执行查询之前，打开位于 [0, 0] 和 [4, 4] 的灯。第 0次查询检查 grid[1][1] 是否被照亮（蓝色方框）。该单元格被照亮，所以 ans[0] = 1 。然后，关闭红色方框中的所有灯。
 * <p>
 * 第 1次查询检查 grid[1][0] 是否被照亮（蓝色方框）。该单元格没有被照亮，所以 ans[1] = 0 。然后，关闭红色矩形中的所有灯。
 * <p>
 * 示例 2：
 * <p>
 * 输入：N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
 * 输出：[1,1]
 * 示例 3：
 * <p>
 * 输入：N = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
 * 输出：[1,1,0]
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 109
 * 0 <= lamps.length <= 20000
 * lamps[i].length == 2
 * 0 <= lamps[i][j] < N
 * 0 <= queries.length <= 20000
 * queries[i].length == 2
 * 0 <= queries[i][j] < N
 * 通过次数1,925提交次数6,609
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grid-illumination
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GridIllumination {

    private final int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    private final int[] dy = {1, 0, -1, 1, 0, -1, 1, 0, -1};

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        HashMap<Integer, Integer> d = new HashMap<>();
        HashMap<Integer, Integer> ud = new HashMap<>();
        Set<Long> set = new HashSet<>();
        for (int[] l : lamps) {
            if (set.contains(((long) N * l[0]) + l[1])) {
                continue;
            }
            row.put(l[0], row.getOrDefault(l[0], 0) + 1);
            col.put(l[1], col.getOrDefault(l[1], 0) + 1);
            d.put(l[0] - l[1], d.getOrDefault(l[0] - l[1], 0) + 1);
            ud.put(l[0] + l[1], ud.getOrDefault(l[0] + l[1], 0) + 1);
            set.add((long) N * l[0] + l[1]);
        }
        int len = queries.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int[] cur = queries[i];
            if (row.getOrDefault(cur[0], 0) > 0
                    || col.getOrDefault(cur[1], 0) > 0
                    || d.getOrDefault(cur[0] - cur[1], 0) > 0
                    || ud.getOrDefault(cur[0] + cur[1], 0) > 0) {
                res[i] = 1;
            }
            for (int j = 0; j < 9; j++) {
                int tx = dx[j] + cur[0];
                int ty = dy[j] + cur[1];
                if (tx < 0 || tx >= N || ty < 0 || ty >= N) {
                    continue;
                }
                if (set.contains((long) tx * N + ty)) {
                    set.remove((long) tx * N + ty);
                    row.put(tx, row.get(tx) - 1);
                    col.put(ty, col.get(ty) - 1);
                    d.put(tx - ty, d.get(tx - ty) - 1);
                    ud.put(tx + ty, ud.get(tx + ty) - 1);
                }
            }
        }
        return res;
    }
}
