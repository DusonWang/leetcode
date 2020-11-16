package code.code;

/**
 * ����һ������Ϊ n �����ӣ�������Ӽ����������ȵ� m �Σ�m��n����������n>1����m>1����ÿ�����ӵĳ��ȼ�Ϊ k[0],k[1]...k[m-1] ������ k[0]*k[1]*...*k[m-1] ���ܵ����˻��Ƕ��٣����磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻���18��
 * <p>
 * ʾ�� 1��
 * <p>
 * ����: 2
 * ���: 1
 * ����: 2 = 1 + 1, 1 �� 1 = 1
 * ʾ��?2:
 * <p>
 * ����: 10
 * ���: 36
 * ����: 10 = 3 + 3 + 4, 3 ��?3 ��?4 = 36
 * ��ʾ��
 * <p>
 * 2 <= n <= 58
 * ע�⣺��������վ 343 ����ͬ��https://leetcode-cn.com/problems/integer-break/
 * <p>
 * ͨ������19,261�ύ����35,543
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
