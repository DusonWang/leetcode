package code.code;

/**
 * @author duson
 * 朋友关系列表：?Friendship
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user1_id      | int     |
 * | user2_id      | int     |
 * +---------------+---------+
 * 这张表的主键是 (user1_id, user2_id)。
 * 这张表的每一行代表着 user1_id 和 user2_id 之间存在着朋友关系。
 * ?
 * <p>
 * 喜欢列表：?Likes
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | user_id     | int     |
 * | page_id     | int     |
 * +-------------+---------+
 * 这张表的主键是 (user_id, page_id)。
 * 这张表的每一行代表着 user_id 喜欢 page_id。
 * ?
 * <p>
 * 写一段 SQL ?向user_id = 1 的用户，推荐其朋友们喜欢的页面。不要推荐该用户已经喜欢的页面。
 * <p>
 * 你返回的结果中不应当包含重复项。
 * <p>
 * 返回结果的格式如下例所示：
 * <p>
 * Friendship table:
 * +----------+----------+
 * | user1_id | user2_id |
 * +----------+----------+
 * | 1        | 2        |
 * | 1        | 3        |
 * | 1        | 4        |
 * | 2        | 3        |
 * | 2        | 4        |
 * | 2        | 5        |
 * | 6        | 1        |
 * +----------+----------+
 * <p>
 * Likes table:
 * +---------+---------+
 * | user_id | page_id |
 * +---------+---------+
 * | 1       | 88      |
 * | 2       | 23      |
 * | 3       | 24      |
 * | 4       | 56      |
 * | 5       | 11      |
 * | 6       | 33      |
 * | 2       | 77      |
 * | 3       | 77      |
 * | 6       | 88      |
 * +---------+---------+
 * <p>
 * Result table:
 * +------------------+
 * | recommended_page |
 * +------------------+
 * | 23               |
 * | 24               |
 * | 56               |
 * | 33               |
 * | 77               |
 * +------------------+
 * 用户1 同 用户2, 3, 4, 6 是朋友关系。
 * 推荐页面为： 页面23 来自于 用户2, 页面24 来自于 用户3, 页面56 来自于 用户3 以及 页面33 来自于 用户6。
 * 页面77 同时被 用户2 和 用户3 推荐。
 * 页面88 没有被推荐，因为 用户1 已经喜欢了它。
 * 通过次数921提交次数1,555
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/page-recommendations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RecommendedPage {

    //select distinct page_id as recommended_page
    //from Likes
    //where user_id in
    //(
    //    select distinct user2_id id from Friendship where user1_id=1
    //    union
    //    select distinct user1_id id from Friendship where user2_id=1
    //)
    //and page_id not in
    //(select page_id from Likes where user_id=1)
}
