package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * <p>
 * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 * <p>
 * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
 * <p>
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 * <p>
 * 游戏一直持续到所有石子都被拿走。
 * <p>
 * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：piles = [2,7,9,4,4]
 * 输出：10
 * 解释：
 * 如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。
 * 如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
 * 所以我们返回更大的 10。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 ^ 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StoneGameII {

    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[] sum = new int[len];
        int[][] memo = new int[len + 1][len + 1];
        sum[len - 1] = piles[len - 1];
        for (int i = piles.length - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        return dp(0, 1, sum, len, memo);
    }

    private int dp(int i, int j, int[] sum, int len, int[][] memo) {
        if (i >= len) {
            return 0;
        }
        if (i + 2 * j >= len) {
            return sum[i];
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int best = 0;
        for (int k = 1; k <= 2 * j; k++) {
            best = Math.max(best, sum[i] - dp(i + k, Math.max(k, j), sum, len, memo));
        }
        memo[i][j] = best;
        return best;
    }
}
