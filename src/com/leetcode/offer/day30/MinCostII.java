package com.leetcode.offer.day30;

/**
 * @author duson
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * <p>
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。
 * <p>
 * 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
 * <p>
 * 注意：
 * <p>
 * 所有花费均为正整数。
 * <p>
 * 示例：
 * <p>
 * 输入: [[1,5,3],[2,9,4]]
 * 输出: 5
 * 解释: 将 0 号房子粉刷成 0 号颜色，1 号房子粉刷成 2 号颜色。最少花费: 1 + 4 = 5;
 *      或者将 0 号房子粉刷成 2 号颜色，1 号房子粉刷成 0 号颜色。最少花费: 3 + 2 = 5.
 * 进阶：
 * 您能否在 O(nk) 的时间复杂度下解决此问题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paint-house-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCostII {

    public int minCostII(int[][] costs) {
        int minCost = 0;
        int minColour = -1;
        int secondMinCost = 0;
        for (int[] cost : costs) {
            int index = -1;
            int tmpMinCost = Integer.MAX_VALUE;
            int tmpMinCost2 = Integer.MAX_VALUE;
            for (int i = 0; i < cost.length; i++) {
                int thisMinCost = cost[i] + (i == minColour ? secondMinCost : minCost);
                if (thisMinCost < tmpMinCost) {
                    tmpMinCost2 = tmpMinCost;
                    tmpMinCost = thisMinCost;
                    index = i;
                } else if (thisMinCost < tmpMinCost2) {
                    tmpMinCost2 = thisMinCost;
                }
            }
            minCost = tmpMinCost;
            minColour = index;
            secondMinCost = tmpMinCost2;
        }
        return minCost;
    }
}
