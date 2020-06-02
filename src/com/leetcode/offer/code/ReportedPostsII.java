package com.leetcode.offer.code;

/**
 * @author duson
 * ������?Actions
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user_id       | int     |
 * | post_id       | int     |
 * | action_date   | date    |
 * | action        | enum    |
 * | extra         | varchar |
 * +---------------+---------+
 * ���ű�û�����������п��ܴ����ظ����С�
 * action �е������� ENUM�����ܵ�ֵΪ ('view', 'like', 'reaction', 'comment', 'report', 'share')��
 * extra ��ӵ��һЩ��ѡ��Ϣ�����磺�������ɣ�a reason for report����Ӧ���ͣ�a type of reaction���ȡ�
 * �Ƴ���?Removals
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | post_id       | int     |
 * | remove_date   | date    |
 * +---------------+---------+
 * ���ű�������� post_id��
 * ���ű��ÿһ�б�ʾһ�����Ƴ������ӣ�ԭ����������ڱ��ٱ��򱻹���Ա��顣
 * ?
 *
 * ��дһ�� SQL �����ң��ڱ�����Ϊ�������������У����Ƴ������ӵ�ÿ��ƽ��ռ�ȣ��������뵽С����� 2 λ��
 *
 * ��ѯ����ĸ�ʽ���£�
 *
 * Actions table:
 * +---------+---------+-------------+--------+--------+
 * | user_id | post_id | action_date | action | extra  |
 * +---------+---------+-------------+--------+--------+
 * | 1       | 1       | 2019-07-01  | view   | null   |
 * | 1       | 1       | 2019-07-01  | like   | null   |
 * | 1       | 1       | 2019-07-01  | share  | null   |
 * | 2       | 2       | 2019-07-04  | view   | null   |
 * | 2       | 2       | 2019-07-04  | report | spam   |
 * | 3       | 4       | 2019-07-04  | view   | null   |
 * | 3       | 4       | 2019-07-04  | report | spam   |
 * | 4       | 3       | 2019-07-02  | view   | null   |
 * | 4       | 3       | 2019-07-02  | report | spam   |
 * | 5       | 2       | 2019-07-03  | view   | null   |
 * | 5       | 2       | 2019-07-03  | report | racism |
 * | 5       | 5       | 2019-07-03  | view   | null   |
 * | 5       | 5       | 2019-07-03  | report | racism |
 * +---------+---------+-------------+--------+--------+
 *
 * Removals table:
 * +---------+-------------+
 * | post_id | remove_date |
 * +---------+-------------+
 * | 2       | 2019-07-20  |
 * | 3       | 2019-07-18  |
 * +---------+-------------+
 *
 * Result table:
 * +-----------------------+
 * | average_daily_percent |
 * +-----------------------+
 * | 75.00                 |
 * +-----------------------+
 * 2019-07-04 ����������Ƴ����� 50%����Ϊ���������ӱ�����Ϊ������棬��ֻ��һ���õ��Ƴ���
 * 2019-07-02 ����������Ƴ����� 100%����Ϊ��һ�����ӱ��ٱ�Ϊ������沢�õ��Ƴ���
 * ���༸��û���յ��������ľٱ������ƽ��ֵΪ��(50 + 100) / 2 = 75%
 * ע�⣬�������Ҫһ��ƽ��ֵ���ɣ����ǲ�����ע�Ƴ����������ڡ�
 * ͨ������927�ύ����2,361
 * ����ʵ������������������⣿
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reported-posts-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ReportedPostsII {

    //select round(100*avg(rate),2) as average_daily_percent
    //from
    //(
    //select t1.action_date,count(r.post_id)/count(t1.post_id) as rate
    //from
    //(select distinct post_id,action_date
    //from actions
    //where extra="spam") t1
    //left join removals r
    //on t1.post_id=r.post_id
    //group by t1.action_date
    //) t2

}
