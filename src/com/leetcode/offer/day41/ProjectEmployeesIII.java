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
 * (project_id, employee_id) 是这个表的主键
 * employee_id 是员工表 Employee 的外键
 * 员工表 Employee：
 * <p>
 * +------------------+---------+
 * | Column Name      | Type    |
 * +------------------+---------+
 * | employee_id      | int     |
 * | name             | varchar |
 * | experience_years | int     |
 * +------------------+---------+
 * employee_id 是这个表的主键
 *  
 * <p>
 * 写 一个 SQL 查询语句，报告在每一个项目中经验最丰富的雇员是谁。如果出现经验年数相同的情况，请报告所有具有最大经验年数的员工。
 * <p>
 * 查询结果格式在以下示例中：
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
 * | 3           | John   | 3                |
 * | 4           | Doe    | 2                |
 * +-------------+--------+------------------+
 * <p>
 * Result 表：
 * +-------------+---------------+
 * | project_id  | employee_id   |
 * +-------------+---------------+
 * | 1           | 1             |
 * | 1           | 3             |
 * | 2           | 1             |
 * +-------------+---------------+
 * employee_id 为 1 和 3 的员工在 project_id 为 1 的项目中拥有最丰富的经验。在 project_id 为 2 的项目中，employee_id 为 1 的员工拥有最丰富的经验。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/project-employees-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProjectEmployeesIII {

    //# Write your MySQL query statement below
    //select p.project_id,e.employee_id
    //from Project as p left join Employee as e on p.employee_id=e.employee_id
    //where (p.project_id,e.experience_years) in (
    //select project_id,max(experience_years)
    //from Project left join Employee on Project.employee_id=Employee.employee_id
    //group by project_id

}
