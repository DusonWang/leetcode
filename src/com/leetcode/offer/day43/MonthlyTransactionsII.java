package com.leetcode.offer.day43;

/**
 * @author duson
 * Transactions 记录表
 * <p>
 * +----------------+---------+
 * | Column Name    | Type    |
 * +----------------+---------+
 * | id             | int     |
 * | country        | varchar |
 * | state          | enum    |
 * | amount         | int     |
 * | trans_date     | date    |
 * +----------------+---------+
 * id 是这个表的主键。
 * 该表包含有关传入事务的信息。
 * 状态列是类型为 [approved（已批准）、declined（已拒绝）] 的枚举。
 *  
 * <p>
 * Chargebacks 表
 * <p>
 * +----------------+---------+
 * | Column Name    | Type    |
 * +----------------+---------+
 * | trans_id       | int     |
 * | charge_date    | date    |
 * +----------------+---------+
 * 退单包含有关放置在事务表中的某些事务的传入退单的基本信息。
 * trans_id 是 transactions 表的 id 列的外键。
 * 每项退单都对应于之前进行的交易，即使未经批准。
 *  
 * <p>
 * 编写一个 SQL 查询，以查找每个月和每个国家/地区的已批准交易的数量及其总金额、退单的数量及其总金额。
 * <p>
 * 注意：在您的查询中，给定月份和国家，忽略所有为零的行。
 * <p>
 * 查询结果格式如下所示：
 * <p>
 * Transactions 表：
 * +------+---------+----------+--------+------------+
 * | id   | country | state    | amount | trans_date |
 * +------+---------+----------+--------+------------+
 * | 101  | US      | approved | 1000   | 2019-05-18 |
 * | 102  | US      | declined | 2000   | 2019-05-19 |
 * | 103  | US      | approved | 3000   | 2019-06-10 |
 * | 104  | US      | approved | 4000   | 2019-06-13 |
 * | 105  | US      | approved | 5000   | 2019-06-15 |
 * +------+---------+----------+--------+------------+
 * <p>
 * Chargebacks 表：
 * +------------+------------+
 * | trans_id   | trans_date |
 * +------------+------------+
 * | 102        | 2019-05-29 |
 * | 101        | 2019-06-30 |
 * | 105        | 2019-09-18 |
 * +------------+------------+
 * <p>
 * Result 表：
 * +----------+---------+----------------+-----------------+-------------------+--------------------+
 * | month    | country | approved_count | approved_amount | chargeback_count  | chargeback_amount  |
 * +----------+---------+----------------+-----------------+-------------------+--------------------+
 * | 2019-05  | US      | 1              | 1000            | 1                 | 2000               |
 * | 2019-06  | US      | 3              | 12000           | 1                 | 1000               |
 * | 2019-09  | US      | 0              | 0               | 1                 | 5000               |
 * +----------+---------+----------------+-----------------+-------------------+--------------------+
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monthly-transactions-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MonthlyTransactionsII {

    //select month as "MONTH",country as "COUNTRY",
    //sum(if(type='approved',1,0)) as "APPROVED_COUNT",
    //sum(if(type='approved',amount,0)) as "APPROVED_AMOUNT",
    //sum(if(type='chargeback',1,0)) as "CHARGEBACK_COUNT",
    //sum(if(type='chargeback',amount,0)) as "CHARGEBACK_AMOUNT"
    //from(
    //(select date_format(t.trans_date,'%Y-%m') as month,
    //t.country,t.amount,'approved' as type
    //from Transactions as t
    //where state='approved')
    //union all
    //(select date_format(c.trans_date,'%Y-%m') as month,
    // t.country,t.amount,'chargeback' as type
    //from Transactions as t
    //join Chargebacks as c
    //on c.trans_id = t.id
    //)) as mm
    //group by mm.month,mm.country

}
