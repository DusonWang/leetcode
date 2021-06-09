package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ������nums��һ������target��
 * <p>
 * ���㷵�طǿղ��ص�������������Ŀ����ÿ�������������ֺͶ�Ϊ target��
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,1,1,1,1], target = 2
 * �����2
 * ���ͣ��ܹ��� 2 �����ص������飨�Ӵ����ֱ�ʾ�� [1,1,1,1,1] �����ǵĺ�ΪĿ��ֵ 2 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [-1,3,5,1,4,2,-9], target = 6
 * �����2
 * ���ͣ��ܹ��� 3 ���������Ϊ 6 ��
 * ([5,1], [4,2], [3,5,1,4,2,-9]) ��ֻ��ǰ 2 ���ǲ��ص��ġ�
 * ʾ�� 3��
 * <p>
 * ���룺nums = [-2,6,6,3,5,4,1,2,8], target = 10
 * �����3
 * ʾ�� 4��
 * <p>
 * ���룺nums = [0,0,0], target = 0
 * �����3
 *
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <=10^5
 * -10^4 <= nums[i] <=10^4
 * 0 <= target <= 10^6
 * ͨ������4,630�ύ����11,442
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxNonOverlapping {

    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - target)) {
                res = Math.max(res, map.get(sum - target) + 1);
            }
            map.put(sum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxNonOverlapping maxNonOverlapping = new MaxNonOverlapping();
        System.out.println(maxNonOverlapping.maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
        System.out.println(maxNonOverlapping.maxNonOverlapping(new int[]{-1, 3, 5, 1, 4, 2, -9}, 6));

    }
}
