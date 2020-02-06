package com.leetcode.offer.code;

/**
 * @author duson
 * 事件表：Events
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | business_id   | int     |
 * | event_type    | varchar |
 * | occurences    | int     |
 * +---------------+---------+
 * 此表的主键是 (business_id, event_type)。
 * 表中的每一行记录了某种类型的事件在某些业务中多次发生的信息。
 *  
 *
 * 写一段 SQL 来查询所有活跃的业务。
 *
 * 如果一个业务的某个事件类型的发生次数大于此事件类型在所有业务中的平均发生次数，并且该业务至少有两个这样的事件类型，那么该业务就可被看做是活跃业务。
 *
 * 查询结果格式如下所示：
 *
 * Events table:
 * +-------------+------------+------------+
 * | business_id | event_type | occurences |
 * +-------------+------------+------------+
 * | 1           | reviews    | 7          |
 * | 3           | reviews    | 3          |
 * | 1           | ads        | 11         |
 * | 2           | ads        | 7          |
 * | 3           | ads        | 6          |
 * | 1           | page views | 3          |
 * | 2           | page views | 12         |
 * +-------------+------------+------------+
 *
 * 结果表
 * +-------------+
 * | business_id |
 * +-------------+
 * | 1           |
 * +-------------+
 * 'reviews'、 'ads' 和 'page views' 的总平均发生次数分别是 (7+3)/2=5, (11+7+6)/3=8, (3+12)/2=7.5。
 * id 为 1 的业务有 7 个 'reviews' 事件（大于 5）和 11 个 'ads' 事件（大于 8），所以它是活跃业务。
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/active-businesses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ActiveBusinesse {

    //# Write your MySQL query statement below
    //select business_id from Events e
    //right join
    //(select event_type,avg(occurences) as avg_account
    //from Events
    //group by event_type) as a
    //on e.event_type=a.event_type
    //group by e.business_id
    //having sum(if(e.occurences>a.avg_account,1,0))>1

}
