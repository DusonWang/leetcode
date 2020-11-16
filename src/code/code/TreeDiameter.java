package code.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * 给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。
 * <p>
 * 我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。
 * <p>
 * 树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，每个节点上的标记都是独一无二的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：edges = [[0,1],[0,2]]
 * 输出：2
 * 解释：
 * 这棵树上最长的路径是 1 - 0 - 2，边数为 2。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
 * 输出：4
 * 解释：
 * 这棵树上最长的路径是 3 - 2 - 1 - 4 - 5，边数为 4。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= edges.length < 10^4
 * edges[i][0] != edges[i][1]
 * 0 <= edges[i][j] <= edges.length
 * edges 会形成一棵无向树
 * 通过次数1,058提交次数2,482
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tree-diameter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TreeDiameter {

    private int res;

    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = edges.length;
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        dfs(map, 0, visited);
        return res;
    }

    private int dfs(Map<Integer, List<Integer>> map, int node, boolean[] visited) {
        visited[node] = true;
        int max1 = 0;
        int max2 = 0;
        for (int child : map.get(node)) {
            if (!visited[child]) {
                int max = dfs(map, child, visited) + 1;
                if (max > max1) {
                    max2 = max1;
                    max1 = max;
                } else if (max > max2) {
                    max2 = max;
                }
            }
        }
        visited[node] = false;
        res = Math.max(res, max1 + max2);
        return max1;
    }
}
