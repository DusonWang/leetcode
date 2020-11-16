package code.code;

/**
 * @author duson
 * 有一个courses 表 ，有: student (学生) 和 class (课程)。
 * <p>
 * 请列出所有超过或等于5名学生的课。
 * <p>
 * 例如,表:
 * <p>
 * +---------+------------+
 * | student | class      |
 * +---------+------------+
 * | A       | Math       |
 * | B       | English    |
 * | C       | Math       |
 * | D       | Biology    |
 * | E       | Math       |
 * | F       | Computer   |
 * | G       | Math       |
 * | H       | Math       |
 * | I       | Math       |
 * +---------+------------+
 * 应该输出:
 * <p>
 * +---------+
 * | class   |
 * +---------+
 * | Math    |
 * +---------+
 * Note:
 * 学生在每个课中不应被重复计算。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/classes-more-than-5-students
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClassesMoreThan5Students {

    //select class from courses group by class having count(distinct student)>=5;

}
