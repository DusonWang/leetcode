package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 如果出现下述两种情况，交易 可能无效：
 * <p>
 * 交易金额超过 ¥1000
 * 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 * <p>
 * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * 输出：["alice,20,800,mtv","alice,50,100,beijing"]
 * 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
 * 示例 2：
 * <p>
 * 输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * 输出：["alice,50,1200,mtv"]
 * 示例 3：
 * <p>
 * 输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * 输出：["bob,50,1200,mtv"]
 *  
 * <p>
 * 提示：
 * <p>
 * transactions.length <= 1000
 * 每笔交易 transactions[i] 按 "{name},{time},{amount},{city}" 的格式进行记录
 * 每个交易名称 {name} 和城市 {city} 都由小写英文字母组成，长度在 1 到 10 之间
 * 每个交易时间 {time} 由一些数字组成，表示一个 0 到 1000 之间的整数
 * 每笔交易金额 {amount} 由一些数字组成，表示一个 0 到 2000 之间的整数
 * 通过次数3,102提交次数10,561
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invalid-transactions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InvalidTransactions {

    private static class Trade {
        private String s;
        private String name;
        private int time;
        private int money;
        private String city;
        private boolean valid;

        public Trade(String s, String name, int time, int money, String city) {
            super();
            this.s = s;
            this.name = name;
            this.time = time;
            this.money = money;
            this.city = city;
            this.valid = this.money <= 1000;
        }

        @Override
        public String toString() {
            return s;
        }

        private boolean invalid(Trade o) {
            return this.name.equals(o.name) && !this.city.equals(o.city)
                    && Math.abs(this.time - o.time) <= 60;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();
        List<Trade> trades = new ArrayList<>();
        for (String s : transactions) {
            String[] split = s.split(",");
            Trade t = new Trade(s, split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3]);
            trades.add(t);
        }
        for (int i = 0; i < trades.size(); i++) {
            Trade iTrade = trades.get(i);
            if (!iTrade.valid) {
                continue;
            }
            for (int j = 0; j < trades.size(); j++) {
                if (i == j) {
                    continue;
                }
                Trade jTrade = trades.get(j);
                if (iTrade.invalid(jTrade)) {
                    iTrade.valid = false;
                    jTrade.valid = false;
                }
            }
        }
        for (Trade t : trades) {
            if (!t.valid) {
                result.add(t.toString());
            }
        }
        return result;
    }
}
