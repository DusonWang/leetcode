package code.code;

/**
 * ����һ���������� nums?����������˻�Ϊ�������������ĳ��ȡ�
 * <p>
 * һ�����������������ԭ������������߸��������������ɵ����顣
 * <p>
 * ���㷵�س˻�Ϊ������������鳤�ȡ�
 * <p>
 * ?
 * <p>
 * ʾ��? 1��
 * <p>
 * ���룺nums = [1,-2,-3,4]
 * �����4
 * ���ͣ����鱾��˻�����������ֵΪ 24 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [0,1,-2,-3,-4]
 * �����3
 * ���ͣ���˻�Ϊ������������Ϊ [1,-2,-3] ���˻�Ϊ 6 ��
 * ע�⣬���ǲ��ܰ� 0 Ҳ�������������У���Ϊ�����˻�Ϊ 0 ������������
 * ʾ�� 3��
 * <p>
 * ���룺nums = [-1,-2,-3,0,1]
 * �����2
 * ���ͣ��˻�Ϊ��������������� [-1,-2] ���� [-2,-3] ��
 * ʾ�� 4��
 * <p>
 * ���룺nums = [-1,2]
 * �����1
 * ʾ�� 5��
 * <p>
 * ���룺nums = [1,2,3,5,-6,4,0,10]
 * �����4
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i]?<= 10^9
 * ͨ������5,383�ύ����15,669
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetMaxLen {

    public int getMaxLen(int[] nums) {
        int positiveLength = 0;
        int negativeLength = 0;
        int maxPositive = 0;
        for (int num : nums) {
            if (num < 0) {
                int temp = positiveLength;
                positiveLength = negativeLength;
                negativeLength = temp;
                negativeLength++;
                if (positiveLength > 0) {
                    positiveLength++;
                }
            } else if (num == 0) {
                positiveLength = 0;
                negativeLength = 0;
            } else {
                positiveLength++;
                if (negativeLength > 0) {
                    negativeLength++;
                }
            }
            maxPositive = Math.max(maxPositive, positiveLength);
        }
        return maxPositive;
    }
}
