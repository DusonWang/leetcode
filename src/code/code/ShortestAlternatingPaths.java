package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 在一个有向图中，节点分别标记为?0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。
 * <p>
 * red_edges?中的每一个?[i, j]?对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges?中的每一个?[i, j]?对表示从节点 i 到节点 j 的蓝色有向边。
 * <p>
 * 返回长度为 n 的数组?answer，其中?answer[X]?是从节点?0?到节点?X?的最短路径的长度，且路径上红色边和蓝色边交替出现。如果不存在这样的路径，那么 answer[x] = -1。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 示例 2：
 * <p>
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * 示例 3：
 * <p>
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * 示例 4：
 * <p>
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * 示例 5：
 * <p>
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 * 通过次数2,996提交次数8,883
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-with-alternating-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestAlternatingPaths {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> rg = new ArrayList<>();
        List<List<Integer>> bg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rg.add(new ArrayList<>());
            bg.add(new ArrayList<>());
        }
        for (int[] red : redEdges) {
            rg.get(red[0]).add(red[1]);
        }
        for (int[] blue : blueEdges) {
            bg.get(blue[0]).add(blue[1]);
        }
        int[][] ans = new int[n][2];
        for (int[] ansColor : ans) {
            ansColor[0] = Integer.MAX_VALUE;
            ansColor[1] = Integer.MAX_VALUE;
        }
        ans[0][0] = 0;
        ans[0][1] = 0;
        dfs(ans, 0, 0, rg, bg);
        dfs(ans, 1, 0, rg, bg);
        int[] finalAns = new int[n];
        for (int i = 0; i < n; i++) {
            finalAns[i] = Math.min(ans[i][0], ans[i][1]);
            if (finalAns[i] == Integer.MAX_VALUE) {
                finalAns[i] = -1;
            }
        }
        return finalAns;
    }

    private void dfs(int[][] ans, int color, int i, List<List<Integer>> rg, List<List<Integer>> bg) {
        List<List<Integer>> g = color == 0 ? rg : bg;
        for (int j : g.get(i)) {
            if (ans[i][color] + 1 < ans[j][Math.abs(color - 1)]) {
                ans[j][Math.abs(color - 1)] = ans[i][color] + 1;
                dfs(ans, Math.abs(color - 1), j, rg, bg);
            }
        }
    }
}
