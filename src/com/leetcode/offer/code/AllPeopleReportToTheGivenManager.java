package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * Table: Employees
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | employee_id   | int     |
 * | employee_name | varchar |
 * | manager_id    | int     |
 * +---------------+---------+
 * employee_id is the primary key for this table.
 * Each row of this table indicates that the employee with ID employee_id and name employee_name reports his work to his/her direct manager with manager_id
 * The head of the company is the employee with employee_id = 1.
 *  
 * <p>
 * Write an SQL query to find employee_id of all employees that directly or indirectly report their work to the head of the company.
 * <p>
 * The indirect relation between managers will not exceed 3 managers as the company is small.
 * <p>
 * Return result table in any order without duplicates.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Employees table:
 * +-------------+---------------+------------+
 * | employee_id | employee_name | manager_id |
 * +-------------+---------------+------------+
 * | 1           | Boss          | 1          |
 * | 3           | Alice         | 3          |
 * | 2           | Bob           | 1          |
 * | 4           | Daniel        | 2          |
 * | 7           | Luis          | 4          |
 * | 8           | Jhon          | 3          |
 * | 9           | Angela        | 8          |
 * | 77          | Robert        | 1          |
 * +-------------+---------------+------------+
 * <p>
 * Result table:
 * +-------------+
 * | employee_id |
 * +-------------+
 * | 2           |
 * | 77          |
 * | 4           |
 * | 7           |
 * +-------------+
 * <p>
 * The head of the company is the employee with employee_id 1.
 * The employees with employee_id 2 and 77 report their work directly to the head of the company.
 * The employee with employee_id 4 report his work indirectly to the head of the company 4 --> 2 --> 1.
 * The employee with employee_id 7 report his work indirectly to the head of the company 7 --> 4 --> 2 --> 1.
 * The employees with employee_id 3, 8 and 9 don't report their work to head of company directly or indirectly.
 * 在真实的面试中遇到过这道题？
 * <p>
 * 是
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-people-report-to-the-given-manager
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AllPeopleReportToTheGivenManager {

    //# Write your MySQL query statement below
    //select e.employee_id
    //from employees e
    //left join employees e1
    //on e1.employee_id = e.manager_id
    //left join employees e2
    //on e2.employee_id = e1.manager_id
    //where e2.manager_id = 1 and e.employee_id !=1

}
