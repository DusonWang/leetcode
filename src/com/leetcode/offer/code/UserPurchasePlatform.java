package com.leetcode.offer.code;

/**
 * @author duson
 * 支出表: Spending
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | user_id     | int     |
 * | spend_date  | date    |
 * | platform    | enum    |
 * | amount      | int     |
 * +-------------+---------+
 * 这张表记录了用户在一个在线购物网站的支出历史，该在线购物平台同时拥有桌面端（'desktop'）和手机端（'mobile'）的应用程序。
 * 这张表的主键是 (user_id, spend_date, platform)。
 * 平台列 platform 是一种 ENUM ，类型为（'desktop', 'mobile'）。
 * ?
 * <p>
 * 写一段 SQL 来查找每天?仅?使用手机端用户、仅?使用桌面端用户和?同时?使用桌面端和手机端的用户人数和总支出金额。
 * <p>
 * 查询结果格式如下例所示：
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
 * 在 2019-07-01, 用户1 同时 使用桌面端和手机端购买, 用户2 仅 使用了手机端购买，而用户3 仅 使用了桌面端购买。
 * 在 2019-07-02, 用户2 仅 使用了手机端购买, 用户3 仅 使用了桌面端购买，且没有用户 同时 使用桌面端和手机端购买。
 * 通过次数630提交次数1,352
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/user-purchase-platform
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
