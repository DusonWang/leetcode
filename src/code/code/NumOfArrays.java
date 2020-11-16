package code.code;

/**
 * @author duson
 * ������������ n��m �� k ����ͼ�������㷨�����ҳ�����������������Ԫ�ء�
 * <p>
 * <p>
 * <p>
 * ��������һ�������������Ե����� arr ��
 * <p>
 * arr ���� n ��������
 * 1 <= arr[i] <= m ���� (0 <= i < n) ��
 * �������ᵽ���㷨Ӧ���� arr ��search_cost ��ֵ���� k ��
 * ���������������������� arr �� ������ �����ڴ𰸿��ܻ�ܴ����� ���� �� 10^9 + 7 ȡ�ࡣ
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 2, m = 3, k = 1
 * �����6
 * ���ͣ����ܵ�����ֱ�Ϊ [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
 * ʾ�� 2��
 * <p>
 * ���룺n = 5, m = 2, k = 3
 * �����0
 * ���ͣ�û���������������������
 * ʾ�� 3��
 * <p>
 * ���룺n = 9, m = 1, k = 1
 * �����1
 * ���ͣ����ܵ�����ֻ�� [1, 1, 1, 1, 1, 1, 1, 1, 1]
 * ʾ�� 4��
 * <p>
 * ���룺n = 50, m = 100, k = 25
 * �����34549172
 * ���ͣ���Ҫ���˶� 1000000007 ȡ��
 * ʾ�� 5��
 * <p>
 * ���룺n = 37, m = 17, k = 7
 * �����418930126
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 50
 * 1 <= m <= 100
 * 0 <= k <= n
 * ͨ������1,380�ύ����2,428
 * ����ʵ������������������⣿
 * <p>
 * <p>
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumOfArrays {

    public int numOfArrays(int n, int m, int k) {
        if (k == 0 || m < k) {
            return 0;
        }
        int mod = 1000_000_007;
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i][1][1] = 1;
        }
        for (int j = 1; j <= m; ++j) {
            dp[1][j][1] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int p = 1; p <= k; ++p) {
                int sum = 0;
                for (int j = 2; j <= m; ++j) {
                    sum = (sum + dp[i - 1][j - 1][p - 1]) % mod;
                    int temp = (int) (((long) dp[i - 1][j][p] * j) % mod);
                    dp[i][j][p] = (sum + temp) % mod;
                }
            }
        }
        int result = 0;
        for (int j = 1; j <= m; ++j) {
            result = (result + dp[n][j][k]) % mod;
        }
        return result % mod;
    }
}
