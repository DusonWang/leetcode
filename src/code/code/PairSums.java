package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���һ���㷨���ҳ�����������֮��Ϊָ��ֵ�����������ԡ�һ����ֻ������һ�����ԡ�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: nums = [5,6,5], target = 11
 * ���: [[5,6]]
 * ʾ�� 2:
 * <p>
 * ����: nums = [5,6,5,6], target = 11
 * ���: [[5,6],[5,6]]
 * ��ʾ��
 * <p>
 * nums.length <= 100000
 * ͨ������1,777�ύ����3,785
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/pairs-with-sum-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class PairSums {

    public List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                ++left;
            } else if (sum > target) {
                --right;
            } else {
                ans.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;
            }
        }
        return ans;
    }
}
