package com.leetcode.offer.code;

/**
 * @author duson
 * 描述
 * <p>
 * 给定 3 个表： salesperson， company， orders。
 * 输出所有表 salesperson 中，没有向公司 'RED' 销售任何东西的销售员。
 * <p>
 * 解释
 * 输入
 * <p>
 * 表： salesperson
 * <p>
 * +----------+------+--------+-----------------+-----------+
 * | sales_id | name | salary | commission_rate | hire_date |
 * +----------+------+--------+-----------------+-----------+
 * |   1      | John | 100000 |     6           | 4/1/2006  |
 * |   2      | Amy  | 120000 |     5           | 5/1/2010  |
 * |   3      | Mark | 65000  |     12          | 12/25/2008|
 * |   4      | Pam  | 25000  |     25          | 1/1/2005  |
 * |   5      | Alex | 50000  |     10          | 2/3/2007  |
 * +----------+------+--------+-----------------+-----------+
 * 表 salesperson 存储了所有销售员的信息。每个销售员都有一个销售员编号 sales_id 和他的名字 name 。
 * <p>
 * 表： company
 * <p>
 * +---------+--------+------------+
 * | com_id  |  name  |    city    |
 * +---------+--------+------------+
 * |   1     |  RED   |   Boston   |
 * |   2     | ORANGE |   New York |
 * |   3     | YELLOW |   Boston   |
 * |   4     | GREEN  |   Austin   |
 * +---------+--------+------------+
 * 表 company 存储了所有公司的信息。每个公司都有一个公司编号 com_id 和它的名字 name 。
 * <p>
 * 表： orders
 * <p>
 * +----------+------------+---------+----------+--------+
 * | order_id | order_date | com_id  | sales_id | amount |
 * +----------+------------+---------+----------+--------+
 * | 1        |   1/1/2014 |    3    |    4     | 100000 |
 * | 2        |   2/1/2014 |    4    |    5     | 5000   |
 * | 3        |   3/1/2014 |    1    |    1     | 50000  |
 * | 4        |   4/1/2014 |    1    |    4     | 25000  |
 * +----------+----------+---------+----------+--------+
 * 表 orders 存储了所有的销售数据，包括销售员编号 sales_id 和公司编号 com_id 。
 * <p>
 * 输出
 * <p>
 * +------+
 * | name |
 * +------+
 * | Amy  |
 * | Mark |
 * | Alex |
 * +------+
 * 解释
 * <p>
 * 根据表 orders 中的订单 '3' 和 '4' ，容易看出只有 'John' 和 'Pam' 两个销售员曾经向公司 'RED' 销售过。
 * <p>
 * 所以我们需要输出表 salesperson 中所有其他人的名字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sales-person
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SalesPerson {

    //select name
    //from salesperson
    //where name not in (select distinct(s.name)
    //from orders as o
    //join salesperson as s
    //on o.sales_id=s.sales_id
    //join company as c
    //on o.com_id=c.com_id and c.name='RED')
}
