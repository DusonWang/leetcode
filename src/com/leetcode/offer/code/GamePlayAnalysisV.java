package com.leetcode.offer.code;

/**
 * @author duson
 * Activity 活动记录表
 * <p>
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | player_id    | int     |
 * | device_id    | int     |
 * | event_date   | date    |
 * | games_played | int     |
 * +--------------+---------+
 * （player_id，event_date）是此表的主键
 * 这张表显示了某些游戏的玩家的活动情况
 * 每一行是一个玩家的记录，他在某一天使用某个设备注销之前登录并玩了很多游戏（可能是 0）
 *  
 * <p>
 * 我们将玩家的安装日期定义为该玩家的第一个登录日。
 * <p>
 * 我们还将某个日期 X 的第 1 天保留时间定义为安装日期为 X 的玩家的数量，他们在 X 之后的一天重新登录，除以安装日期为 X 的玩家的数量，四舍五入到小数点后两位。
 * <p>
 * 编写一个 SQL 查询，报告每个安装日期、当天安装游戏的玩家数量和第一天的保留时间。
 * <p>
 * 查询结果格式如下所示：
 * <p>
 * Activity 表：
 * +-----------+-----------+------------+--------------+
 * | player_id | device_id | event_date | games_played |
 * +-----------+-----------+------------+--------------+
 * | 1         | 2         | 2016-03-01 | 5            |
 * | 1         | 2         | 2016-03-02 | 6            |
 * | 2         | 3         | 2017-06-25 | 1            |
 * | 3         | 1         | 2016-03-01 | 0            |
 * | 3         | 4         | 2016-07-03 | 5            |
 * +-----------+-----------+------------+--------------+
 * <p>
 * Result 表：
 * +------------+----------+----------------+
 * | install_dt | installs | Day1_retention |
 * +------------+----------+----------------+
 * | 2016-03-01 | 2        | 0.50           |
 * | 2017-06-25 | 1        | 0.00           |
 * +------------+----------+----------------+
 * 玩家 1 和 3 在 2016-03-01 安装了游戏，但只有玩家 1 在 2016-03-02 重新登录，所以 2016-03-01 的第一天保留时间是 1/2=0.50
 * 玩家 2 在 2017-06-25 安装了游戏，但在 2017-06-26 没有重新登录，因此 2017-06-25 的第一天保留为 0/1=0.00
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-play-analysis-v
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GamePlayAnalysisV {

    //select a.install_date as 'install_dt',count(a.player_id) as installs,
    //round(COUNT(b.player_id)/COUNT(a.player_id),2) as Day1_retention
    //from
    //(
    //    select player_id,min(event_date) as 'install_date'
    //    from Activity a
    //    group by player_id
    //) as a
    //left join Activity as b
    //on b.event_date=DATE_ADD(a.install_date,INTERVAL 1 Day) and b.player_id=a.player_id
    //group by a.install_date

}
