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
 * �˱�������� team_id�����е�ÿһ�ж�����һ֧��������ӡ�
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
 * �˱�������� match_id�����е�ÿһ�ж�����һ���ѽ����ı��������������Ͷӷֱ��������Լ��� id ��ʾ�����ǵĽ����� host_goals �� guest_goals �ֱ��ʾ��
 * ?
 *
 * ���ֹ������£�
 *
 * Ӯһ�������֣�
 * ƽһ����һ�֣�
 * ��һ�����÷֡�
 * д��һ��SQL����Բ�ѯÿ���ӵ�?team_id��team_name �� num_points���������?num_points ����������������ӻ�����ͬ����ô�����Ӱ�?team_id? ��������
 *
 * ��ѯ�����ʽ���£�
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
 * ͨ������787�ύ����1,626
 * ����ʵ������������������⣿
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/team-scores-in-football-tournament
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
