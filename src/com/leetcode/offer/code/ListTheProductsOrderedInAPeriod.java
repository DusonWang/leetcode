package com.leetcode.offer.code;

/**
 * @author duson
 * Table: Products
 * <p>
 * +------------------+---------+
 * | Column Name      | Type    |
 * +------------------+---------+
 * | product_id       | int     |
 * | product_name     | varchar |
 * | product_category | varchar |
 * +------------------+---------+
 * product_id is the primary key for this table.
 * This table contains data about the company's products.
 * Table: Orders
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | product_id    | int     |
 * | order_date    | date    |
 * | unit          | int     |
 * +---------------+---------+
 * There is no primary key for this table. It may have duplicate rows.
 * product_id is a foreign key to Products table.
 * unit is the number of products ordered in order_date.
 *  
 * <p>
 * Write an SQL query to get the names of products with greater than or equal to 100 units ordered in February 2020 and their amount.
 * <p>
 * Return result table in any order.
 * <p>
 * The query result format is in the following example:
 * <p>
 *  
 * <p>
 * Products table:
 * +-------------+-----------------------+------------------+
 * | product_id  | product_name          | product_category |
 * +-------------+-----------------------+------------------+
 * | 1           | Leetcode Solutions    | Book             |
 * | 2           | Jewels of Stringology | Book             |
 * | 3           | HP                    | Laptop           |
 * | 4           | Lenovo                | Laptop           |
 * | 5           | Leetcode Kit          | T-shirt          |
 * +-------------+-----------------------+------------------+
 * <p>
 * Orders table:
 * +--------------+--------------+----------+
 * | product_id   | order_date   | unit     |
 * +--------------+--------------+----------+
 * | 1            | 2020-02-05   | 60       |
 * | 1            | 2020-02-10   | 70       |
 * | 2            | 2020-01-18   | 30       |
 * | 2            | 2020-02-11   | 80       |
 * | 3            | 2020-02-17   | 2        |
 * | 3            | 2020-02-24   | 3        |
 * | 4            | 2020-03-01   | 20       |
 * | 4            | 2020-03-04   | 30       |
 * | 4            | 2020-03-04   | 60       |
 * | 5            | 2020-02-25   | 50       |
 * | 5            | 2020-02-27   | 50       |
 * | 5            | 2020-03-01   | 50       |
 * +--------------+--------------+----------+
 * <p>
 * Result table:
 * +--------------------+---------+
 * | product_name       | unit    |
 * +--------------------+---------+
 * | Leetcode Solutions | 130     |
 * | Leetcode Kit       | 100     |
 * +--------------------+---------+
 * <p>
 * Products with product_id = 1 is ordered in February a total of (60 + 70) = 130.
 * Products with product_id = 2 is ordered in February a total of 80.
 * Products with product_id = 3 is ordered in February a total of (2 + 3) = 5.
 * Products with product_id = 4 was not ordered in February 2020.
 * Products with product_id = 5 is ordered in February a total of (50 + 50) = 100.
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-the-products-ordered-in-a-period
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ListTheProductsOrderedInAPeriod {

    //# Write your MySQL query statement below
    //select a.product_name,w.s1 as unit from Products a
    //join(select product_id,sum(unit) s1
    //from orders
    //where order_date between "2020-02-01" and "2020-02-30"
    //group by product_id
    //having sum(unit)>=100) w
    //on a.product_id =w.product_id
}
