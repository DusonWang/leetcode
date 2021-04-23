package code.code;

import java.util.Arrays;

/**
 * ����һ����������?nums?�����㽫���鰴��ÿ��ֵ��Ƶ�� ���� ��������ж��ֵ��Ƶ����ͬ�����㰴����ֵ�������� ���� ����?
 * <p>
 * ���㷵�����������顣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,1,2,2,2,3]
 * �����[3,1,1,2,2,2]
 * ���ͣ�'3' Ƶ��Ϊ 1��'1' Ƶ��Ϊ 2��'2' Ƶ��Ϊ 3 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [2,3,1,3,2]
 * �����[1,3,3,2,2]
 * ���ͣ�'2' �� '3' Ƶ�ʶ�Ϊ 2 ����������֮�䰴����ֵ����������
 * ʾ�� 3��
 * <p>
 * ���룺nums = [-1,1,-6,4,5,-6,1,4,1]
 * �����[5,-1,4,4,-6,-6,1,1,1]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * ͨ������6,800�ύ����9,581
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sort-array-by-increasing-frequency
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FrequencySort2 {

    public int[] frequencySort(int[] nums) {
        int[] cnts = new int[201];
        for (int n : nums){
            cnts[n + 100] ++;
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = 201 * cnts[nums[i] + 100] - nums[i] + 100;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            nums[i] = 100 - nums[i] % 201;
        }
        return nums;
    }
}
