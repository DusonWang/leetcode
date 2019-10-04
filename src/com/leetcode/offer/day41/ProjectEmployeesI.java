package com.leetcode.offer.day41;

/**
 * @author duson
 * 项目表 Project： 
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | project_id  | int     |
 * | employee_id | int     |
 * +-------------+---------+
 * 主键为 (project_id, employee_id)。
 * employee_id 是员工表 Employee 表的外键。
 * 员工表 Employee：
 * <p>
 * +------------------+---------+
 * | Column Name      | Type    |
 * +------------------+---------+
 * | employee_id      | int     |
 * | name             | varchar |
 * | experience_years | int     |
 * +------------------+---------+
 * 主键是 employee_id。
 *  
 * <p>
 * 请写一个 SQL 语句，查询每一个项目中员工的 平均 工作年限，精确到小数点后两位。
 * <p>
 * 查询结果的格式如下：
 * <p>
 * Project 表：
 * +-------------+-------------+
 * | project_id  | employee_id |
 * +-------------+-------------+
 * | 1           | 1           |
 * | 1           | 2           |
 * | 1           | 3           |
 * | 2           | 1           |
 * | 2           | 4           |
 * +-------------+-------------+
 * <p>
 * Employee 表：
 * +-------------+--------+------------------+
 * | employee_id | name   | experience_years |
 * +-------------+--------+------------------+
 * | 1           | Khaled | 3                |
 * | 2           | Ali    | 2                |
 * | 3           | John   | 1                |
 * | 4           | Doe    | 2                |
 * +-------------+--------+------------------+
 * <p>
 * Result 表：
 * +-------------+---------------+
 * | project_id  | average_years |
 * +-------------+---------------+
 * | 1           | 2.00          |
 * | 2           | 2.50          |
 * +-------------+---------------+
 * 第一个项目中，员工的平均工作年限是 (3 + 2 + 1) / 3 = 2.00；第二个项目中，员工的平均工作年限是 (3 + 2) / 2 = 2.50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/project-employees-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProjectEmployeesI {

    //# Write your MySQL query statement below
    //select p.project_id,round(sum(e.experience_years)/count(1),2) as 'average_years'
    //from Project as p
    //left join Employee e
    //on p.employee_id = e.employee_id
    //group by project_id
}
