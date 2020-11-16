package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 * <p>
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitIV {

    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) {
            int a = 0, b = Integer.MIN_VALUE;
            for (int price : prices) {
                int aOld = a;
                a = Math.max(a, b + price);
                b = Math.max(b, aOld - price);
            }

            return a;
        }

        int[] a = new int[k + 1];
        int[] b = new int[k + 1];
        Arrays.fill(b, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                a[j] = Math.max(a[j], b[j] + price);
                b[j] = Math.max(b[j], a[j - 1] - price);
            }
        }
        return a[k];
    }

//    public int maxProfit2(int k, int[] prices) {
//        int n = prices.length;
//        if (n < 2 || k == 0) {
//            return 0;
//        }
//
//        if (k == 1) {
//            int sum = 0;
//            int min = prices[0];
//            for (int i = 1; i < n; i++) {
//                int temp = prices[i] - min;
//                if (sum < temp) {
//                    sum = temp;
//                } else if (temp < 0) {
//                    min = prices[i];
//                }
//            }
//            return sum;
//        }
//
//        if (k >= n / 2) {
//            int sum = 0;
//            for (int i = 1; i < n; i++) {
//                int temp = prices[i] - prices[i - 1];
//                if (temp > 0) {
//                    sum += temp;
//                }
//            }
//            return sum;
//        }
//
//        int[] trans = new int[k];
//        int[] transOneBuy = new int[k];
//        for (int j = 0; j < k; j++) {
//            transOneBuy[j] = -prices[0];
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < k; j++) {
//                if (j > 0) {
//                    transOneBuy[j] = Math.max(transOneBuy[j], trans[j - 1] - prices[i]);
//                } else {
//                    transOneBuy[j] = Math.max(transOneBuy[j], -prices[i]);
//                }
//                trans[j] = Math.max(trans[j], transOneBuy[j] + prices[i]);
//            }
//        }
//        return trans[k - 1];
//    }
}
