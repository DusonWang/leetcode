package com.leetcode.offer.day42;

/**
 * @author duson
 * 销售表 Sales：
 * <p>
 * +-------------+-------+
 * | Column Name | Type  |
 * +-------------+-------+
 * | sale_id     | int   |
 * | product_id  | int   |
 * | year        | int   |
 * | quantity    | int   |
 * | price       | int   |
 * +-------------+-------+
 * sale_id 是此表的主键。
 * 产品 ID 是产品表的外键。
 * 请注意，价格是按每单位计的。
 * 产品表 Product：
 * <p>
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | product_id   | int     |
 * | product_name | varchar |
 * +--------------+---------+
 * 产品 ID 是此表的主键。
 *  
 * <p>
 * 编写一个 SQL 查询，选出每个销售产品的 第一年 的 产品 id、年份、数量 和 价格。
 * <p>
 * 查询结果格式如下：
 * <p>
 * Sales table:
 * +---------+------------+------+----------+-------+
 * | sale_id | product_id | year | quantity | price |
 * +---------+------------+------+----------+-------+
 * | 1       | 100        | 2008 | 10       | 5000  |
 * | 2       | 100        | 2009 | 12       | 5000  |
 * | 7       | 200        | 2011 | 15       | 9000  |
 * +---------+------------+------+----------+-------+
 * <p>
 * Product table:
 * +------------+--------------+
 * | product_id | product_name |
 * +------------+--------------+
 * | 100        | Nokia        |
 * | 200        | Apple        |
 * | 300        | Samsung      |
 * +------------+--------------+
 * <p>
 * Result table:
 * +------------+------------+----------+-------+
 * | product_id | first_year | quantity | price |
 * +------------+------------+----------+-------+
 * | 100        | 2008       | 10       | 5000  |
 * | 200        | 2011       | 15       | 9000  |
 * +------------+------------+----------+-------+
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-sales-analysis-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProductSalesAnalysisIII {

    //# Write your MySQL query statement below
    //select product_id,year as 'first_year',quantity,price
    //from Sales
    //where (product_id,year) in (
    //select product_id,min(year)from Sales group by product_id
    //)

}
