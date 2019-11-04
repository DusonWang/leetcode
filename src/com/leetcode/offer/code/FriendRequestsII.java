package com.leetcode.offer.code;

/**
 * @author duson
 * 在 Facebook 或者 Twitter 这样的社交应用中，人们经常会发好友申请也会收到其他人的好友申请。
 * <p>
 *  
 * <p>
 * 表 request_accepted 存储了所有好友申请通过的数据记录，其中， requester_id 和 accepter_id 都是用户的编号。
 * <p>
 *  
 * <p>
 * | requester_id | accepter_id | accept_date|
 * |--------------|-------------|------------|
 * | 1            | 2           | 2016_06-03 |
 * | 1            | 3           | 2016-06-08 |
 * | 2            | 3           | 2016-06-08 |
 * | 3            | 4           | 2016-06-09 |
 * 写一个查询语句，求出谁拥有最多的好友和他拥有的好友数目。对于上面的样例数据，结果为：
 * <p>
 * | id | num |
 * |----|-----|
 * | 3  | 3   |
 * 注意：
 * <p>
 * 保证拥有最多好友数目的只有 1 个人。
 * 好友申请只会被接受一次，所以不会有 requester_id 和 accepter_id 值都相同的重复记录。
 *  
 * <p>
 * 解释：
 * <p>
 * 编号为 '3' 的人是编号为 '1'，'2' 和 '4' 的好友，所以他总共有 3 个好友，比其他人都多。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 在真实世界里，可能会有多个人拥有好友数相同且最多，你能找到所有这些人吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friend-requests-ii-who-has-the-most-friends
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FriendRequestsII {

    //# Write your MySQL query statement below
    //select m.ids as id,m.cnt as 'num'
    //from (
    //(select ids,count(*) as cnt from
    //((select requester_id as ids from request_accepted)
    //union all
    //(select accepter_id as ids from request_accepted)) as t
    //group by t.ids)) as m
    //order by m.cnt desc
    //limit 1;
}
