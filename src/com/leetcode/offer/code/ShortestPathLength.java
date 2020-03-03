package com.leetcode.offer.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duson
 * 给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。 
 * <p>
 * graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
 * <p>
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一个可能的路径为 [1,0,2,0,3]
 * 示例 2：
 * <p>
 * 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一个可能的路径为 [0,1,4,2,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 * 通过次数1,266提交次数2,459
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestPathLength {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        boolean[][] dp = new boolean[n][1 << n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{i, 1 << i});
            dp[i][1 << i] = true;
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int layersize = queue.size();
            while (layersize-- > 0) {
                int[] point = queue.poll();
                if (point[1] == ((1 << n) - 1)) {
                    return step;
                }
                for (int next : graph[point[0]]) {
                    int nextStatus = point[1] | (1 << next);
                    if (dp[next][nextStatus]) {
                        continue;
                    }
                    queue.add(new int[]{next, nextStatus});
                    dp[next][nextStatus] = true;
                }
            }
            step++;
        }
        return step;
    }
}
