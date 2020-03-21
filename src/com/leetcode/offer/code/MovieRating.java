package com.leetcode.offer.code;

/**
 * @author duson
 * 表：Movies
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | movie_id      | int     |
 * | title         | varchar |
 * +---------------+---------+
 * movie_id 是这个表的主键。
 * title 是电影的名字。
 * 表：Users
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user_id       | int     |
 * | name          | varchar |
 * +---------------+---------+
 * user_id 是表的主键。
 * 表：Movie_Rating
 *
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
 *
 *
 * 请你编写一组 SQL 查询：
 *
 * 查找评论电影数量最多的用户名。
 * 如果出现平局，返回字典序较小的用户名。
 *
 * 查找在 2020 年 2 月 平均评分最高 的电影名称。
 * 如果出现平局，返回字典序较小的电影名称。
 *
 * 查询分两行返回，查询结果格式如下例所示：
 *
 * Movies 表：
 * +-------------+--------------+
 * | movie_id    |  title       |
 * +-------------+--------------+
 * | 1           | Avengers     |
 * | 2           | Frozen 2     |
 * | 3           | Joker        |
 * +-------------+--------------+
 *
 * Users 表：
 * +-------------+--------------+
 * | user_id     |  name        |
 * +-------------+--------------+
 * | 1           | Daniel       |
 * | 2           | Monica       |
 * | 3           | Maria        |
 * | 4           | James        |
 * +-------------+--------------+
 *
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
 *
 * Result 表：
 * +--------------+
 * | results      |
 * +--------------+
 * | Daniel       |
 * | Frozen 2     |
 * +--------------+
 *
 * Daniel 和 Monica 都点评了 3 部电影（"Avengers", "Frozen 2" 和 "Joker"） 但是 Daniel 字典序比较小。
 * Frozen 2 和 Joker 在 2 月的评分都是 3.5，但是 Frozen 2 的字典序比较小。
 * 通过次数180提交次数390
 * 在真实的面试中遇到过这道题？
 */
public class MovieRating {

    //(select name as results
    //from Movie_Rating as M1
    //join Users as U1
    //on M1.user_id = U1.user_id
    //group by name
    //order by count(1) Desc, name
    //limit 1)
    //union all
    //(select title as results
    //from Movie_Rating as M1
    //join Movies as Mo1
    //on M1.movie_id = Mo1.movie_id
    //where created_at between '2020-02-01' and '2020-02-29'
    //group by title
    //order by avg(rating) Desc, title
    //limit 1)
}
