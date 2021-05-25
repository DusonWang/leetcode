package code.code;

import java.util.Arrays;

/**
 * ����һ���������� nums??? ��һ������ k????? ������ [left, right]��left <= right���� ����� �Ƕ��±�λ��?left �� right������ left �� right ��֮������Ԫ�ؽ��� XOR ����Ľ����nums[left] XOR nums[left+1] XOR ... XOR nums[right] ��
 * <p>
 * ���������� Ҫ���ĵ���СԪ���� ����ʹ���г���Ϊ k ����������������㡣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,0,3,0], k = 1
 * �����3
 * ���ͣ������� [1,2,0,3,0] �޸�Ϊ [0,0,0,0,0]
 * ʾ�� 2��
 * <p>
 * ���룺nums = [3,4,5,2,1,7,3,4,7], k = 3
 * �����3
 * ���ͣ������� [3,4,5,2,1,7,3,4,7] �޸�Ϊ [3,4,7,3,4,7,3,4,7]
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,2,4,1,2,5,1,2,6], k = 3
 * �����3
 * ���ͣ�������[1,2,4,1,2,5,1,2,6] �޸�Ϊ [1,2,3,1,2,3,1,2,3]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= k <= nums.length <= 2000
 * ??????0 <= nums[i] < 210
 * ͨ������1,888�ύ����3,798
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinChanges {

    public static int minChanges(int[] nums, int k) {
        int N = nums.length;
        int[][] fre = new int[k][1024];
        for (int i = 0; i < N; i++) {
            fre[i % k][nums[i]]++;
        }
        int[] dp = new int[1024];
        Arrays.fill(dp, -N);
        dp[0] = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            int[] DP = new int[1024];
            Arrays.fill(DP, max);
            int MAX = 0;
            for (int xor = 0; xor < 1024; xor++) {
                for (int al = i; al < N; al += k) {
                    DP[xor] = Math.max(DP[xor], dp[xor ^ nums[al]] + fre[i][nums[al]]);
                }
                MAX = Math.max(MAX, DP[xor]);
            }
            max = MAX;
            dp = DP;
        }
        return N - dp[0];
    }
}
