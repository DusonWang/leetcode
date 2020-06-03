package com.leetcode.offer.code;

/**
 * @author duson
 * 给你?n?笔订单，每笔订单都需要快递服务。
 * <p>
 * 请你统计所有有效的 收件/配送 序列的数目，确保第 i 个物品的配送服务?delivery(i) 总是在其收件服务?pickup(i) 之后。
 * <p>
 * 由于答案可能很大，请返回答案对 10^9 + 7 取余的结果。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：只有一种序列 (P1, D1)，物品 1 的配送服务（D1）在物品 1 的收件服务（P1）后。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：6
 * 解释：所有可能的序列包括：
 * (P1,P2,D1,D2)，(P1,P2,D2,D1)，(P1,D1,P2,D2)，(P2,P1,D1,D2)，(P2,P1,D2,D1) 和 (P2,D2,P1,D1)。
 * (P1,D2,P2,D1) 是一个无效的序列，因为物品 2 的收件服务（P2）不应在物品 2 的配送服务（D2）之后。
 * 示例 3：
 * <p>
 * 输入：n = 3
 * 输出：90
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * 通过次数1,462提交次数2,712
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-all-valid-pickup-and-delivery-options
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountOrders {

    private static final long MOD = (long) 1e9 + 7;

    public int countOrders(int n) {
        long current = 1;

        for (int i = 1; i <= n; i++) {
            current = (i + i - 1) * i * current % MOD;
        }

        return (int) current;
    }
}
