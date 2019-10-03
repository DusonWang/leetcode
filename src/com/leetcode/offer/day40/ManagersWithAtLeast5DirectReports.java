package com.leetcode.offer.day40;

/**
 * @author duson
 *
 * Employee 表包含所有员工和他们的经理。每个员工都有一个 Id，并且还有一列是经理的 Id。
 *
 * +------+----------+-----------+----------+
 * |Id    |Name 	  |Department |ManagerId |
 * +------+----------+-----------+----------+
 * |101   |John 	  |A 	      |null      |
 * |102   |Dan 	  |A 	      |101       |
 * |103   |James 	  |A 	      |101       |
 * |104   |Amy 	  |A 	      |101       |
 * |105   |Anne 	  |A 	      |101       |
 * |106   |Ron 	  |B 	      |101       |
 * +------+----------+-----------+----------+
 * 给定 Employee 表，请编写一个SQL查询来查找至少有5名直接下属的经理。对于上表，您的SQL查询应该返回：
 *
 * +-------+
 * | Name  |
 * +-------+
 * | John  |
 * +-------+
 * 注意:
 * 没有人是自己的下属。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/managers-with-at-least-5-direct-reports
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ManagersWithAtLeast5DirectReports {

    //# Write your MySQL query statement below
    //select name from Employee as t1 join
    //(select ManagerId from Employee group by ManagerId having count(1)>=5) as t2
    //on t1.Id = t2.ManagerId;
}
