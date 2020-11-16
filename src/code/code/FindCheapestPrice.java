package code.code;

import java.util.*;

/**
 * @author duson
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n 范围是 [1, 100]，城市标签从 0 到 n - 1.
 * 航班数量范围是 [0, n * (n - 1) / 2].
 * 每个航班的格式 (src, dst, price).
 * 每个航班的价格范围是 [1, 10000].
 * k 范围是 [0, n - 1].
 * 航班没有重复，且不存在环路
 * 通过次数4,402提交次数12,590
 * 在真实的面试中遇到过这道题？
 */
public class FindCheapestPrice {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] minNodeVal = new int[n];
        int ans = Integer.MAX_VALUE;
        int[][] adj = new int[n][n];
        Arrays.fill(minNodeVal, Integer.MAX_VALUE);
        for (int[] flight : flights) {
            adj[flight[0]][flight[1]] = flight[2];
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                if (node == null) {
                    continue;
                }
                if (node[0] == dst) {
                    ans = Math.min(ans, node[1]);
                } else {
                    for (int j = 0; j < n; j++) {
                        if (adj[node[0]][j] != 0 && minNodeVal[j] > node[1] + adj[node[0]][j]) {
                            minNodeVal[j] = node[1] + adj[node[0]][j];
                            q.add(new int[]{j, node[1] + adj[node[0]][j]});

                        }
                    }
                }
            }
            if (k == -1) {
                break;
            }
            k--;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
