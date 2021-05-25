package code.code;

import java.util.HashSet;
import java.util.Set;

/**
 * ����һ������������ nums ���������ɾ��һ������ ���ɲ�ͬԪ�� �������顣ɾ��������� �÷� �����������Ԫ��֮ �� ��
 * <p>
 * ���� ֻɾ��һ�� ������ɻ�õ� ���÷� ��
 * <p>
 * ������� b ������ a ��һ�����������У������������ a[l],a[l+1],...,a[r] ����ô������?a ��һ�������顣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [4,2,4,5,6]
 * �����17
 * ���ͣ������������� [2,4,5,6]
 * ʾ�� 2��
 * <p>
 * ���룺nums = [5,2,1,2,5,2,1,2,5]
 * �����8
 * ���ͣ������������� [5,2,1] �� [1,2,5]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * ͨ������4,828�ύ����10,951
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-erasure-value
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaximumUniqueSubarray {

    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int ans = 0;
        int j = 0;
        int i = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums.length && j < nums.length) {
            if (!set.contains(nums[j])) {
                sum += nums[j];
                ans = Math.max(sum, ans);
                set.add(nums[j++]);
            } else {
                sum -= nums[i];
                set.remove(nums[i++]);
            }
        }
        return ans;
    }

//    public int maximumUniqueSubarray(int[] nums) {
//        int score = 0;
//        int max = 0;
//        int l = 0;
//        boolean[] visited = new boolean[10001];
//        for (int num : nums) {
//            if (!visited[num]) {
//                visited[num] = true;
//                score += num;
//            } else {
//                max = Math.max(max, score);
//                while (nums[l] != num) {
//                    score -= nums[l];
//                    visited[nums[l]] = false;
//                    l++;
//                }
//                l++;
//            }
//        }
//        return Math.max(max, score);
//    }

    public static void main(String[] args) {
        MaximumUniqueSubarray maximumUniqueSubarray = new MaximumUniqueSubarray();
        System.out.println(maximumUniqueSubarray.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
        System.out.println(maximumUniqueSubarray.maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));

    }
}
