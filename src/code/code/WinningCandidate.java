package code.code;

/**
 * @author duson
 * 表: Candidate
 * <p>
 * +-----+---------+
 * | id  | Name    |
 * +-----+---------+
 * | 1   | A       |
 * | 2   | B       |
 * | 3   | C       |
 * | 4   | D       |
 * | 5   | E       |
 * +-----+---------+
 * 表: Vote
 * <p>
 * +-----+--------------+
 * | id  | CandidateId  |
 * +-----+--------------+
 * | 1   |     2        |
 * | 2   |     4        |
 * | 3   |     3        |
 * | 4   |     2        |
 * | 5   |     5        |
 * +-----+--------------+
 * id 是自动递增的主键，
 * CandidateId 是 Candidate 表中的 id.
 * 请编写 sql 语句来找到当选者的名字，上面的例子将返回当选者 B.
 * <p>
 * +------+
 * | Name |
 * +------+
 * | B    |
 * +------+
 * 注意:
 * <p>
 * 你可以假设没有平局，换言之，最多只有一位当选者。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/winning-candidate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WinningCandidate {

    //select Name
    //from Candidate
    //where id =
    //(select CandidateId
    //from Vote
    //group by CandidateId
    //order by count(*) desc
    //limit 1)

}
