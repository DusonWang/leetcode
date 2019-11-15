package com.leetcode.offer.code;

/**
 * @author duson
 * 表 Submissions 结构如下：
 * <p>
 * +---------------+----------+
 * | 列名           | 类型     |
 * +---------------+----------+
 * | sub_id        | int      |
 * | parent_id     | int      |
 * +---------------+----------+
 * 上表没有主键, 所以可能会出现重复的行。
 * 每行可以是一个帖子或对该帖子的评论。
 * 如果是帖子的话，parent_id 就是 null。
 * 对于评论来说，parent_id 就是表中对应帖子的 sub_id。
 *  
 * <p>
 * 编写 SQL 语句以查找每个帖子的评论数。
 * <p>
 * 结果表应包含帖子的 post_id 和对应的评论数 number_of_comments 并且按 post_id 升序排列。
 * <p>
 * Submissions 可能包含重复的评论。您应该计算每个帖子的唯一评论数。
 * <p>
 * Submissions 可能包含重复的帖子。您应该将它们视为一个帖子。
 * <p>
 * 查询结果格式如下例所示：
 * <p>
 * Submissions table:
 * +---------+------------+
 * | sub_id  | parent_id  |
 * +---------+------------+
 * | 1       | Null       |
 * | 2       | Null       |
 * | 1       | Null       |
 * | 12      | Null       |
 * | 3       | 1          |
 * | 5       | 2          |
 * | 3       | 1          |
 * | 4       | 1          |
 * | 9       | 1          |
 * | 10      | 2          |
 * | 6       | 7          |
 * +---------+------------+
 * <p>
 * 结果表：
 * +---------+--------------------+
 * | post_id | number_of_comments |
 * +---------+--------------------+
 * | 1       | 3                  |
 * | 2       | 2                  |
 * | 12      | 0                  |
 * +---------+--------------------+
 * <p>
 * 表中 ID 为 1 的帖子有 ID 为 3、4 和 9 的三个评论。表中 ID 为 3 的评论重复出现了，所以我们只对它进行了一次计数。
 * 表中 ID 为 2 的帖子有 ID 为 5 和 10 的两个评论。
 * ID 为 12 的帖子在表中没有评论。
 * 表中 ID 为 6 的评论是对 ID 为 7 的已删除帖子的评论，因此我们将其忽略。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-comments-per-post
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfCommentsPerPost {

    //# Write your MySQL query statement below
    //select s1.sub_id as post_id,count(distinct s2.sub_id) as number_of_comments
    //from Submissions as s1
    //left join Submissions as s2
    //on s2.parent_id=s1.sub_id
    //where s1.parent_id is null
    //group by s1.sub_id

}
