package code.code;

/**
 * �������� n ��Ա�������ǿ�����ɸ��ָ����Ĺ�����������
 * <p>
 * ��?i?�ֹ��������?profit[i]?��������Ҫ��?group[i]?����Ա��ͬ���롣�����Ա����������һ������Ͳ��ܲ�����һ�����
 * <p>
 * �������κ����ٲ���?minProfit ������Ӽ���Ϊӯ���ƻ������ҹ����ĳ�Ա�������Ϊ n ��
 * <p>
 * �ж����ּƻ�����ѡ����Ϊ�𰸺ܴ����� ���ؽ��ģ?10^9 + 7?��ֵ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * �����2
 * ���ͣ����ٲ��� 3 �����󣬸ü��ſ�����ɹ��� 0 �͹��� 1 �������ɹ��� 1 ��
 * �ܵ���˵�������ּƻ���
 * ʾ�� 2��
 * <p>
 * ���룺n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * �����7
 * ���ͣ����ٲ��� 5 ������ֻҪ�������һ�ֹ������У����Ըü��ſ�������κι�����
 * �� 7 �ֿ��ܵļƻ���(0)��(1)��(2)��(0,1)��(0,2)��(1,2)���Լ� (0,1,2) ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 100
 * 0 <= minProfit <= 100
 * 1 <= group.length <= 100
 * 1 <= group[i] <= 100
 * profit.length == group.length
 * 0 <= profit[i] <= 100
 * ͨ������3,068�ύ����7,755
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/profitable-schemes
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ProfitableSchemes {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_000 + 7;
        int N = group.length;
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            int g = group[i];
            int p = profit[i];
            for (int j = n; j >= g; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] += dp[j - g][Math.max(k - p, 0)];
                    dp[j][k] %= MOD;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += dp[i][minProfit];
            sum %= MOD;
        }
        return sum;
    }
}
