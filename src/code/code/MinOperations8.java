package code.code;

import java.util.stream.IntStream;

/**
 * �����������ȿ��ܲ��ȵ���������nums1 ��nums2�����������е�����ֵ����1��6֮�䣨����1��6����
 * <p>
 * ÿ�β����У������ѡ�� ���������е�����һ��������������� 1�� 6֮�� �����ֵ������ 1�� 6����
 * <p>
 * ���㷵��ʹ nums1���������ĺ���nums2���������ĺ���ȵ����ٲ�������������޷�ʹ��������ĺ���ȣ��뷵�� -1��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * �����3
 * ���ͣ������ͨ�� 3 �β���ʹ nums1 ���������ĺ��� nums2 ���������ĺ���ȡ����������±궼�� 0 ��ʼ��
 * - �� nums2[0] ��Ϊ 6 �� nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] ��
 * - �� nums1[5] ��Ϊ 1 �� nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] ��
 * - �� nums1[2] ��Ϊ 2 �� nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] ��
 * ʾ�� 2��
 * <p>
 * ���룺nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * �����-1
 * ���ͣ�û�а취���� nums1 �ĺͻ������� nums2 �ĺ�ʹ������ȡ�
 * ʾ�� 3��
 * <p>
 * ���룺nums1 = [6,6], nums2 = [1]
 * �����3
 * ���ͣ������ͨ�� 3 �β���ʹ nums1 ���������ĺ��� nums2 ���������ĺ���ȡ����������±궼�� 0 ��ʼ��
 * - �� nums1[0] ��Ϊ 2 �� nums1 = [2,6], nums2 = [1] ��
 * - �� nums1[1] ��Ϊ 2 �� nums1 = [2,2], nums2 = [1] ��
 * - �� nums2[0] ��Ϊ 4 �� nums1 = [2,2], nums2 = [4] ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[i] <= 6
 * ͨ������3,823�ύ����8,093
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/equal-sum-arrays-with-minimum-number-of-operations
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinOperations8 {

    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums1.length > 6 * nums2.length) {
            return -1;
        }
        int sum1 = sum(nums1);
        int sum2 = sum(nums2);
        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }
        int diff = sum2 - sum1;
        int[] freq = new int[6];
        for (int num : nums1) {
            ++freq[6 - num];
        }
        for (int num : nums2) {
            ++freq[num - 1];
        }
        int ans = 0;
        for (int i = 5; i > 0 && diff > 0; --i) {
            while (freq[i] > 0 && diff > 0) {
                ++ans;
                --freq[i];
                diff -= i;
            }
        }
        return diff > 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        MinOperations8 minOperations8 = new MinOperations8();
        System.out.println(minOperations8.minOperations(new int[]{1, 1, 2, 2, 2, 2}, new int[]{1, 2, 3, 4, 5, 6}));
    }
}
