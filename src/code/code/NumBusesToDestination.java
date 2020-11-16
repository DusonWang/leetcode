package code.code;

import java.util.*;

/**
 * @author duson
 * 我们有一系列公交路线。每一条路线 routes[i]?上都有一辆公交车在上面循环行驶。例如，有一条路线?routes[0] = [1, 5, 7]，表示第一辆 (下标为0) 公交车会一直按照?1->5->7->1->5->7->1->...?的车站路线行驶。
 * <p>
 * 假设我们从?S?车站开始（初始时不在公交车上），要去往?T?站。 期间仅可乘坐公交车，求出最少乘坐的公交车数量。返回 -1 表示不可能到达终点车站。
 * <p>
 * 示例:
 * 输入:
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * 输出: 2
 * 解释:
 * 最优策略是先乘坐第一辆公交车到达车站 7, 然后换乘第二辆公交车到车站 6。
 * 说明:
 * <p>
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 500.
 * 0 <= routes[i][j] < 10 ^ 6.
 * 通过次数3,147提交次数10,140
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bus-routes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumBusesToDestination {

    public int numBusesToDestination(int[][] routes, int s, int t) {
        if (routes == null || routes.length == 0 || s == t) {
            return 0;
        }
        Map<Integer, Set<Integer>> stopToBussesMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBussesMap.putIfAbsent(stop, new HashSet<>());
                stopToBussesMap.get(stop).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int busCount = 0;
        Set<Integer> bussTaken = new HashSet<>();
        while (!queue.isEmpty()) {
            for (int count = queue.size(); count > 0; count--) {
                int stop = queue.poll();
                if (stop == t) {
                    return busCount;
                }
                for (int bus : stopToBussesMap.get(stop)) {
                    if (bussTaken.add(bus)) {
                        for (int nextStop : routes[bus]) {
                            queue.offer(nextStop);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}
