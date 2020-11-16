package code.code;

/**
 * @author duson
 * <p>
 * Table: Actions
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user_id       | int     |
 * | post_id       | int     |
 * | action_date   | date    |
 * | action        | enum    |
 * | extra         | varchar |
 * +---------------+---------+
 * There is no primary key for this table, it may have duplicate rows.
 * The action column is an ENUM type of ('view', 'like', 'reaction', 'comment', 'report', 'share').
 * The extra column has optional information about the action such as a reason for report or a type of reaction.
 *  
 * <p>
 * Write an SQL query that reports the number of posts reported yesterday for each report reason. Assume today is 2019-07-05.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Actions table:
 * +---------+---------+-------------+--------+--------+
 * | user_id | post_id | action_date | action | extra  |
 * +---------+---------+-------------+--------+--------+
 * | 1       | 1       | 2019-07-01  | view   | null   |
 * | 1       | 1       | 2019-07-01  | like   | null   |
 * | 1       | 1       | 2019-07-01  | share  | null   |
 * | 2       | 4       | 2019-07-04  | view   | null   |
 * | 2       | 4       | 2019-07-04  | report | spam   |
 * | 3       | 4       | 2019-07-04  | view   | null   |
 * | 3       | 4       | 2019-07-04  | report | spam   |
 * | 4       | 3       | 2019-07-02  | view   | null   |
 * | 4       | 3       | 2019-07-02  | report | spam   |
 * | 5       | 2       | 2019-07-04  | view   | null   |
 * | 5       | 2       | 2019-07-04  | report | racism |
 * | 5       | 5       | 2019-07-04  | view   | null   |
 * | 5       | 5       | 2019-07-04  | report | racism |
 * +---------+---------+-------------+--------+--------+
 * <p>
 * Result table:
 * +---------------+--------------+
 * | report_reason | report_count |
 * +---------------+--------------+
 * | spam          | 1            |
 * | racism        | 2            |
 * +---------------+--------------+
 * Note that we only care about report reasons with non zero number of reports.
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reported-posts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReportedPosts {

    //# Write your MySQL query statement below
    //select extra report_reason, count(distinct post_id) report_count
    //from Actions
    //where datediff('2019-07-05', action_date) = 1
    //and extra is not null
    //and action = 'report'
    //group by extra
}
