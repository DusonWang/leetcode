package com.leetcode.offer.day37;

/**
 * @author duson
 * 这里有张 World 表
 * <p>
 * +-----------------+------------+------------+--------------+---------------+
 * | name            | continent  | area       | population   | gdp           |
 * +-----------------+------------+------------+--------------+---------------+
 * | Afghanistan     | Asia       | 652230     | 25500100     | 20343000      |
 * | Albania         | Europe     | 28748      | 2831741      | 12960000      |
 * | Algeria         | Africa     | 2381741    | 37100000     | 188681000     |
 * | Andorra         | Europe     | 468        | 78115        | 3712000       |
 * | Angola          | Africa     | 1246700    | 20609294     | 100990000     |
 * +-----------------+------------+------------+--------------+---------------+
 * 如果一个国家的面积超过300万平方公里，或者人口超过2500万，那么这个国家就是大国家。
 * <p>
 * 编写一个SQL查询，输出表中所有大国家的名称、人口和面积。
 * <p>
 * 例如，根据上表，我们应该输出:
 * <p>
 * +--------------+-------------+--------------+
 * | name         | population  | area         |
 * +--------------+-------------+--------------+
 * | Afghanistan  | 25500100    | 652230       |
 * | Algeria      | 37100000    | 2381741      |
 * +--------------+-------------+--------------+
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/big-countries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BigCountries {

    //# Write your MySQL query statement below
    //select a.name,a.population,a.area
    //from World as a
    //where a.area>3000000 or a.population>25000000
}
