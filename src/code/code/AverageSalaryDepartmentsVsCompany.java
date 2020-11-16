package code.code;

/**
 * @author duson
 * 给如下两个表，写一个查询语句，求出在每一个工资发放日，每个部门的平均工资与公司的平均工资的比较结果 （高 / 低 / 相同）。
 * <p>
 *  
 * <p>
 * 表： salary
 * <p>
 * | id | employee_id | amount | pay_date   |
 * |----|-------------|--------|------------|
 * | 1  | 1           | 9000   | 2017-03-31 |
 * | 2  | 2           | 6000   | 2017-03-31 |
 * | 3  | 3           | 10000  | 2017-03-31 |
 * | 4  | 1           | 7000   | 2017-02-28 |
 * | 5  | 2           | 6000   | 2017-02-28 |
 * | 6  | 3           | 8000   | 2017-02-28 |
 *  
 * <p>
 * employee_id 字段是表 employee 中 employee_id 字段的外键。
 * <p>
 *  
 * <p>
 * | employee_id | department_id |
 * |-------------|---------------|
 * | 1           | 1             |
 * | 2           | 2             |
 * | 3           | 2             |
 *  
 * <p>
 * 对于如上样例数据，结果为：
 * <p>
 *  
 * <p>
 * | pay_month | department_id | comparison  |
 * |-----------|---------------|-------------|
 * | 2017-03   | 1             | higher      |
 * | 2017-03   | 2             | lower       |
 * | 2017-02   | 1             | same        |
 * | 2017-02   | 2             | same        |
 *  
 * <p>
 * 解释
 * <p>
 *  
 * <p>
 * 在三月，公司的平均工资是 (9000+6000+10000)/3 = 8333.33...
 * <p>
 *  
 * <p>
 * 由于部门 '1' 里只有一个 employee_id 为 '1' 的员工，所以部门 '1' 的平均工资就是此人的工资 9000 。因为 9000 > 8333.33 ，所以比较结果是 'higher'。
 * <p>
 *  
 * <p>
 * 第二个部门的平均工资为 employee_id 为 '2' 和 '3' 两个人的平均工资，为 (6000+10000)/2=8000 。因为 8000 < 8333.33 ，所以比较结果是 'lower' 。
 * <p>
 *  
 * <p>
 * 在二月用同样的公式求平均工资并比较，比较结果为 'same' ，因为部门 '1' 和部门 '2' 的平均工资与公司的平均工资相同，都是 7000 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-salary-departments-vs-company
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AverageSalaryDepartmentsVsCompany {

    //# Write your MySQL query statement below
    //select department_salary.pay_month, department_id,
    //case
    //  when department_avg>company_avg then 'higher'
    //  when department_avg<company_avg then 'lower'
    //  else 'same'
    //end as comparison
    //from
    //(
    //  select department_id, avg(amount) as department_avg, date_format(pay_date, '%Y-%m') as pay_month
    //  from salary join employee on salary.employee_id = employee.employee_id
    //  group by department_id, pay_month
    //) as department_salary
    //join
    //(
    //  select avg(amount) as company_avg,  date_format(pay_date, '%Y-%m') as pay_month from salary group by date_format(pay_date, '%Y-%m')
    //) as company_salary
    //on department_salary.pay_month = company_salary.pay_month;

}
