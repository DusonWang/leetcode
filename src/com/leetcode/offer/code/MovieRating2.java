package com.leetcode.offer.code;

/**
 * @author duson
 * ��Movies
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | movie_id      | int     |
 * | title         | varchar |
 * +---------------+---------+
 * movie_id ��������������
 * title �ǵ�Ӱ�����֡�
 * ��Users
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user_id       | int     |
 * | name          | varchar |
 * +---------------+---------+
 * user_id �Ǳ��������
 * ��Movie_Rating
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | movie_id      | int     |
 * | user_id       | int     |
 * | rating        | int     |
 * | created_at    | date    |
 * +---------------+---------+
 * (movie_id, user_id) ��������������
 * ���������û����������жԵ�Ӱ������ rating ��
 * created_at ���û��ĵ������ڡ�
 * ?
 * <p>
 * �����дһ��?SQL ��ѯ��
 * <p>
 * �������۵�Ӱ���������û�����
 * �������ƽ�֣������ֵ����С���û�����
 * <p>
 * ������ 2020 �� 2 �� ƽ��������� �ĵ�Ӱ���ơ�
 * �������ƽ�֣������ֵ����С�ĵ�Ӱ���ơ�
 * <p>
 * ��ѯ�����з��أ���ѯ�����ʽ��������ʾ��
 * <p>
 * Movies ��
 * +-------------+--------------+
 * | movie_id    |  title       |
 * +-------------+--------------+
 * | 1           | Avengers     |
 * | 2           | Frozen 2     |
 * | 3           | Joker        |
 * +-------------+--------------+
 * <p>
 * Users ��
 * +-------------+--------------+
 * | user_id     |  name        |
 * +-------------+--------------+
 * | 1           | Daniel       |
 * | 2           | Monica       |
 * | 3           | Maria        |
 * | 4           | James        |
 * +-------------+--------------+
 * <p>
 * Movie_Rating ��
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
 * Result ��
 * +--------------+
 * | results      |
 * +--------------+
 * | Daniel       |
 * | Frozen 2     |
 * +--------------+
 * <p>
 * Daniel �� Monica �������� 3 ����Ӱ��"Avengers", "Frozen 2" �� "Joker"�� ���� Daniel �ֵ���Ƚ�С��
 * Frozen 2 �� Joker �� 2 �µ����ֶ��� 3.5������ Frozen 2 ���ֵ���Ƚ�С��
 * ͨ������583�ύ����1,251
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/movie-rating
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MovieRating2 {

    //(select u.name `results` from Users u left join Movie_Rating m on u.user_id = m.user_id group by m.user_id order by count(m.user_id) desc,u.name asc limit 1)
    //union
    //(select m.title `results` from Movies m left join Movie_Rating mr on m.movie_id = mr.movie_id where created_at between '2020-02-01' and '2020-02-29' group by mr.movie_id order by avg(mr.rating) desc,m.title asc limit 1)
}
