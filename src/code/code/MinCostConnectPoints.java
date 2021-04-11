package code.code;

import java.util.*;

/**
 * 给你一个points?数组，表示 2D 平面上的一些点，其中?points[i] = [xi, yi]?。
 * <p>
 * 连接点?[xi, yi] 和点?[xj, yj]?的费用为它们之间的 曼哈顿距离?：|xi - xj| + |yi - yj|?，其中?|val|?表示?val?的绝对值。
 * <p>
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有?一条简单路径时，才认为所有点都已连接。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 * <p>
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 * <p>
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 * <p>
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 * <p>
 * 输入：points = [[0,0]]
 * 输出：0
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 1000
 * -106?<= xi, yi <= 106
 * 所有点?(xi, yi)?两两不同。
 * 通过次数22,549提交次数33,805
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCostConnectPoints {

    public int minCostConnectPoints(int[][] points) {
        int vertexes = points.length;
        if (vertexes < 2) return 0;
        int checkPoint = 0;
        int cost = 0;
        int[] lowCost = new int[vertexes];
        Arrays.fill(lowCost, Integer.MAX_VALUE);
        lowCost[0] = 0;
        for (int i = 0; i < vertexes - 1; i++) {
            int minDist = Integer.MAX_VALUE;
            int temp = checkPoint;
            for (int v = 0; v < vertexes; v++) {
                if (lowCost[v] > 0) {
                    lowCost[v] = Math.min(lowCost[v], dis(points, v, checkPoint));
                    if (lowCost[v] < minDist) {
                        minDist = lowCost[v];
                        temp = v;
                    }
                }
            }
            checkPoint = temp;
            lowCost[checkPoint] = 0;
            cost += minDist;
        }
        return cost;
    }

    private int dis(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
}
