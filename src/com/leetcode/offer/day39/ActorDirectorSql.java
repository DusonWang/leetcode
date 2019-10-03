package com.leetcode.offer.day39;

/**
 * @author duson
 * ActorDirector 表：
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | actor_id    | int     |
 * | director_id | int     |
 * | timestamp   | int     |
 * +-------------+---------+
 * timestamp 是这张表的主键.
 *  
 * <p>
 * 写一条SQL查询语句获取合作过至少三次的演员和导演的 id 对 (actor_id, director_id)
 * <p>
 * 示例：
 * <p>
 * ActorDirector 表：
 * +-------------+-------------+-------------+
 * | actor_id    | director_id | timestamp   |
 * +-------------+-------------+-------------+
 * | 1           | 1           | 0           |
 * | 1           | 1           | 1           |
 * | 1           | 1           | 2           |
 * | 1           | 2           | 3           |
 * | 1           | 2           | 4           |
 * | 2           | 1           | 5           |
 * | 2           | 1           | 6           |
 * +-------------+-------------+-------------+
 * <p>
 * Result 表：
 * +-------------+-------------+
 * | actor_id    | director_id |
 * +-------------+-------------+
 * | 1           | 1           |
 * +-------------+-------------+
 * 唯一的 id 对是 (1, 1)，他们恰好合作了 3 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/actors-and-directors-who-cooperated-at-least-three-times
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ActorDirectorSql {

    //# Write your MySQL query statement below
    //select actor_id as ACTOR_ID,director_id as DIRECTOR_ID
    //from ActorDirector
    //group by actor_id,director_id
    //having count(1) >= 3;
}
