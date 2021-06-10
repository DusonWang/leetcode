package code.code;

/**
 * ����������������nums1 ��nums2�����ǳ��ȶ�Ϊn��
 * <p>
 * ��������� ���ֵ֮��Ϊ(nums1[0] XOR nums2[0]) + (nums1[1] XOR nums2[1]) + ... + (nums1[n - 1] XOR nums2[n - 1])���±�� 0 ��ʼ����
 * <p>
 * �ȷ�˵��[1,2,3] ��[3,2,1]�� ���ֵ֮�͵���(1 XOR 3) + (2 XOR 2) + (3 XOR 1) = 2 + 0 + 2 = 4��
 * ���㽫nums2�е�Ԫ���������У�ʹ�� ���ֵ֮����С��
 * <p>
 * ���㷵����������֮��� ���ֵ֮�͡�
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums1 = [1,2], nums2 = [2,3]
 * �����2
 * ���ͣ��� nums2 �������еõ� [3,2] ��
 * ���ֵ֮��Ϊ (1 XOR 3) + (2 XOR 2) = 2 + 0 = 2 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums1 = [1,0,3], nums2 = [5,3,4]
 * �����8
 * ���ͣ��� nums2 �������еõ� [5,4,3] ��
 * ���ֵ֮��Ϊ (1 XOR 5) + (0 XOR 4) + (3 XOR 3) = 4 + 4 + 0 = 8 ��
 *
 * <p>
 * ��ʾ��
 * <p>
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 14
 * 0 <= nums1[i], nums2[i] <= 107
 * ͨ������1,481�ύ����3,827
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-xor-sum-of-two-arrays
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinimumXORSum {

    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] f = new int[1 << n];
        for (int mask = 1; mask < (1 << n); mask++) {
            f[mask] = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    f[mask] = Math.min(f[mask], f[mask ^ (1 << i)] + (nums1[Integer.bitCount(mask) - 1] ^ nums2[i]));
                }
            }
        }
        return f[(1 << n) - 1];
    }

}
