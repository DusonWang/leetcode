package code.code;

/**
 * @author duson
 * 表 my_numbers 的 num 字段包含很多数字，其中包括很多重复的数字。
 * <p>
 * 你能写一个 SQL 查询语句，找到只出现过一次的数字中，最大的一个数字吗？
 * <p>
 * +---+
 * |num|
 * +---+
 * | 8 |
 * | 8 |
 * | 3 |
 * | 3 |
 * | 1 |
 * | 4 |
 * | 5 |
 * | 6 |
 * 对于上面给出的样例数据，你的查询语句应该返回如下结果：
 * <p>
 * +---+
 * |num|
 * +---+
 * | 6 |
 * 注意：
 * <p>
 * 如果没有只出现一次的数字，输出 null 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biggest-single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BiggestSingleNumber {

    //# Write your MySQL query statement below
    //select max(num) as num
    //from (
    //select num from my_numbers group by num having count(*)=1
    //) as t
}
