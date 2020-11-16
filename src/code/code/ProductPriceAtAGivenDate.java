package code.code;

/**
 * @author duson
 *
 * Table: Products
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | product_id    | int     |
 * | new_price     | int     |
 * | change_date   | date    |
 * +---------------+---------+
 * (product_id, change_date) is the primary key of this table.
 * Each row of this table indicates that the price of some product was changed to a new price at some date.
 *  
 *
 * Write an SQL query to find the prices of all products on 2019-08-16. Assume the price of all products before any change is 10.
 *
 * The query result format is in the following example:
 *
 * Products table:
 * +------------+-----------+-------------+
 * | product_id | new_price | change_date |
 * +------------+-----------+-------------+
 * | 1          | 20        | 2019-08-14  |
 * | 2          | 50        | 2019-08-14  |
 * | 1          | 30        | 2019-08-15  |
 * | 1          | 35        | 2019-08-16  |
 * | 2          | 65        | 2019-08-17  |
 * | 3          | 20        | 2019-08-18  |
 * +------------+-----------+-------------+
 *
 * Result table:
 * +------------+-------+
 * | product_id | price |
 * +------------+-------+
 * | 2          | 50    |
 * | 1          | 35    |
 * | 3          | 10    |
 * +------------+-------+
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-price-at-a-given-date
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProductPriceAtAGivenDate {

    //select a.product_id,ifnull(b.new_price,10) as price
    //from
    // (select distinct product_id from Products) a
    // left join
    // (select product_id,new_price from Products where (product_id,change_date)
    //    in (select product_id,max(change_date) as change_date from Products where
    //    change_date<='2019-08-16' group by product_id)
    //) b
    //on a.product_id=b.product_id

}
