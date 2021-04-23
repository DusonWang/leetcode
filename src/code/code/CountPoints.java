package code.code;

/**
 * ����һ������?points?������?points[i] = [xi, yi]?����ʾ��?i?�����ڶ�άƽ���ϵ����ꡣ�������ܻ��� ��ͬ?�����ꡣ
 * <p>
 * ͬʱ����һ������?queries?������?queries[j] = [xj, yj, rj]?����ʾһ��Բ����?(xj, yj)?�Ұ뾶Ϊ?rj?��Բ��
 * <p>
 * ����ÿһ����ѯ?queries[j]?�������ڵ� j?��Բ ��?�����Ŀ�����һ������Բ�� �߽���?������ͬ����Ϊ����Բ?��?��
 * <p>
 * ���㷵��һ������?answer?������?answer[j]�ǵ�?j?����ѯ�Ĵ𰸡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
 * �����[3,2,2]
 * ���ͣ����еĵ��Բ����ͼ��ʾ��
 * queries[0] ����ɫ��Բ��queries[1] �Ǻ�ɫ��Բ��queries[2] ����ɫ��Բ��
 * ʾ�� 2��
 * <p>
 * <p>
 * ���룺points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
 * �����[2,3,2,4]
 * ���ͣ����еĵ��Բ����ͼ��ʾ��
 * queries[0] ����ɫ��Բ��queries[1] �Ǻ�ɫ��Բ��queries[2] ����ɫ��Բ��queries[3] ����ɫ��Բ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= points.length <= 500
 * points[i].length == 2
 * 0 <= x??????i, y??????i <= 500
 * 1 <= queries.length <= 500
 * queries[j].length == 3
 * 0 <= xj, yj <= 500
 * 1 <= rj <= 500
 * ���е����궼��������
 * ͨ������3,677�ύ����4,145
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountPoints {

    public int[] countPoints(int[][] points, int[][] queries) {
        int n2 = queries.length;
        int[] res = new int[n2];
        for (int i = 0; i < n2; i++) {
            for (int[] point : points) {
                if (isInCircle(queries[i][2], queries[i][0], queries[i][1], point[0], point[1])) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    private boolean isInCircle(double r, double x1, double y1, double x2, double y2) {
        double dist = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        return dist <= r;
    }
}
