package code.code;

/**
 * ����һ����������nums��һ��������[numsl, numsl+1, ..., numsr-1, numsr]�� �͵ľ���ֵΪabs(numsl + numsl+1 + ... + numsr-1 + numsr)��
 * <p>
 * �����ҳ� nums�� �͵ľ���ֵ �������������飨����Ϊ�գ��������ظ� ���ֵ��
 * <p>
 * abs(x)�������£�
 * <p>
 * ���x�Ǹ���������ôabs(x) = -x��
 * ���x�ǷǸ���������ôabs(x) = x��
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,-3,2,3,-4]
 * �����5
 * ���ͣ������� [2,3] �͵ľ���ֵ���Ϊ abs(2+3) = abs(5) = 5 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [2,-5,1,-4,3,-2]
 * �����8
 * ���ͣ������� [-5,1,-4] �͵ľ���ֵ���Ϊ abs(-5+1-4) = abs(-8) = 8 ��
 *
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * ͨ������2,959�ύ����5,587
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-absolute-sum-of-any-subarray
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxAbsoluteSum {

    public int maxAbsoluteSum(int[] nums) {
        int s = 0;
        int min = 0;
        int max = 0;
        for (int a : nums) {
            s += a;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return max - min;
    }

    public static void main(String[] args) {
        MaxAbsoluteSum maxAbsoluteSum = new MaxAbsoluteSum();
        System.out.println(maxAbsoluteSum.maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));
    }
}
