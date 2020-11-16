package code.code;

import java.util.Arrays;

/**
 * @author duson
 * ����һ���������� nums������ѡ�������������ͬ�±� i �� j��ʹ (nums[i]-1)*(nums[j]-1) ȡ�����ֵ��
 * <p>
 * ������㲢���ظ�ʽ�����ֵ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [3,4,5,2]
 * �����12
 * ���ͣ����ѡ���±� i=1 �� j=2���±�� 0 ��ʼ��������Ի�����ֵ��(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,5,4,5]
 * �����16
 * ���ͣ�ѡ���±� i=1 �� j=3���±�� 0 ��ʼ��������Ի�����ֵ (5-1)*(5-1) = 16 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [3,7]
 * �����12
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 * ͨ������3,617�ύ����4,353
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxProduct2 {

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max((nums[0] - 1) * (nums[1] - 1), (nums[len - 1] - 1) * (nums[len - 2] - 1));
    }
}
