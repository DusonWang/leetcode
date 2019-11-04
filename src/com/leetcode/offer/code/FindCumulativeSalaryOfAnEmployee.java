package com.leetcode.offer.code;

/**
 * @author duson
 * Employee 表保存了一年内的薪水信息。
 * <p>
 * 请你编写 SQL 语句，来查询一个员工三个月内的累计薪水，但是不包括最近一个月的薪水。
 * <p>
 * 结果请按 'Id' 升序，然后按 'Month' 降序显示。
 * <p>
 * 示例：
 * 输入：
 * <p>
 * | Id | Month | Salary |
 * |----|-------|--------|
 * | 1  | 1     | 20     |
 * | 2  | 1     | 20     |
 * | 1  | 2     | 30     |
 * | 2  | 2     | 30     |
 * | 3  | 2     | 40     |
 * | 1  | 3     | 40     |
 * | 3  | 3     | 60     |
 * | 1  | 4     | 60     |
 * | 3  | 4     | 70     |
 * 输出：
 * <p>
 * | Id | Month | Salary |
 * |----|-------|--------|
 * | 1  | 3     | 90     |
 * | 1  | 2     | 50     |
 * | 1  | 1     | 20     |
 * | 2  | 1     | 20     |
 * | 3  | 3     | 100    |
 * | 3  | 2     | 40     |
 *  
 * <p>
 * 解释：
 * <p>
 * 员工 '1' 除去最近一个月（月份 '4'），有三个月的薪水记录：月份 '3' 薪水为 40，月份 '2' 薪水为 30，月份 '1' 薪水为 20。
 * <p>
 * 所以近 3 个月的薪水累计分别为 (40 + 30 + 20) = 90，(30 + 20) = 50 和 20。
 * <p>
 * | Id | Month | Salary |
 * |----|-------|--------|
 * | 1  | 3     | 90     |
 * | 1  | 2     | 50     |
 * | 1  | 1     | 20     |
 * 员工 '2' 除去最近的一个月（月份 '2'）的话，只有月份 '1' 这一个月的薪水记录。
 * <p>
 * | Id | Month | Salary |
 * |----|-------|--------|
 * | 2  | 1     | 20     |
 * 员工 '3' 除去最近一个月（月份 '4'）后有两个月，分别为：月份 '4' 薪水为 60 和 月份 '2' 薪水为 40。所以各月的累计情况如下：
 * <p>
 * | Id | Month | Salary |
 * |----|-------|--------|
 * | 3  | 3     | 100    |
 * | 3  | 2     | 40     |
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-cumulative-salary-of-an-employee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindCumulativeSalaryOfAnEmployee {

    //# # Write your MySQL query statement below
    //select a.Id as 'id',a.Month as 'month',a.Salary
    //from
    //(
    //    select e1.Id,e1.Month,sum(e2.Salary) as 'Salary'
    //    from employee as e1
    //    join employee as e2
    //    on e1.Id=e2.Id and e1.Month>=e2.Month and e2.Month>=e1.Month-2
    //    group by e1.Id,e1.Month
    //) as a
    //join
    //(
    //    select e1.Id,Max(Month) as 'Month'
    //    from employee as e1
    //    group by e1.Id
    //) as b
    //on a.Id=b.Id and a.Month<b.Month
    //order by a.Id,a.Month desc
}
