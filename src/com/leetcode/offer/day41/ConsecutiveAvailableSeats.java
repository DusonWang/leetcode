package com.leetcode.offer.day41;

/**
 * @author duson
 * 几个朋友来到电影院的售票处，准备预约连续空余座位。
 * <p>
 * 你能利用表 cinema ，帮他们写一个查询语句，获取所有空余座位，并将它们按照 seat_id 排序后返回吗？
 * <p>
 * | seat_id | free |
 * |---------|------|
 * | 1       | 1    |
 * | 2       | 0    |
 * | 3       | 1    |
 * | 4       | 1    |
 * | 5       | 1    |
 *  
 * <p>
 * 对于如上样例，你的查询语句应该返回如下结果。
 * <p>
 *  
 * <p>
 * | seat_id |
 * |---------|
 * | 3       |
 * | 4       |
 * | 5       |
 * 注意：
 * <p>
 * seat_id 字段是一个自增的整数，free 字段是布尔类型（'1' 表示空余， '0' 表示已被占据）。
 * 连续空余座位的定义是大于等于 2 个连续空余的座位。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/consecutive-available-seats
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConsecutiveAvailableSeats {

    //# Write your MySQL query statement below
    //select distinct(b.seat_id)
    //from cinema as b
    //join cinema as c
    //on b.seat_id = c.seat_id+1 or b.seat_id=c.seat_id-1
    //where b.free=1 and c.free=1
    //order by b.seat_id;
}
