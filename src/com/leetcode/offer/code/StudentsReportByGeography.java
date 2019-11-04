package com.leetcode.offer.code;

/**
 * @author duson
 * 一所美国大学有来自亚洲、欧洲和美洲的学生，他们的地理信息存放在如下 student 表中。
 * <p>
 *  
 * <p>
 * | name   | continent |
 * |--------|-----------|
 * | Jack   | America   |
 * | Pascal | Europe    |
 * | Xi     | Asia      |
 * | Jane   | America   |
 *  
 * <p>
 * 写一个查询语句实现对大洲（continent）列的 透视表 操作，使得每个学生按照姓名的字母顺序依次排列在对应的大洲下面。输出的标题应依次为美洲（America）、亚洲（Asia）和欧洲（Europe）。数据保证来自美洲的学生不少于来自亚洲或者欧洲的学生。
 * <p>
 *  
 * <p>
 * 对于样例输入，它的对应输出是：
 * <p>
 *  
 * <p>
 * | America | Asia | Europe |
 * |---------|------|--------|
 * | Jack    | Xi   | Pascal |
 * | Jane    |      |        |
 *  
 * <p>
 * 进阶：如果不能确定哪个大洲的学生数最多，你可以写出一个查询去生成上述学生报告吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/students-report-by-geography
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StudentsReportByGeography {

    //select c1.name America,c2.name Asia,c3.name Europe
    //from
    //(select name, @rank1:=@rank1+1 cnt1 from student,(select @rank1:=0) temp where continent='America' order by name) c1 left join
    //(select name, @rank2:=@rank2+1 cnt2 from student,(select @rank2:=0) temp where continent='Asia' order by name) c2
    //on c1.cnt1=c2.cnt2
    //left join
    //(select name, @rank3:=@rank3+1 cnt3 from student,(select @rank3:=0) temp where continent='Europe' order by name) c3
    //on
    //c1.cnt1=c3.cnt3
}
