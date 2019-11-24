package com.leetcode.offer.code;

/**
 * @author duson
 * Table: Queries
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | query_name  | varchar |
 * | result      | varchar |
 * | position    | int     |
 * | rating      | int     |
 * +-------------+---------+
 * There is no primary key for this table, it may have duplicate rows.
 * This table contains information collected from some queries on a database.
 * The position column has a value from 1 to 500.
 * The rating column has a value from 1 to 5. Query with rating less than 3 is a poor query.
 *  
 * <p>
 * We define query quality as:
 * <p>
 * The average of the ratio between query rating and its position.
 * <p>
 * We also define poor query percentage as:
 * <p>
 * The percentage of all queries with rating less than 3.
 * <p>
 * Write an SQL query to find each query_name, the quality and poor_query_percentage.
 * <p>
 * Both quality and poor_query_percentage should be rounded to 2 decimal places.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Queries table:
 * +------------+-------------------+----------+--------+
 * | query_name | result            | position | rating |
 * +------------+-------------------+----------+--------+
 * | Dog        | Golden Retriever  | 1        | 5      |
 * | Dog        | German Shepherd   | 2        | 5      |
 * | Dog        | Mule              | 200      | 1      |
 * | Cat        | Shirazi           | 5        | 2      |
 * | Cat        | Siamese           | 3        | 3      |
 * | Cat        | Sphynx            | 7        | 4      |
 * +------------+-------------------+----------+--------+
 * <p>
 * Result table:
 * +------------+---------+-----------------------+
 * | query_name | quality | poor_query_percentage |
 * +------------+---------+-----------------------+
 * | Dog        | 2.50    | 33.33                 |
 * | Cat        | 0.66    | 33.33                 |
 * +------------+---------+-----------------------+
 * <p>
 * Dog queries quality is ((5 / 1) + (5 / 2) + (1 / 200)) / 3 = 2.50
 * Dog queries poor_ query_percentage is (1 / 3) * 100 = 33.33
 * <p>
 * Cat queries quality equals ((2 / 5) + (3 / 3) + (4 / 7)) / 3 = 0.66
 * Cat queries poor_ query_percentage is (1 / 3) * 100 = 33.33
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queries-quality-and-percentage
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class QueriesQualityAndPercentage {

    //# Write your MySQL query statement below
    //SELECT query_name, ROUND(AVG(unavg_quality), 2) AS quality,
    //    ROUND(AVG(poor_query) * 100, 2) AS poor_query_percentage
    //FROM
    //(
    //SELECT query_name, rating, rating/position AS unavg_quality,
    //    IF(rating >= 3, 0, 1) AS poor_query
    //FROM Queries
    //) AS temp
    //GROUP BY query_name;

}
