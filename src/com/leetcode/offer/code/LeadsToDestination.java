package com.leetcode.offer.code;

/**
 * @author duson
 * 给定有向图的边?edges，以及该图的始点?source?和目标终点?destination，确定从始点?source?出发的所有路径是否最终结束于目标终点?destination，即：
 * <p>
 * 从始点?source 到目标终点?destination 存在至少一条路径
 * 如果存在从始点?source 到没有出边的节点的路径，则该节点就是路径终点。
 * 从始点source到目标终点?destination 可能路径数是有限数字
 * 当从始点?source 出发的所有路径都可以到达目标终点?destination 时返回?true，否则返回 false。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
 * 输出：false
 * 说明：节点 1 和节点 2 都可以到达，但也会卡在那里。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
 * 输出：false
 * 说明：有两种可能：在节点 3 处结束，或是在节点 1 和节点 2 之间无限循环。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
 * 输出：true
 * 示例 4：
 * <p>
 * <p>
 * <p>
 * 输入：n = 3, edges = [[0,1],[1,1],[1,2]], source = 0, destination = 2
 * 输出：false
 * 说明：从始点出发的所有路径都在目标终点结束，但存在无限多的路径，如 0-1-2，0-1-1-2，0-1-1-1-2，0-1-1-1-1-2 等。
 * 示例 5：
 * <p>
 * <p>
 * <p>
 * 输入：n = 2, edges = [[0,1],[1,1]], source = 0, destination = 1
 * 输出：false
 * 说明：在目标节点上存在无限的自环。
 * ?
 * <p>
 * 提示：
 * <p>
 * 给定的图中可能带有自环和平行边。
 * 图中的节点数?n?介于?1 和?10000?之间。
 * 图中的边数在?0 到?10000?之间。
 * 0 <= edges.length <= 10000
 * edges[i].length == 2
 * 0 <= source <= n - 1
 * 0 <= destination <= n - 1
 * 通过次数964提交次数3,153
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-lead-to-destination
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeadsToDestination {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        if (n <= 0 || edges == null || edges.length == 0) {
            return true;
        }
        Node[] graph = new Node[n];
        for (int[] edge : edges) {
            graph[edge[0]] = new Node(edge[1], graph[edge[0]]);
        }
        if (graph[destination] != null) {
            return false;
        }
        int[] visited = new int[n];
        return dfs(source, destination, graph, visited);
    }

    private boolean dfs(int start, int end, Node[] graph, int[] visited) {
        if (visited[start] == 1) {
            return false;
        }
        if (visited[start] == -1) {
            return true;
        }
        if (start == end) {
            visited[start] = -1;
            return true;
        }
        visited[start] = 1;
        Node cur = graph[start];
        if (cur == null) {
            return false;
        }
        while (cur != null) {
            if (!dfs(cur.ver, end, graph, visited)) {
                return false;
            }
            cur = cur.next;
        }
        visited[start] = -1;
        return true;
    }
}

class Node {
    int ver;
    Node next;

    Node(int ver, Node next) {
        this.ver = ver;
        this.next = next;
    }
}
