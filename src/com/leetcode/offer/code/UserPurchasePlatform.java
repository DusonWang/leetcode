package com.leetcode.offer.code;

/**
 * @author duson
 * ֧����: Spending
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | user_id     | int     |
 * | spend_date  | date    |
 * | platform    | enum    |
 * | amount      | int     |
 * +-------------+---------+
 * ���ű��¼���û���һ�����߹�����վ��֧����ʷ�������߹���ƽ̨ͬʱӵ������ˣ�'desktop'�����ֻ��ˣ�'mobile'����Ӧ�ó���
 * ���ű�������� (user_id, spend_date, platform)��
 * ƽ̨�� platform ��һ�� ENUM ������Ϊ��'desktop', 'mobile'����
 * ?
 * <p>
 * дһ�� SQL ������ÿ��?��?ʹ���ֻ����û�����?ʹ��������û���?ͬʱ?ʹ������˺��ֻ��˵��û���������֧����
 * <p>
 * ��ѯ�����ʽ��������ʾ��
 * <p>
 * Spending table:
 * +---------+------------+----------+--------+
 * | user_id | spend_date | platform | amount |
 * +---------+------------+----------+--------+
 * | 1       | 2019-07-01 | mobile   | 100    |
 * | 1       | 2019-07-01 | desktop  | 100    |
 * | 2       | 2019-07-01 | mobile   | 100    |
 * | 2       | 2019-07-02 | mobile   | 100    |
 * | 3       | 2019-07-01 | desktop  | 100    |
 * | 3       | 2019-07-02 | desktop  | 100    |
 * +---------+------------+----------+--------+
 * <p>
 * Result table:
 * +------------+----------+--------------+-------------+
 * | spend_date | platform | total_amount | total_users |
 * +------------+----------+--------------+-------------+
 * | 2019-07-01 | desktop  | 100          | 1           |
 * | 2019-07-01 | mobile   | 100          | 1           |
 * | 2019-07-01 | both     | 200          | 1           |
 * | 2019-07-02 | desktop  | 100          | 1           |
 * | 2019-07-02 | mobile   | 100          | 1           |
 * | 2019-07-02 | both     | 0            | 0           |
 * +------------+----------+--------------+-------------+
 * �� 2019-07-01, �û�1 ͬʱ ʹ������˺��ֻ��˹���, �û�2 �� ʹ�����ֻ��˹��򣬶��û�3 �� ʹ��������˹���
 * �� 2019-07-02, �û�2 �� ʹ�����ֻ��˹���, �û�3 �� ʹ��������˹�����û���û� ͬʱ ʹ������˺��ֻ��˹���
 * ͨ������630�ύ����1,352
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/user-purchase-platform
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class UserPurchasePlatform {

    //SELECT
    //    t1.spend_date, t1.platform,
    //    IFNULL(SUM(amount), 0) total_amount,
    //    IFNULL(COUNT(DISTINCT user_id), 0) total_users
    //FROM
    //    (SELECT DISTINCT spend_date, 'desktop' platform FROM Spending
    //    UNION
    //    SELECT DISTINCT spend_date, 'mobile' platform FROM Spending
    //    UNION
    //    SELECT DISTINCT spend_date, 'both' platform FROM Spending) t1
    //    LEFT JOIN
    //    (SELECT
    //        user_id, spend_date,
    //        (CASE WHEN COUNT(platform) = 1 THEN platform ELSE 'both' END) platform,
    //        SUM(amount) amount
    //    FROM Spending
    //    GROUP BY spend_date, user_id) t2
    //    ON t1.spend_date = t2.spend_date AND t1.platform = t2.platform
    //GROUP BY t1.spend_date, t1.platform

}
