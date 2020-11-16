package code.code;

/**
 * @author duson
 * 一个小学生 Tim 的作业是判断三条线段是否能形成一个三角形。
 * <p>
 *  
 * <p>
 * 然而，这个作业非常繁重，因为有几百组线段需要判断。
 * <p>
 *  
 * <p>
 * 假设表 table 保存了所有三条线段的三元组 x, y, z ，你能帮 Tim 写一个查询语句，来判断每个三元组是否可以组成一个三角形吗？
 * <p>
 *  
 * <p>
 * | x  | y  | z  |
 * |----|----|----|
 * | 13 | 15 | 30 |
 * | 10 | 20 | 15 |
 * 对于如上样例数据，你的查询语句应该返回如下结果：
 * <p>
 * | x  | y  | z  | triangle |
 * |----|----|----|----------|
 * | 13 | 15 | 30 | No       |
 * | 10 | 20 | 15 | Yes      |
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle-judgement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TriangleJudgement {

    //select *,
    //if((x + y <= z or x + z <= y or y + z <= x), "No", "Yes") as triangle
    //from triangle;

}
