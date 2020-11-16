package code.code;

/**
 * @author duson
 * Table: Delivery
 * <p>
 * +-----------------------------+---------+
 * | Column Name                 | Type    |
 * +-----------------------------+---------+
 * | delivery_id                 | int     |
 * | customer_id                 | int     |
 * | order_date                  | date    |
 * | customer_pref_delivery_date | date    |
 * +-----------------------------+---------+
 * delivery_id is the primary key of this table.
 * The table holds information about food delivery to customers that make orders at some date and specify a preferred delivery date (on the same order date or after it).
 *  
 * <p>
 * If the preferred delivery date of the customer is the same as the order date then the order is called immediate otherwise it's called scheduled.
 * <p>
 * The first order of a customer is the order with the earliest order date that customer made. It is guaranteed that a customer has exactly one first order.
 * <p>
 * Write an SQL query to find the percentage of immediate orders in the first orders of all customers, rounded to 2 decimal places.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Delivery table:
 * +-------------+-------------+------------+-----------------------------+
 * | delivery_id | customer_id | order_date | customer_pref_delivery_date |
 * +-------------+-------------+------------+-----------------------------+
 * | 1           | 1           | 2019-08-01 | 2019-08-02                  |
 * | 2           | 2           | 2019-08-02 | 2019-08-02                  |
 * | 3           | 1           | 2019-08-11 | 2019-08-12                  |
 * | 4           | 3           | 2019-08-24 | 2019-08-24                  |
 * | 5           | 3           | 2019-08-21 | 2019-08-22                  |
 * | 6           | 2           | 2019-08-11 | 2019-08-13                  |
 * | 7           | 4           | 2019-08-09 | 2019-08-09                  |
 * +-------------+-------------+------------+-----------------------------+
 * <p>
 * Result table:
 * +----------------------+
 * | immediate_percentage |
 * +----------------------+
 * | 50.00                |
 * +----------------------+
 * The customer id 1 has a first order with delivery id 1 and it is scheduled.
 * The customer id 2 has a first order with delivery id 2 and it is immediate.
 * The customer id 3 has a first order with delivery id 5 and it is scheduled.
 * The customer id 4 has a first order with delivery id 7 and it is immediate.
 * Hence, half the customers have immediate first orders.
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/immediate-food-delivery-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Immediate2 {

    //# Write your MySQL query statement below
    //select round(count(case when d.order_date = d.customer_pref_delivery_date then 1 end) * 100/count(*),2) as immediate_percentage
    //from Delivery d,
    //(select delivery_id,customer_id,min(order_date) as order_date
    //from Delivery
    //group by customer_id) as t
    //where d.customer_id = t.customer_id and d.order_date = t.order_date

}
