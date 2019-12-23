package com.leetcode.offer.code;

/**
 * @author duson
 * 要求写一段 SQL 语句，查询出每个学生参加每一门科目测试的次数，结果按 student_id 和 subject_name 排序。
 * <p>
 * 查询结构格式如下所示：
 * <p>
 * Students table:
 * +------------+--------------+
 * | student_id | student_name |
 * +------------+--------------+
 * | 1          | Alice        |
 * | 2          | Bob          |
 * | 13         | John         |
 * | 6          | Alex         |
 * +------------+--------------+
 * Subjects table:
 * +--------------+
 * | subject_name |
 * +--------------+
 * | Math         |
 * | Physics      |
 * | Programming  |
 * +--------------+
 * Examinations table:
 * +------------+--------------+
 * | student_id | subject_name |
 * +------------+--------------+
 * | 1          | Math         |
 * | 1          | Physics      |
 * | 1          | Programming  |
 * | 2          | Programming  |
 * | 1          | Physics      |
 * | 1          | Math         |
 * | 13         | Math         |
 * | 13         | Programming  |
 * | 13         | Physics      |
 * | 2          | Math         |
 * | 1          | Math         |
 * +------------+--------------+
 * Result table:
 * +------------+--------------+--------------+----------------+
 * | student_id | student_name | subject_name | attended_exams |
 * +------------+--------------+--------------+----------------+
 * | 1          | Alice        | Math         | 3              |
 * | 1          | Alice        | Physics      | 2              |
 * | 1          | Alice        | Programming  | 1              |
 * | 2          | Bob          | Math         | 1              |
 * | 2          | Bob          | Physics      | 0              |
 * | 2          | Bob          | Programming  | 1              |
 * | 6          | Alex         | Math         | 0              |
 * | 6          | Alex         | Physics      | 0              |
 * | 6          | Alex         | Programming  | 0              |
 * | 13         | John         | Math         | 1              |
 * | 13         | John         | Physics      | 1              |
 * | 13         | John         | Programming  | 1              |
 * +------------+--------------+--------------+----------------+
 * 结果表需包含所有学生和所有科目（即便测试次数为0）：
 * Alice 参加了 3 次数学测试, 2 次物理测试，以及 1 次编程测试；
 * Bob 参加了 1 次数学测试, 1 次编程测试，没有参加物理测试；
 * Alex 啥测试都没参加；
 * John  参加了数学、物理、编程测试各 1 次。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/students-and-examinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StudentsAndExaminations {

    //	select s.student_id,s.student_name,sj.subject_name,count(e.student_id) as attended_exams
    //    from students as s
    //    join subjects as sj
    //    on 1=1
    //    left join Examinations as e
    //    on (s.student_id,sj.subject_name)=(e.student_id,e.subject_name)
    //    group by s.student_id,s.student_name,sj.subject_name
    //    order By s.student_id,sj.subject_name

}
