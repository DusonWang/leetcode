package com.leetcode.offer.code;

/**
 * @author duson
 * Table: Transactions
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | id            | int     |
 * | country       | varchar |
 * | state         | enum    |
 * | amount        | int     |
 * | trans_date    | date    |
 * +---------------+---------+
 * id 是这个表的主键。
 * 该表包含有关传入事务的信息。
 * state 列类型为 “[”批准“，”拒绝“] 之一。
 *  
 * <p>
 * 编写一个 sql 查询来查找每个月和每个国家/地区的事务数及其总金额、已批准的事务数及其总金额。
 * <p>
 * 查询结果格式如下所示：
 * <p>
 * Transactions table:
 * +------+---------+----------+--------+------------+
 * | id   | country | state    | amount | trans_date |
 * +------+---------+----------+--------+------------+
 * | 121  | US      | approved | 1000   | 2018-12-18 |
 * | 122  | US      | declined | 2000   | 2018-12-19 |
 * | 123  | US      | approved | 2000   | 2019-01-01 |
 * | 124  | DE      | approved | 2000   | 2019-01-07 |
 * +------+---------+----------+--------+------------+
 * <p>
 * Result table:
 * +----------+---------+-------------+----------------+--------------------+-----------------------+
 * | month    | country | trans_count | approved_count | trans_total_amount | approved_total_amount |
 * +----------+---------+-------------+----------------+--------------------+-----------------------+
 * | 2018-12  | US      | 2           | 1              | 3000               | 1000                  |
 * | 2019-01  | US      | 1           | 1              | 2000               | 2000                  |
 * | 2019-01  | DE      | 1           | 1              | 2000               | 2000                  |
 * +----------+---------+-------------+----------------+--------------------+-----------------------+
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monthly-transactions-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MonthlyTransactionsI {

    //# Write your MySQL query statement below
    //select date_format(trans_date,'%Y-%m') as month,
    //country,count(*) as trans_count,
    //sum(if(state='approved',1,0)) as approved_count,
    //sum(amount) as trans_total_amount,
    //sum(if(state='approved',amount,0)) as approved_total_amount
    //from Transactions
    //group by date_format(trans_date,'%Y-%m'),country

}
