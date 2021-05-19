package code.code;

import java.util.Arrays;

/**
 * ����һ�� �ǵݼ�?������������?nums?��
 * <p>
 * ���㽨��������һ����������?result������?nums?������ͬ����result[i]?����?nums[i]?����������������Ԫ�ز�ľ���ֵ֮�͡�
 * <p>
 * ���仰˵��?result[i]?����?sum(|nums[i]-nums[j]|) ������?0 <= j < nums.length ��?j != i?���±�� 0 ��ʼ����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [2,3,5]
 * �����[4,3,5]
 * ���ͣ����������±�� 0 ��ʼ����ô
 * result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4��
 * result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3��
 * result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,4,6,8,10]
 * �����[24,15,13,15,21]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= nums[i + 1] <= 104
 * ͨ������2,841�ύ����4,910
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sum-of-absolute-differences-in-a-sorted-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetSumAbsoluteDifferences {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int pNum = nums[0];
        nums[0] = sum - nums[0] * nums.length;
        for (int i = 1; i < nums.length; i++) {
            int curNum = nums[i];
            nums[i] = nums[i - 1] - (curNum - pNum) * (nums.length - i - i);
            pNum = curNum;
        }
        return nums;
    }

    public static void main(String[] args) {
        GetSumAbsoluteDifferences getSumAbsoluteDifferences = new GetSumAbsoluteDifferences();
        System.out.println(Arrays.toString(getSumAbsoluteDifferences.getSumAbsoluteDifferences(new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(getSumAbsoluteDifferences.getSumAbsoluteDifferences(new int[]{1, 4, 6, 8, 10})));
    }
}
