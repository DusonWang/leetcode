package code.code;

import java.util.*;

/**
 * 力扣数据中心有n台服务器，分别按从0到n-1的方式进行了编号。
 * <p>
 * 它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群，其中连接connections 是无向的。
 * <p>
 * 从形式上讲，connections[i] = [a, b]表示服务器 a和 b之间形成连接。任何服务器都可以直接或者间接地通过网络到达任何其他服务器。
 * <p>
 * 「关键连接」是在该集群中的重要连接，也就是说，假如我们将它移除，便会导致某些服务器无法访问其他服务器。
 * <p>
 * 请你以任意顺序返回该集群内的所有 「关键连接」。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * 输出：[[1,3]]
 * 解释：[[3,1]] 也是正确的。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * 不存在重复的连接
 * 通过次数3,519提交次数7,058
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/critical-connections-in-a-network
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CriticalConnections {

    private final List<List<Integer>> res = new ArrayList<>();
    private int[] count;
    private final Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for (List<Integer> conn : connections) {
            map.computeIfAbsent(conn.get(0), k -> new ArrayList<>()).add(conn.get(1));
            map.computeIfAbsent(conn.get(1), k -> new ArrayList<>()).add(conn.get(0));
        }
        count = new int[n];
        dfs(0, -1, 1);
        return res;
    }

    private int dfs(int cur, int parent, int time) {
        count[cur] = time;
        for (int neighbor : map.getOrDefault(cur, new ArrayList<>())) {
            if (neighbor == parent) {
                continue;
            }
            if (count[neighbor] != 0) {
                count[cur] = Math.min(count[cur], count[neighbor]);
            } else {
                count[cur] = Math.min(count[cur], dfs(neighbor, cur, time + 1));
            }
            if (time < count[neighbor]) {
                res.add(Arrays.asList(cur, neighbor));
            }
        }
        return count[cur];
    }

}
