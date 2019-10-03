package com.leetcode.offer.day39;

/**
 * @author duson
 * Customer 表：
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | customer_id | int     |
 * | product_key | int     |
 * +-------------+---------+
 * product_key 是 Product 表的外键。
 * Product 表：
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | product_key | int     |
 * +-------------+---------+
 * product_key 是这张表的主键。
 *  
 * <p>
 * 写一条 SQL 查询语句，从 Customer 表中查询购买了 Product 表中所有产品的客户的 id。
 * <p>
 * 示例：
 * <p>
 * Customer 表：
 * +-------------+-------------+
 * | customer_id | product_key |
 * +-------------+-------------+
 * | 1           | 5           |
 * | 2           | 6           |
 * | 3           | 5           |
 * | 3           | 6           |
 * | 1           | 6           |
 * +-------------+-------------+
 * <p>
 * Product 表：
 * +-------------+
 * | product_key |
 * +-------------+
 * | 5           |
 * | 6           |
 * +-------------+
 * <p>
 * Result 表：
 * +-------------+
 * | customer_id |
 * +-------------+
 * | 1           |
 * | 3           |
 * +-------------+
 * 购买了所有产品（5 和 6）的客户的 id 是 1 和 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/customers-who-bought-all-products
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CustomersWhoBoughtAllProducts {

    //select customer_id from customer group by customer_id
    // having count(distinct(product_key))=(select count(distinct(product_key)) from Product)

}
