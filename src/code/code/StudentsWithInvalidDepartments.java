package code.code;

/**
 * @author duson
 * SQL架构
 * Table: Departments
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | id            | int     |
 * | name          | varchar |
 * +---------------+---------+
 * id is the primary key of this table.
 * The table has information about the id of each department of a university.
 * <p>
 * <p>
 * Table: Students
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | id            | int     |
 * | name          | varchar |
 * | department_id | int     |
 * +---------------+---------+
 * id is the primary key of this table.
 * The table has information about the id of each student at a university and the id of the department he/she studies at.
 * <p>
 * <p>
 * Write an SQL query to find the id and the name of all students who are enrolled in departments that no longer exists.
 * <p>
 * Return the result table in any order.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Departments table:
 * +------+--------------------------+
 * | id   | name                     |
 * +------+--------------------------+
 * | 1    | Electrical Engineering   |
 * | 7    | Computer Engineering     |
 * | 13   | Bussiness Administration |
 * +------+--------------------------+
 * <p>
 * Students table:
 * +------+----------+---------------+
 * | id   | name     | department_id |
 * +------+----------+---------------+
 * | 23   | Alice    | 1             |
 * | 1    | Bob      | 7             |
 * | 5    | Jennifer | 13            |
 * | 2    | John     | 14            |
 * | 4    | Jasmine  | 77            |
 * | 3    | Steve    | 74            |
 * | 6    | Luis     | 1             |
 * | 8    | Jonathan | 7             |
 * | 7    | Daiana   | 33            |
 * | 11   | Madelynn | 1             |
 * +------+----------+---------------+
 * <p>
 * Result table:
 * +------+----------+
 * | id   | name     |
 * +------+----------+
 * | 2    | John     |
 * | 7    | Daiana   |
 * | 4    | Jasmine  |
 * | 3    | Steve    |
 * +------+----------+
 * <p>
 * John, Daiana, Steve and Jasmine are enrolled in departments 14, 33, 74 and 77 respectively. department 14, 33, 74 and 77 doesn't exist in the Departments table.
 * 通过次数130提交次数145
 * 在真实的面试中遇到过这道题？
 */
public class StudentsWithInvalidDepartments {

    //# Write your MySQL query statement below
    //select distinct id,name
    //from Students
    //where department_id not in (
    //    select id from Departments
    //)

}
