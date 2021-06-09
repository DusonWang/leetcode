package code.code;

import java.util.PriorityQueue;

/**
 * һ��ѧУ����һЩ�༶��ÿ���༶����һЩѧ��������ÿ���඼�����һ����ĩ���ԡ�����һ����ά���� classes������classes[i] = [passi, totali]����ʾ����ǰ֪���˵�i���༶�ܹ���totali��ѧ��������ֻ��passi��ѧ������ͨ�����ԡ�
 * <p>
 * ����һ������extraStudents����ʾ������extraStudents��������ѧ�������� һ����ͨ���κΰ༶����ĩ��������Ҫ����extraStudents��ѧ��ÿ�˶�����һ���༶��ʹ�� ���а༶�� ƽ��ͨ���� ���
 * <p>
 * һ���༶��ͨ���ʵ�������༶ͨ�����Ե�ѧ��������������༶����������ƽ��ͨ���������а༶��ͨ����֮�ͳ��԰༶��Ŀ��
 * <p>
 * ���㷵���ڰ����� extraStudents ��ѧ��ȥ��Ӧ�༶��� ���ƽ��ͨ���ʡ����׼����Χ��10-5���ڵĽ��������Ϊ��ȷ�����
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * �����0.78333
 * ���ͣ�����Խ����������ѧ�������ŵ���һ���༶��ƽ��ͨ����Ϊ (3/4 + 3/5 + 2/2) / 3 = 0.78333 ��
 * ʾ�� 2��
 * <p>
 * ���룺classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
 * �����0.53485
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= classes.length <= 105
 * classes[i].length == 2
 * 1 <= passi <= totali <= 105
 * 1 <= extraStudents <= 105
 * ͨ������6,003�ύ����11,635
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-average-pass-ratio
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
