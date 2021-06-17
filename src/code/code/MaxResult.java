package code.code;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * ����һ���±�� 0 ��ʼ���������� nums��һ������ k��
 * <p>
 * һ��ʼ�����±�0����ÿһ��������������ǰ��k�������㲻����������ı߽硣Ҳ����˵������Դ��±�i����[i + 1�� min(n - 1, i + k)]���� �����˵������λ�á�
 * <p>
 * ���Ŀ���ǵ����������һ��λ�ã��±�Ϊ n - 1������� �÷�Ϊ��������������֮�͡�
 * <p>
 * ���㷵�����ܵõ��� ���÷֡�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,-1,-2,4,-7,3], k = 2
 * �����7
 * ���ͣ������ѡ�������� [1,-1,4,3] ������Ӵֵ����֣�����Ϊ 7 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [10,-5,-2,4,0,3], k = 3
 * �����17
 * ���ͣ������ѡ�������� [10,4,3] ������Ӵ����֣�����Ϊ 17 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * �����0
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length, k <= 105
 * -104<= nums[i]<= 104
 * ͨ������5,112�ύ����12,567
 * ��������������Ƹ����������
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/jump-game-vi
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxResult {

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            for (int j = Math.max(0, i - k); j < i; ++j) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        MaxResult maxResult = new MaxResult();
        System.out.println(maxResult.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
    }
}
