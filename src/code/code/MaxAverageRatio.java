package code.code;

import java.util.PriorityQueue;

/**
 * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes，其中classes[i] = [passi, totali]，表示你提前知道了第i个班级总共有totali个学生，其中只有passi个学生可以通过考试。
 * <p>
 * 给你一个整数extraStudents，表示额外有extraStudents个聪明的学生，他们 一定能通过任何班级的期末考。你需要给这extraStudents个学生每人都安排一个班级，使得 所有班级的 平均通过率 最大。
 * <p>
 * 一个班级的通过率等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率是所有班级的通过率之和除以班级数目。
 * <p>
 * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大平均通过率。与标准答案误差范围在10-5以内的结果都会视为正确结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * 输出：0.78333
 * 解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
 * 示例 2：
 * <p>
 * 输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
 * 输出：0.53485
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= classes.length <= 105
 * classes[i].length == 2
 * 1 <= passi <= totali <= 105
 * 1 <= extraStudents <= 105
 * 通过次数6,003提交次数11,635
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-pass-ratio
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAverageRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> queue = new PriorityQueue<>((o1, o2) -> {
            double x = ((o2[0] + 1) / (o2[1] + 1) - o2[0] / o2[1]);
            double y = ((o1[0] + 1) / (o1[1] + 1) - o1[0] / o1[1]);
            return Double.compare(x, y);
        });
        for (int[] c : classes) {
            queue.offer(new double[]{c[0], c[1]});
        }
        while (extraStudents > 0) {
            double[] max = queue.poll();
            max[0] += 1.0;
            max[1] += 1.0;
            queue.offer(max);
            extraStudents--;
        }
        double res = 0;
        while (!queue.isEmpty()) {
            double[] c = queue.poll();
            res += (c[0] / c[1]);
        }
        return res / n;
    }

}
