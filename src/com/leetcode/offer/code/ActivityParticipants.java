package com.leetcode.offer.code;

/**
 * @author duson
 * ��: Friends
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | id            | int     |
 * | name          | varchar |
 * | activity      | varchar |
 * +---------------+---------+
 * id �����ѵ� id �͸ñ������
 * name �����ѵ�����
 * activity �����ѲμӵĻ������
 * ��: Activities
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | id            | int     |
 * | name          | varchar |
 * +---------------+---------+
 * id �Ǹñ������
 * name �ǻ������
 * ?
 * <p>
 * дһ�� SQL ��ѯ��Щ��û����࣬Ҳû�����ٲ����ߵĻ������
 * <p>
 * �������κ�˳�򷵻ؽ����Activities ���ÿ���Ĳ����߶����� Friends ��
 * <p>
 * �����ǲ�ѯ�����ʽ�����ӣ�
 * <p>
 * Friends ��:
 * +------+--------------+---------------+
 * | id   | name         | activity      |
 * +------+--------------+---------------+
 * | 1    | Jonathan D.  | Eating        |
 * | 2    | Jade W.      | Singing       |
 * | 3    | Victor J.    | Singing       |
 * | 4    | Elvis Q.     | Eating        |
 * | 5    | Daniel A.    | Eating        |
 * | 6    | Bob B.       | Horse Riding  |
 * +------+--------------+---------------+
 * <p>
 * Activities ��:
 * +------+--------------+
 * | id   | name         |
 * +------+--------------+
 * | 1    | Eating       |
 * | 2    | Singing      |
 * | 3    | Horse Riding |
 * +------+--------------+
 * <p>
 * Result ��:
 * +--------------+
 * | activity     |
 * +--------------+
 * | Singing      |
 * +--------------+
 * <p>
 * Eating ��������˲μ�, ������˲μӵĻ (Jonathan D. , Elvis Q. and Daniel A.)
 * Horse Riding ���һ���˲μ�, �������˲μӵĻ (Bob B.)
 * Singing ��������˲μ� (Victor J. and Jade W.)
 * ͨ������652�ύ����1,073
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/activity-participants
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ActivityParticipants {

    //WITH People AS (SELECT activity, COUNT(name) AS people
    //  FROM Friends
    // GROUP BY activity)
    //
    // SELECT activity FROM People
    //  WHERE people>(SELECT MIN(people) FROM People)
    //    AND people<(SELECT MAX(people) FROM People)
}
