package code.code;

import java.util.Arrays;

/**
 * 石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。
 * <p>
 * 有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得分较高者获胜。
 * <p>
 * 鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
 * <p>
 * 给你一个整数数组stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分的差值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [5,3,1,4,2]
 * 输出：6
 * 解释：
 * - 爱丽丝移除 2 ，得分 5 + 3 + 1 + 4 = 13 。游戏情况：爱丽丝 = 13 ，鲍勃 = 0 ，石子 = [5,3,1,4] 。
 * - 鲍勃移除 5 ，得分 3 + 1 + 4 = 8 。游戏情况：爱丽丝 = 13 ，鲍勃 = 8 ，石子 = [3,1,4] 。
 * - 爱丽丝移除 3 ，得分 1 + 4 = 5 。游戏情况：爱丽丝 = 18 ，鲍勃 = 8 ，石子 = [1,4] 。
 * - 鲍勃移除 1 ，得分 4 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [4] 。
 * - 爱丽丝移除 4 ，得分 0 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [] 。
 * 得分的差值 18 - 12 = 6 。
 * 示例 2：
 * <p>
 * 输入：stones = [7,90,5,1,100,10,10,2]
 * 输出：122
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == stones.length
 * 2 <= n <= 1000
 * 1 <= stones[i] <= 1000
 * 通过次数3,756提交次数7,551
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game-vii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StoneGameVII {

    public int stoneGameVII(int[] stones) {
        int[] dp = new int[stones.length];
        int[] sums = stones.clone();
        for (int max = stones.length - 1; max > 0; max--) {
            for (int x = 0; x < max; x++) {
                int y = x + stones.length - max;
                sums[x] += stones[y];
                int gx = sums[x] - stones[x];
                int gy = sums[x] - stones[y];
                dp[x] = Math.max(gx - dp[x + 1], gy - dp[x]);
            }
        }
        return dp[0];
    }

    public int stoneGameVIIShit(int[] stones) {
        int sum = 0;
        for (int st : stones) {
            sum += st;
        }
        return diff(stones, 0, stones.length - 1, sum);
    }

    private int diff(int[] stones, int left, int right, int sum) {
        if (right == left) {
            return 0;
        }
        // 移除左边
        int gainLeft = sum - stones[left];
        int diffRemoveLeft = gainLeft - diff(stones, left + 1, right, gainLeft);
        // 移除右边
        int gainRight = sum - stones[right];
        int diffRemoveRight = gainRight - diff(stones, left, right - 1, gainRight);
        return Math.max(diffRemoveLeft, diffRemoveRight);
    }


//    public int stoneGameVII2(int[] stones) {
//        int[] dp = new int[stones.length];
//        int[] sums = stones.clone();
//        recur(stones, 0, 1, dp, sums);
//        return dp[0];
//    }
//
//    // 递推
//    private void recur(int[] stones, int x, int y, int[] dp, int[] sums) {
//        sums[x] += stones[y];
//        int sum = sums[x];
//        int gx = sum - stones[x]; // 移除左边
//        int gy = sum - stones[y]; // 移除右边
//        dp[x] = Math.max(gx - dp[x + 1], gy - dp[x]); // 动态规划递推式
//        if (x == 0 && y == stones.length - 1) {
//            return; // 完毕了！
//        }
//        // 继续递推
//        if (y == stones.length - 1) {
//            recur(stones, 0, y - x + 1, dp, sums); // 递推下一轮
//        } else {
//            recur(stones, x + 1, y + 1, dp, sums); // 递推dp[x+1][y+1]
//        }
//    }

    public static void main(String[] args) {
        StoneGameVII stoneGameVII = new StoneGameVII();
        System.out.println(stoneGameVII.stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        System.out.println(stoneGameVII.stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
    }
}
