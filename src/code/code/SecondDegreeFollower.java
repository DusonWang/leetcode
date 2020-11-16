package code.code;

/**
 * @author duson
 * 在 facebook 中，表 follow 会有 2 个字段： followee, follower ，分别表示被关注者和关注者。
 * <p>
 * 请写一个 sql 查询语句，对每一个关注者，查询他的关注者数目。
 * <p>
 * 比方说：
 * <p>
 * +-------------+------------+
 * | followee    | follower   |
 * +-------------+------------+
 * |     A       |     B      |
 * |     B       |     C      |
 * |     B       |     D      |
 * |     D       |     E      |
 * +-------------+------------+
 * 应该输出：
 * <p>
 * +-------------+------------+
 * | follower    | num        |
 * +-------------+------------+
 * |     B       |  2         |
 * |     D       |  1         |
 * +-------------+------------+
 * 解释：
 * <p>
 * B 和 D 都在在 follower 字段中出现，作为被关注者，B 被 C 和 D 关注，D 被 E 关注。A 不在 follower 字段内，所以A不在输出列表中。
 * <p>
 *  
 * <p>
 * 注意：
 * 被关注者永远不会被他 / 她自己关注。
 * 将结果按照字典序返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-degree-follower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SecondDegreeFollower {

    //# Write your MySQL query statement below
    //select f1.follower, count(distinct f2.follower) as num
    //from follow as f1
    //join follow as f2
    //on f1.follower = f2.followee
    //group by f1.follower
    //order by f1.follower;

}
