package com.leetcode.offer.code;

/**
 * @author duson
 * 编写一个 SQL 查询来实现分数排名。如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。
 * <p>
 * +----+-------+
 * | Id | Score |
 * +----+-------+
 * | 1  | 3.50  |
 * | 2  | 3.65  |
 * | 3  | 4.00  |
 * | 4  | 3.85  |
 * | 5  | 4.00  |
 * | 6  | 3.65  |
 * +----+-------+
 * 例如，根据上述给定的 Scores 表，你的查询应该返回（按分数从高到低排列）：
 * <p>
 * +-------+------+
 * | Score | Rank |
 * +-------+------+
 * | 4.00  | 1    |
 * | 4.00  | 1    |
 * | 3.85  | 2    |
 * | 3.65  | 3    |
 * | 3.65  | 3    |
 * | 3.50  | 4    |
 * +-------+------+
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rank-scores
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RankScores {

    //# Write your MySQL query statement below
    //select Score, dense_rank() over (order by Score desc)  as `Rank`
    //from Scores;

}
