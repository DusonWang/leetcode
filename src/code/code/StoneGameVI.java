package code.code;

import java.util.Arrays;

/**
 * Alice 和Bob 轮流玩一个游戏，Alice 先手。
 * <p>
 * 一堆石子里总共有n个石子，轮到某个玩家时，他可以 移出一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准。双方都知道对方的评判标准。
 * <p>
 * 给你两个长度为 n的整数数组aliceValues 和bobValues。aliceValues[i] 和bobValues[i]分别表示 Alice 和 Bob 认为第i个石子的价值。
 * <p>
 * 所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略进行游戏。
 * <p>
 * 请你推断游戏的结果，用如下的方式表示：
 * <p>
 * 如果 Alice 赢，返回1。
 * 如果 Bob 赢，返回-1。
 * 如果游戏平局，返回0。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：aliceValues = [1,3], bobValues = [2,1]
 * 输出：1
 * 解释：
 * 如果 Alice 拿石子 1 （下标从 0开始），那么 Alice 可以得到 3 分。
 * Bob 只能选择石子 0 ，得到 2 分。
 * Alice 获胜。
 * 示例 2：
 * <p>
 * 输入：aliceValues = [1,2], bobValues = [3,1]
 * 输出：0
 * 解释：
 * Alice 拿石子 0 ， Bob 拿石子 1 ，他们得分都为 1 分。
 * 打平。
 * 示例 3：
 * <p>
 * 输入：aliceValues = [2,4,3], bobValues = [1,6,7]
 * 输出：-1
 * 解释：
 * 不管 Alice 怎么操作，Bob 都可以得到比 Alice 更高的得分。
 * 比方说，Alice 拿石子 1 ，Bob 拿石子 2 ， Alice 拿石子 0 ，Alice 会得到 6 分而 Bob 得分为 7 分。
 * Bob 会获胜。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == aliceValues.length == bobValues.length
 * 1 <= n <= 105
 * 1 <= aliceValues[i], bobValues[i] <= 100
 * 通过次数2,222提交次数4,787
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game-vi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StoneGameVI {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] sums = new int[n][3];
        for (int i = 0; i < n; i++) {
            sums[i] = new int[]{aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i]};
        }
        Arrays.sort(sums, (a, b) -> b[0] - a[0]);
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a += sums[i][1];
            } else {
                b += sums[i][2];
            }
        }
        return Integer.compare(a, b);
    }

    public static void main(String[] args) {
        StoneGameVI stoneGameVI = new StoneGameVI();
        System.out.println(stoneGameVI.stoneGameVI(new int[]{1, 3}, new int[]{2, 1}));
        System.out.println(stoneGameVI.stoneGameVI(new int[]{1, 2}, new int[]{3, 1}));
        System.out.println(stoneGameVI.stoneGameVI(new int[]{2, 4, 3}, new int[]{1, 6, 7}));


    }

}
