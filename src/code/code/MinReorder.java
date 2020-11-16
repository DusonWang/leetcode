package code.code;

import java.util.*;

/**
 * @author duson
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * <p>
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * <p>
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * <p>
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * <p>
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 3：
 * <p>
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 * ?
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 * 通过次数2,503提交次数4,560
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinReorder {

    public int minReorder(int n, int[][] connections) {
        int result = 0;
        Map<Integer, Set<Integer>> connIdx = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < connections.length; i++) {
            int city1 = connections[i][0];
            int city2 = connections[i][1];
            if (!connIdx.containsKey(city1)) {
                connIdx.put(city1, new HashSet<>());
            }
            connIdx.get(city1).add(i);
            if (!connIdx.containsKey(city2)) {
                connIdx.put(city2, new HashSet<>());
            }
            connIdx.get(city2).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : connIdx.get(curr)) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                int a = connections[i][0];
                int b = connections[i][1];

                result += ((a == curr) ? 1 : 0);
                a = ((a == curr) ? b : a);
                queue.offer(a);
            }
        }
        return result;
    }
}
