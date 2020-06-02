package com.leetcode.offer.code;

/**
 * @author duson
 * 表：Movies
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | movie_id      | int     |
 * | title         | varchar |
 * +---------------+---------+
 * movie_id 是这个表的主键。
 * title 是电影的名字。
 * 表：Users
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user_id       | int     |
 * | name          | varchar |
 * +---------------+---------+
 * user_id 是表的主键。
 * 表：Movie_Rating
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | movie_id      | int     |
 * | user_id       | int     |
 * | rating        | int     |
 * | created_at    | date    |
 * +---------------+---------+
 * (movie_id, user_id) 是这个表的主键。
 * 这个表包含用户在其评论中对电影的评分 rating 。
 * created_at 是用户的点评日期。
 * ?
 * <p>
 * 请你编写一组?SQL 查询：
 * <p>
 * 查找评论电影数量最多的用户名。
 * 如果出现平局，返回字典序较小的用户名。
 * <p>
 * 查找在 2020 年 2 月 平均评分最高 的电影名称。
 * 如果出现平局，返回字典序较小的电影名称。
 * <p>
 * 查询分两行返回，查询结果格式如下例所示：
 * <p>
 * Movies 表：
 * +-------------+--------------+
 * | movie_id    |  title       |
 * +-------------+--------------+
 * | 1           | Avengers     |
 * | 2           | Frozen 2     |
 * | 3           | Joker        |
 * +-------------+--------------+
 * <p>
 * Users 表：
 * +-------------+--------------+
 * | user_id     |  name        |
 * +-------------+--------------+
 * | 1           | Daniel       |
 * | 2           | Monica       |
 * | 3           | Maria        |
 * | 4           | James        |
 * +-------------+--------------+
 * <p>
 * Movie_Rating 表：
 * +-------------+--------------+--------------+-------------+
 * | movie_id    | user_id      | rating       | created_at  |
 * +-------------+--------------+--------------+-------------+
 * | 1           | 1            | 3            | 2020-01-12  |
 * | 1           | 2            | 4            | 2020-02-11  |
 * | 1           | 3            | 2            | 2020-02-12  |
 * | 1           | 4            | 1            | 2020-01-01  |
 * | 2           | 1            | 5            | 2020-02-17  |
 * | 2           | 2            | 2            | 2020-02-01  |
 * | 2           | 3            | 2            | 2020-03-01  |
 * | 3           | 1            | 3            | 2020-02-22  |
 * | 3           | 2            | 4            | 2020-02-25  |
 * +-------------+--------------+--------------+-------------+
 * <p>
 * Result 表：
 * +--------------+
 * | results      |
 * +--------------+
 * | Daniel       |
 * | Frozen 2     |
 * +--------------+
 * <p>
 * Daniel 和 Monica 都点评了 3 部电影（"Avengers", "Frozen 2" 和 "Joker"） 但是 Daniel 字典序比较小。
 * Frozen 2 和 Joker 在 2 月的评分都是 3.5，但是 Frozen 2 的字典序比较小。
 * 通过次数583提交次数1,251
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/movie-rating
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovieRating2 {

    //(select u.name `results` from Users u left join Movie_Rating m on u.user_id = m.user_id group by m.user_id order by count(m.user_id) desc,u.name asc limit 1)
    //union
    //(select m.title `results` from Movies m left join Movie_Rating mr on m.movie_id = mr.movie_id where created_at between '2020-02-01' and '2020-02-29' group by mr.movie_id order by avg(mr.rating) desc,m.title asc limit 1)
}
