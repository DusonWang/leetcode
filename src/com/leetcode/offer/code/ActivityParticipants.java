package com.leetcode.offer.code;

/**
 * @author duson
 * 表: Friends
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | id            | int     |
 * | name          | varchar |
 * | activity      | varchar |
 * +---------------+---------+
 * id 是朋友的 id 和该表的主键
 * name 是朋友的名字
 * activity 是朋友参加的活动的名字
 * 表: Activities
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | id            | int     |
 * | name          | varchar |
 * +---------------+---------+
 * id 是该表的主键
 * name 是活动的名字
 * ?
 * <p>
 * 写一条 SQL 查询那些既没有最多，也没有最少参与者的活动的名字
 * <p>
 * 可以以任何顺序返回结果，Activities 表的每项活动的参与者都来自 Friends 表
 * <p>
 * 下面是查询结果格式的例子：
 * <p>
 * Friends 表:
 * +------+--------------+---------------+
 * | id   | name         | activity      |
 * +------+--------------+---------------+
 * | 1    | Jonathan D.  | Eating        |
 * | 2    | Jade W.      | Singing       |
 * | 3    | Victor J.    | Singing       |
 * | 4    | Elvis Q.     | Eating        |
 * | 5    | Daniel A.    | Eating        |
 * | 6    | Bob B.       | Horse Riding  |
 * +------+--------------+---------------+
 * <p>
 * Activities 表:
 * +------+--------------+
 * | id   | name         |
 * +------+--------------+
 * | 1    | Eating       |
 * | 2    | Singing      |
 * | 3    | Horse Riding |
 * +------+--------------+
 * <p>
 * Result 表:
 * +--------------+
 * | activity     |
 * +--------------+
 * | Singing      |
 * +--------------+
 * <p>
 * Eating 活动有三个人参加, 是最多人参加的活动 (Jonathan D. , Elvis Q. and Daniel A.)
 * Horse Riding 活动有一个人参加, 是最少人参加的活动 (Bob B.)
 * Singing 活动有两个人参加 (Victor J. and Jade W.)
 * 通过次数652提交次数1,073
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/activity-participants
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ActivityParticipants {

    //WITH People AS (SELECT activity, COUNT(name) AS people
    //  FROM Friends
    // GROUP BY activity)
    //
    // SELECT activity FROM People
    //  WHERE people>(SELECT MIN(people) FROM People)
    //    AND people<(SELECT MAX(people) FROM People)
}
