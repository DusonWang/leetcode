package code.code;

/**
 * @author duson
 * Employee 表包含所有员工。Employee 表有三列：员工Id，公司名和薪水。
 * <p>
 * +-----+------------+--------+
 * |Id   | Company    | Salary |
 * +-----+------------+--------+
 * |1    | A          | 2341   |
 * |2    | A          | 341    |
 * |3    | A          | 15     |
 * |4    | A          | 15314  |
 * |5    | A          | 451    |
 * |6    | A          | 513    |
 * |7    | B          | 15     |
 * |8    | B          | 13     |
 * |9    | B          | 1154   |
 * |10   | B          | 1345   |
 * |11   | B          | 1221   |
 * |12   | B          | 234    |
 * |13   | C          | 2345   |
 * |14   | C          | 2645   |
 * |15   | C          | 2645   |
 * |16   | C          | 2652   |
 * |17   | C          | 65     |
 * +-----+------------+--------+
 * 请编写SQL查询来查找每个公司的薪水中位数。挑战点：你是否可以在不使用任何内置的SQL函数的情况下解决此问题。
 * <p>
 * +-----+------------+--------+
 * |Id   | Company    | Salary |
 * +-----+------------+--------+
 * |5    | A          | 451    |
 * |6    | A          | 513    |
 * |12   | B          | 234    |
 * |9    | B          | 1154   |
 * |14   | C          | 2645   |
 * +-----+------------+--------+
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-employee-salary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianEmployeeSalary {


    //SELECT A.Id,A.Company,A.Salary
    //FROM
    //(
    //	SELECT
    //	id,
    //	company,
    //	salary,
    //	@trank:=IF(@pre_company=company,@trank+1,0) AS `trank`,
    //	@pre_company:=company
    //	FROM employee,(SELECT @pre_company:= NULL,@trank:=0) AS T
    //	ORDER BY company,salary
    //) AS A
    //JOIN
    //(
    //	SELECT company, FLOOR((COUNT(*)-1)/2) AS `beg`, if(COUNT(*)%2=1,0,1) AS `cnt`
    //	FROM employee
    //	GROUP BY company
    //) AS B
    //ON (A.company=B.company AND A.trank BETWEEN B.beg AND B.beg+B.cnt)
}
