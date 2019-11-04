package com.leetcode.offer.code;

/**
 * @author duson
 * 小美是一所中学的信息科技老师，她有一张 seat 座位表，平时用来储存学生名字和与他们相对应的座位 id。
 * <p>
 * 其中纵列的 id 是连续递增的
 * <p>
 * 小美想改变相邻俩学生的座位。
 * <p>
 * 你能不能帮她写一个 SQL query 来输出小美想要的结果呢？
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * +---------+---------+
 * |    id   | student |
 * +---------+---------+
 * |    1    | Abbot   |
 * |    2    | Doris   |
 * |    3    | Emerson |
 * |    4    | Green   |
 * |    5    | Jeames  |
 * +---------+---------+
 * 假如数据输入的是上表，则输出结果如下：
 * <p>
 * +---------+---------+
 * |    id   | student |
 * +---------+---------+
 * |    1    | Doris   |
 * |    2    | Abbot   |
 * |    3    | Green   |
 * |    4    | Emerson |
 * |    5    | Jeames  |
 * +---------+---------+
 * 注意：
 * <p>
 * 如果学生人数是奇数，则不需要改变最后一个同学的座位。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/exchange-seats
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ExchangeSeats {


//    # Write your MySQL query statement below
//    select (case
//            when id%2=0 then id-1
//            when id =(select max(id) from seat) then id
//            else id+1
//    end)
//    as id,student
//    from seat
//    order by id;
}
