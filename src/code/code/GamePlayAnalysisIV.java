package code.code;

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
 * （player_id，event_date）是此表的主键。
 * 这张表显示了某些游戏的玩家的活动情况。
 * 每一行是一个玩家的记录，他在某一天使用某个设备注销之前登录并玩了很多游戏（可能是 0）。
 *  
 * <p>
 * 编写一个 SQL 查询，报告在首次登录的第二天再次登录的玩家的分数，四舍五入到小数点后两位。换句话说，您需要计算从首次登录日期开始至少连续两天登录的玩家的数量，然后除以玩家总数。
 * <p>
 * 查询结果格式如下所示：
 * <p>
 * Activity table:
 * +-----------+-----------+------------+--------------+
 * | player_id | device_id | event_date | games_played |
 * +-----------+-----------+------------+--------------+
 * | 1         | 2         | 2016-03-01 | 5            |
 * | 1         | 2         | 2016-03-02 | 6            |
 * | 2         | 3         | 2017-06-25 | 1            |
 * | 3         | 1         | 2016-03-02 | 0            |
 * | 3         | 4         | 2018-07-03 | 5            |
 * +-----------+-----------+------------+--------------+
 * <p>
 * Result table:
 * +-----------+
 * | fraction  |
 * +-----------+
 * | 0.33      |
 * +-----------+
 * 只有 ID 为 1 的玩家在第一天登录后才重新登录，所以答案是 1/3 = 0.33
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-play-analysis-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GamePlayAnalysisIV {

    //# Write your MySQL query statement below
    //select round(sum(case when datediff(a.event_date,b.first_date)=1 then 1 else 0 end)/(select count(distinct(player_id))from Activity),2)  as 'fraction'
    //from Activity as a,
    //(select player_id,min(event_date) as first_date from activity group by player_id) as b
    //where a.player_id=b.player_id

}
