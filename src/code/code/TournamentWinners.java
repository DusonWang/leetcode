package code.code;

/**
 * @author duson
 * Players 玩家表
 * <p>
 * +-------------+-------+
 * | Column Name | Type  |
 * +-------------+-------+
 * | player_id   | int   |
 * | group_id    | int   |
 * +-------------+-------+
 * 玩家 ID 是此表的主键。
 * 此表的每一行表示每个玩家的组。
 * Matches 赛事表
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | match_id      | int     |
 * | first_player  | int     |
 * | second_player | int     |
 * | first_score   | int     |
 * | second_score  | int     |
 * +---------------+---------+
 * match_id 是此表的主键。
 * 每一行是一场比赛的记录，第一名和第二名球员包含每场比赛的球员 ID。
 * 第一个玩家和第二个玩家的分数分别包含第一个玩家和第二个玩家的分数。
 * 你可以假设，在每一场比赛中，球员都属于同一组。
 *  
 * <p>
 * 每组的获胜者是在组内得分最高的选手。如果平局，得分最低的选手获胜。
 * <p>
 * 编写一个 SQL 查询来查找每组中的获胜者。
 * <p>
 * 查询结果格式如下所示
 * <p>
 * Players 表:
 * +-----------+------------+
 * | player_id | group_id   |
 * +-----------+------------+
 * | 15        | 1          |
 * | 25        | 1          |
 * | 30        | 1          |
 * | 45        | 1          |
 * | 10        | 2          |
 * | 35        | 2          |
 * | 50        | 2          |
 * | 20        | 3          |
 * | 40        | 3          |
 * +-----------+------------+
 * <p>
 * Matches 表:
 * +------------+--------------+---------------+-------------+--------------+
 * | match_id   | first_player | second_player | first_score | second_score |
 * +------------+--------------+---------------+-------------+--------------+
 * | 1          | 15           | 45            | 3           | 0            |
 * | 2          | 30           | 25            | 1           | 2            |
 * | 3          | 30           | 15            | 2           | 0            |
 * | 4          | 40           | 20            | 5           | 2            |
 * | 5          | 35           | 50            | 1           | 1            |
 * +------------+--------------+---------------+-------------+--------------+
 * <p>
 * Result 表:
 * +-----------+------------+
 * | group_id  | player_id  |
 * +-----------+------------+
 * | 1         | 15         |
 * | 2         | 35         |
 * | 3         | 40         |
 * +-----------+------------+
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tournament-winners
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TournamentWinners {

    //# Write your MySQL query statement below
    //select group_id as "GROUP_ID",player_id as "PLAYER_ID"
    //from (
    // select group_id,player_id,sum(
    //     case when player_id=first_player then first_score
    //        when player_id=second_player then second_score
    //     end
    //    )as score
    //    from Players,Matches
    //    where Matches.first_player=Players.player_id or Matches.second_player=Players.player_id
    //    group by group_id,player_id
    //    order by group_id,score desc,player_id
    //) as t
    //group by group_id
    //order by group_id,score desc,player_id
}
