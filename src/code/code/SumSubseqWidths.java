package code.code;

import java.util.Arrays;

/**
 * @author duson
 * ����һ���������� A ������ A �����зǿ������С�
 * <p>
 * ������������ S ���� S �Ŀ���� S �����Ԫ�غ���СԪ�صĲ
 * <p>
 * ���� A �����������еĿ��֮�͡�
 * <p>
 * ���ڴ𰸿��ܷǳ����뷵�ش�ģ 10^9+7��
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺[2,1,3]
 * �����6
 * ���ͣ�
 * ������Ϊ [1]��[2]��[3]��[2,1]��[2,3]��[1,3]��[2,1,3] ��
 * ��Ӧ�Ŀ���� 0��0��0��1��1��2��2 ��
 * ��Щ���֮���� 6 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 20000
 * ͨ������1,382�ύ����4,825
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sum-of-subsequence-widths
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SumSubseqWidths {

    public int sumSubseqWidths(int[] a) {
        Arrays.sort(a);
        long c = 1, res = 0, mod = (long) 1e9 + 7;
        for (int i = 0, n = a.length; i < n; ++i, c = c * 2 % mod) {
            res = (res + a[i] * c - a[n - i - 1] * c) % mod;
        }
        return (int) ((res + mod) % mod);
    }
}
