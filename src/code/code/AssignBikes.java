package code.code;

import java.util.Arrays;

/**
 * @author duson
 * ���� 2D �����ʾ��У԰����?n?λ���ˣ�worker���� m?�����г���bike����n <= m�����й��˺����г���λ�ö��������ϵ� 2D �����ʾ��
 * <p>
 * ����Ϊÿһλ���˷���һ��ר�����г���ʹÿ������������䵽�����г�֮��������پ�����С����
 * <p>
 * p1 ��?p2?֮��������پ���Ϊ?Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|��
 * <p>
 * ����ÿ����������䵽�����г�֮��������پ������С�����ܺ͡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * �����6
 * ���ͣ�
 * ���г� 0 ��������� 0�����г� 1 ��������� 1 ������õ��������پ��붼�� 3, �������Ϊ 6 ��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * �����4
 * ���ͣ�
 * �Ƚ����г� 0 ��������� 0���ٽ����г� 1 ��������� 1������ 2�������г� 2 ������ 2������ 1������˷���ʹ�������پ�����ܺ�Ϊ 4��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000
 * ���й��˺����г���λ�ö�����ͬ��
 * 1 <= workers.length <= bikes.length <= 10
 * ͨ������814�ύ����2,048
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/campus-bikes-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class AssignBikes {

    public int assignBikes(int[][] workers, int[][] bikes) {
        int wLen = workers.length;
        int bLen = bikes.length;
        int[][] dp = new int[wLen][1 << bLen];
        for (int idx = 0; idx < wLen; ++idx) {
            Arrays.fill(dp[idx], -1);
        }
        return dfs(0, 0, workers, bikes, dp);
    }

    private int dfs(int wIdx, int bIdx, int[][] workers, int[][] bikes, int[][] dp) {
        if (wIdx >= workers.length) {
            return 0;
        }
        if (dp[wIdx][bIdx] != -1) {
            return dp[wIdx][bIdx];
        }
        int min = 1 << 30;
        for (int idx = 0; idx < bikes.length; ++idx) {
            if ((bIdx >> idx & 1) == 1) {
                continue;
            }
            int dist = Math.abs(workers[wIdx][0] - bikes[idx][0]) + Math.abs(workers[wIdx][1] - bikes[idx][1]);
            int next = bIdx | 1 << idx;
            min = Math.min(min, dist + dfs(wIdx + 1, next, workers, bikes, dp));
        }
        dp[wIdx][bIdx] = min;
        return min;
    }
}
