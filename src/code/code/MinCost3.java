package code.code;

/**
 * 在一个小城市里，有?m?个房子排成一排，你需要给每个房子涂上 n?种颜色之一（颜色编号为 1 到 n?）。有的房子去年夏天已经涂过颜色了，所以这些房子不需要被重新涂色。
 * <p>
 * 我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区? [{1}, {2,2}, {3,3}, {2}, {1,1}] 。）
 * <p>
 * 给你一个数组?houses?，一个?m * n?的矩阵?cost?和一个整数?target?，其中：
 * <p>
 * houses[i]：是第?i?个房子的颜色，0?表示这个房子还没有被涂色。
 * cost[i][j]：是将第?i?个房子涂成颜色?j+1?的花费。
 * 请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成?target?个街区。如果没有可用的涂色方案，请返回?-1?。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * 输出：9
 * 解释：房子涂色方案为 [1,2,2,1,1]
 * 此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
 * 涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
 * 示例 2：
 * <p>
 * 输入：houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * 输出：11
 * 解释：有的房子已经被涂色了，在此基础上涂色方案为 [2,2,1,2,2]
 * 此方案包含 target = 3 个街区，分别是 [{2,2}, {1}, {2,2}]。
 * 给第一个和最后一个房子涂色的花费为 (10 + 1) = 11。
 * 示例 3：
 * <p>
 * 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 5, n = 2, target = 5
 * 输出：5
 * 示例 4：
 * <p>
 * 输入：houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
 * 输出：-1
 * 解释：房子已经被涂色并组成了 4 个街区，分别是 [{3},{1},{2},{3}] ，无法形成 target = 3 个街区。
 * ?
 * <p>
 * 提示：
 * <p>
 * m == houses.length == cost.length
 * n == cost[i].length
 * 1 <= m <= 100
 * 1 <= n <= 20
 * 1 <= target?<= m
 * 0 <= houses[i]?<= n
 * 1 <= cost[i][j] <= 10^4
 * 通过次数3,574提交次数6,282
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paint-house-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCost3 {

    int[] houses = null;
    int[][] costs = null;
    int t = 0;
    int[][][] dp = null;
    static int MAX = Integer.MAX_VALUE;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.costs = cost;
        this.t = target;
        this.dp = new int[m + 1][n + 1][target + 1];

        int val = helper(0, 0, 0);
        return val == MAX ? -1 : val;
    }

    private int helper(int idx, int ne, int prev) {
        if (ne > t) {
            return MAX;
        }

        if (dp[idx][prev][ne] != 0) {
            return dp[idx][prev][ne];
        }

        if (idx == houses.length) {
            if (ne == t) {
                return 0;
            }
            return MAX;
        }

        int min = MAX;
        if (houses[idx] == 0) {
            for (int i = 1; i <= costs[idx].length; i++) {
                int val = helper(idx + 1, prev != i ? ne + 1 : ne, i);
                if (val != MAX) {
                    min = Math.min(min, costs[idx][i - 1] + val);
                }
            }
        } else {
            min = helper(idx + 1, prev != houses[idx] ? ne + 1 : ne, houses[idx]);
        }
        return dp[idx][prev][ne] = min;
    }
}
