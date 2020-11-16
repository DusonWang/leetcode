package code.code;

/**
 * Table: Teams
 *
 * +---------------+----------+
 * | Column Name   | Type     |
 * +---------------+----------+
 * | team_id       | int      |
 * | team_name     | varchar  |
 * +---------------+----------+
 * 此表的主键是 team_id，表中的每一行都代表一支独立足球队。
 * Table:?Matches
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | match_id      | int     |
 * | host_team     | int     |
 * | guest_team    | int     |
 * | host_goals    | int     |
 * | guest_goals   | int     |
 * +---------------+---------+
 * 此表的主键是 match_id，表中的每一行都代表一场已结束的比赛，比赛的主客队分别由它们自己的 id 表示，他们的进球由 host_goals 和 guest_goals 分别表示。
 * ?
 *
 * 积分规则如下：
 *
 * 赢一场得三分；
 * 平一场得一分；
 * 输一场不得分。
 * 写出一条SQL语句以查询每个队的?team_id，team_name 和 num_points。结果根据?num_points 降序排序，如果有两队积分相同，那么这两队按?team_id? 升序排序。
 *
 * 查询结果格式如下：
 *
 * Teams table:
 * +-----------+--------------+
 * | team_id   | team_name    |
 * +-----------+--------------+
 * | 10        | Leetcode FC  |
 * | 20        | NewYork FC   |
 * | 30        | Atlanta FC   |
 * | 40        | Chicago FC   |
 * | 50        | Toronto FC   |
 * +-----------+--------------+
 *
 * Matches table:
 * +------------+--------------+---------------+-------------+--------------+
 * | match_id   | host_team    | guest_team    | host_goals  | guest_goals  |
 * +------------+--------------+---------------+-------------+--------------+
 * | 1          | 10           | 20            | 3           | 0            |
 * | 2          | 30           | 10            | 2           | 2            |
 * | 3          | 10           | 50            | 5           | 1            |
 * | 4          | 20           | 30            | 1           | 0            |
 * | 5          | 50           | 30            | 1           | 0            |
 * +------------+--------------+---------------+-------------+--------------+
 *
 * Result table:
 * +------------+--------------+---------------+
 * | team_id    | team_name    | num_points    |
 * +------------+--------------+---------------+
 * | 10         | Leetcode FC  | 7             |
 * | 20         | NewYork FC   | 3             |
 * | 50         | Toronto FC   | 3             |
 * | 30         | Atlanta FC   | 1             |
 * | 40         | Chicago FC   | 0             |
 * +------------+--------------+---------------+
 * 通过次数787提交次数1,626
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/team-scores-in-football-tournament
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class TeamScore {

    //select t.team_id,t.team_name,
    //sum(case when t.team_id = m1.host_team and m1.host_goals > m1.guest_goals then 3
    //         when m1.host_goals = m1.guest_goals then 1
    //         when  t.team_id = m1.guest_team and m1.guest_goals>m1.host_goals THEN 3
    //         ELSE 0 END ) `num_points`
    //from Teams t
    //left join Matches m1
    //on t.team_id = m1.host_team or t.team_id = m1.guest_team
    //group by t.team_id
    //order by num_points desc,team_id asc
}
