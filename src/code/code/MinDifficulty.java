package code.code;

/**
 * @author duson
 * ����Ҫ�ƶ�һ��?d?��Ĺ����ƻ�������֮�����������Ҫ��ִ�е�?i?�������������ȫ��?j?�����?0 <= j < i����
 * <p>
 * ��ÿ�� ����?��Ҫ���һ�����񡣹����ƻ������Ѷ�����?d?��ÿһ����Ѷ�֮�ͣ���һ��Ĺ����Ѷ��ǵ���Ӧ����ɹ���������Ѷȡ�
 * <p>
 * ����һ����������?jobDifficulty?��һ������?d���ֱ�������ѶȺ���Ҫ�ƻ�����������?i?������Ѷ���?jobDifficulty[i]��
 * <p>
 * �������������ƻ��� ��С�Ѷ� ������޷��ƶ������ƻ����򷵻�?-1?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺jobDifficulty = [6,5,4,3,2,1], d = 2
 * �����7
 * ���ͣ���һ�죬���������ǰ 5 ��������Ѷ� = 6.
 * �ڶ��죬������������һ��������Ѷ� = 1.
 * �ƻ�����Ѷ� = 6 + 1 = 7
 * ʾ�� 2��
 * <p>
 * ���룺jobDifficulty = [9,9,9], d = 4
 * �����-1
 * ���ͣ�������ÿ�����һ�������Ȼ��һ���ǿ��еģ����޷��ƶ�һ���ܹ�����ȶ�����ʱ��ļƻ���
 * ʾ�� 3��
 * <p>
 * ���룺jobDifficulty = [1,1,1], d = 3
 * �����3
 * ���ͣ������ƻ�Ϊÿ��һ��������Ѷ�Ϊ 3 ��
 * ʾ�� 4��
 * <p>
 * ���룺jobDifficulty = [7,1,7,1,7,1], d = 3
 * �����15
 * ʾ�� 5��
 * <p>
 * ���룺jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
 * �����843
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= jobDifficulty.length <= 300
 * 0 <=?jobDifficulty[i] <= 1000
 * 1 <= d <= 10
 * ͨ������1,391�ύ����2,413
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-difficulty-of-a-job-schedule
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinDifficulty {

    public int minDifficulty(int[] job, int d) {
        int n = job.length;
        if (n < d) {
            return -1;
        }
        int[][] dp = new int[d + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = Math.max(dp[1][i - 1], job[i - 1]);
        }
        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int max = job[j - 1];
                for (int k = j - 1; k >= i - 1; k--) {
                    max = Math.max(job[k], max);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + max);
                }
            }
        }
        return dp[d][n];
    }
}
