package com.leetcode.offer.day40;

/**
 * @author duson
 * Table: Activity
 * <p>
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | player_id    | int     |
 * | device_id    | int     |
 * | event_date   | date    |
 * | games_played | int     |
 * +--------------+---------+
 * (player_id, event_date) 是这个表的两个主键
 * 这个表显示的是某些游戏玩家的游戏活动情况
 * 每一行是在某天使用某个设备登出之前登录并玩多个游戏（可能为0）的玩家的记录
 * 请编写一个 SQL 查询，描述每一个玩家首次登陆的设备名称
 * <p>
 * 查询结果格式在以下示例中：
 * <p>
 * Activity table:
 * +-----------+-----------+------------+--------------+
 * | player_id | device_id | event_date | games_played |
 * +-----------+-----------+------------+--------------+
 * | 1         | 2         | 2016-03-01 | 5            |
 * | 1         | 2         | 2016-05-02 | 6            |
 * | 2         | 3         | 2017-06-25 | 1            |
 * | 3         | 1         | 2016-03-02 | 0            |
 * | 3         | 4         | 2018-07-03 | 5            |
 * +-----------+-----------+------------+--------------+
 * <p>
 * Result table:
 * +-----------+-----------+
 * | player_id | device_id |
 * +-----------+-----------+
 * | 1         | 2         |
 * | 2         | 3         |
 * | 3         | 1         |
 * +-----------+-----------+
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-play-analysis-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GamePlayAnalysisII {

    //# Write your MySQL query statement below
    //select b.player_id,b.device_id from Activity as b where (b.player_id,b.event_date) in (
    //select a.player_id,min(a.event_date)
    //from Activity as a
    //group by a.player_id
    //)

}
