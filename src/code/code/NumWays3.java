package code.code;

/**
 * ��һ������Ϊ?arrLen?�����飬��ʼ��һ��ָ��������?0 ����
 * <p>
 * ÿһ�������У�����Խ�ָ������������ƶ� 1 ��������ͣ��ԭ�أ�ָ�벻�ܱ��ƶ������鷶Χ�⣩��
 * <p>
 * ������������?steps ��?arrLen ��������㲢���أ���ǡ��ִ��?steps?�β����Ժ�ָ����Ȼָ������?0 ���ķ�������
 * <p>
 * ���ڴ𰸿��ܻ�ܴ��뷵�ط����� ģ?10^9 + 7 ��Ľ����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺steps = 3, arrLen = 2
 * �����4
 * ���ͣ�3 �����ܹ��� 4 �ֲ�ͬ�ķ�������ͣ������ 0 ����
 * ���ң����󣬲���
 * ���������ң�����
 * ���ң�����������
 * ����������������
 * ʾ��? 2��
 * <p>
 * ���룺steps = 2, arrLen = 4
 * �����2
 * ���ͣ�2 �����ܹ��� 2 �ֲ�ͬ�ķ�������ͣ������ 0 ����
 * ���ң�����
 * ����������
 * ʾ�� 3��
 * <p>
 * ���룺steps = 4, arrLen = 2
 * �����8
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= steps <= 500
 * 1 <= arrLen?<= 10^6
 * ͨ������20,559�ύ����42,361
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumWays3 {

    public int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int maxColumn = Math.min(arrLen - 1, steps);
        int[] dp = new int[maxColumn + 1];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] dpNext = new int[maxColumn + 1];
            for (int j = 0; j <= maxColumn; j++) {
                dpNext[j] = dp[j];
                if (j - 1 >= 0) {
                    dpNext[j] = (dpNext[j] + dp[j - 1]) % MODULO;
                }
                if (j + 1 <= maxColumn) {
                    dpNext[j] = (dpNext[j] + dp[j + 1]) % MODULO;
                }
            }
            dp = dpNext;
        }
        return dp[0];
    }
}
