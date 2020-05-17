package com.leetcode.offer.code;

/**
 * @author duson
 * Table: Sales
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | sale_date     | date    |
 * | fruit         | enum    |
 * | sold_num      | int     |
 * +---------------+---------+
 * (sale_date,fruit) is the primary key for this table.
 * This table contains the sales of "apples" and "oranges" sold each day.
 * ?
 * <p>
 * Write an SQL query to?report the?difference between number of apples and oranges sold each day.
 * <p>
 * Return the result table ordered by sale_date in format ('YYYY-MM-DD').
 * <p>
 * The query result format is in the following example:
 * <p>
 * ?
 * <p>
 * Sales table:
 * +------------+------------+-------------+
 * | sale_date  | fruit      | sold_num    |
 * +------------+------------+-------------+
 * | 2020-05-01 | apples     | 10          |
 * | 2020-05-01 | oranges    | 8           |
 * | 2020-05-02 | apples     | 15          |
 * | 2020-05-02 | oranges    | 15          |
 * | 2020-05-03 | apples     | 20          |
 * | 2020-05-03 | oranges    | 0           |
 * | 2020-05-04 | apples     | 15          |
 * | 2020-05-04 | oranges    | 16          |
 * +------------+------------+-------------+
 * <p>
 * Result table:
 * +------------+--------------+
 * | sale_date  | diff         |
 * +------------+--------------+
 * | 2020-05-01 | 2            |
 * | 2020-05-02 | 0            |
 * | 2020-05-03 | 20           |
 * | 2020-05-04 | -1           |
 * +------------+--------------+
 * <p>
 * Day 2020-05-01, 10 apples and 8 oranges were sold (Difference  10 - 8 = 2).
 * Day 2020-05-02, 15 apples and 15 oranges were sold (Difference 15 - 15 = 0).
 * Day 2020-05-03, 20 apples and 0 oranges were sold (Difference 20 - 0 = 20).
 * Day 2020-05-04, 15 apples and 16 oranges were sold (Difference 15 - 16 = -1).
 * 通过次数21提交次数23
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/apples-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ApplesOranges {


    //# Write your MySQL query statement below
    //select sale_date,
    //sum(case fruit when 'apples' then sold_num when 'oranges' then -sold_num end) as diff
    //from Sales
    //group by sale_date
}
