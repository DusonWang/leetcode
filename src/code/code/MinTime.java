package code.code;


import java.util.*;

/**
 * 给你一棵有?n?个节点的无向树，节点编号为?0?到?n-1?，它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。你从?节点 0?出发，请你返回最少需要多少秒，可以收集到所有苹果，并回到节点 0 。
 * <p>
 * 无向树的边由?edges?给出，其中?edges[i] = [fromi, toi]?，表示有一条边连接?from?和?toi 。除此以外，还有一个布尔数组?hasApple ，其中?hasApple[i] = true?代表节点?i?有一个苹果，否则，节点?i?没有苹果。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * 输出：8
 * 解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
 * 输出：6
 * 解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
 * 示例 3：
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
 * 输出：0
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * edges.length == n-1
 * edges[i].length == 2
 * 0 <= fromi, toi <= n-1
 * fromi?< toi
 * hasApple.length == n
 * 通过次数2,751提交次数5,985
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-to-collect-all-apples-in-a-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinTime {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> map = constructMap(edges);
        return helper(0, map, hasApple, new HashSet<>());
    }

    private int helper(int node, Map<Integer, List<Integer>> map, List<Boolean> hasApple, Set<Integer> visited) {
        visited.add(node);
        int res = 0;
        if (map.containsKey(node)) {
            for (int next : map.get(node)) {
                if (!visited.contains(next)) {
                    res += helper(next, map, hasApple, visited);
                }
            }
        }
        int sum = 0;
        if (res != 0) {
            sum += res + 2;
        } else if (hasApple.get(node)) {
            sum += 2;
        }
        if (node == 0 && sum > 0) {
            sum -= 2;
        }
        return sum;
    }

    private Map<Integer, List<Integer>> constructMap(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        return map;
    }
}
