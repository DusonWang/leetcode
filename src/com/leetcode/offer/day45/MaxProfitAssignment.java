package com.leetcode.offer.day45;

/**
 * @author duson
 * 有一些工作：difficulty[i] 表示第i个工作的难度，profit[i]表示第i个工作的收益。
 * <p>
 * 现在我们有一些工人。worker[i]是第i个工人的能力，即该工人只能完成难度小于等于worker[i]的工作。
 * <p>
 * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 * <p>
 * 举个例子，如果3个工人都尝试完成一份报酬为1的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 * <p>
 * 我们能得到的最大收益是多少？
 * <p>
 * 示例：
 * <p>
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 * 提示:
 * <p>
 * 1 <= difficulty.length = profit.length <= 10000
 * 1 <= worker.length <= 10000
 * difficulty[i], profit[i], worker[i]  的范围是 [1, 10^5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-profit-assigning-work
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitAssignment {

    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int sum = 0, n = difficulty.length;
        for (int w : worker) {
            int p = 0;
            for (int i = 0; i < n; i++) {
                if (difficulty[i] > w) {
                    continue;
                }
                p = Math.max(p, profit[i]);
            }
            sum += p;
        }
        return sum;
    }

    public int maxProfitAssignment3(int[] difficulty, int[] profit, int[] worker) {
        int[] dp = new int[100001];
        for (int i = 0; i < difficulty.length; i++) {
            dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
        }
        int sum = 0;
        for (int i : worker) {
            sum += dp[i];
        }
        return sum;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDiff = 0;
        int profits = 0;
        for (int i : difficulty) {
            maxDiff = Math.max(maxDiff, i);
        }
        int[] buckets = new int[maxDiff + 1];
        for (int i = 0; i < profit.length; i++) {
            buckets[difficulty[i]] = Math.max(buckets[difficulty[i]], profit[i]);
        }

        for (int i = 1; i < buckets.length; i++) {
            buckets[i] = Math.max(buckets[i - 1], buckets[i]);
        }

        for (int w : worker) {
            profits = profits + (w >= maxDiff ? buckets[maxDiff] : buckets[w]);
        }

        return profits;
    }
}
