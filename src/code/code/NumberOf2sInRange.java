package code.code;

/**
 * ��дһ������������� 0 �� n (�� n) ������ 2 ���ֵĴ�����
 * <p>
 * ʾ��:
 * <p>
 * ����: 25
 * ���: 9
 * ����: (2, 12, 20, 21, 22, 23, 24, 25)(ע�� 22 Ӧ����������)
 * ��ʾ��
 * <p>
 * n <= 10^9
 * ͨ������1,013�ύ����2,512
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-2s-in-range-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumberOf2sInRange {

    public int numberOf2sInRange(int n) {
        int ans = 0;
        for (int mask = 1; mask <= n; mask *= 10) {
            int leftMid = n / mask;
            int right = n % mask;
            int left = (leftMid + 7) / 10;
            ans += left * mask;
            if (leftMid % 10 == 2) {
                ans += right + 1;
            }
        }
        return ans;
    }
}
