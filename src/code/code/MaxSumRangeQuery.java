package code.code;

import java.util.Arrays;

/**
 * ��һ����������nums����һ����ѯ����requests������requests[i] = [starti, endi]����i����ѯ��nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi]�Ľ����starti ��endi������������ �� 0 ��ʼ �ġ�
 * <p>
 * ������������� nums�е����֣����㷵�����в�ѯ���֮�͵����ֵ��
 * <p>
 * ���ڴ𰸿��ܻ�ܴ����㽫����109 + 7ȡ��󷵻ء�
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
 * �����19
 * ���ͣ�һ�����е� nums ����Ϊ [2,1,3,4,5]���������½����
 * requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
 * requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
 * �ܺ�Ϊ��8 + 3 = 11��
 * һ���ܺ͸��������Ϊ [3,5,4,2,1]���������½����
 * requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
 * requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
 * �ܺ�Ϊ�� 11 + 8 = 19��������������������в�ѯ֮�����Ľ����
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,2,3,4,5,6], requests = [[0,1]]
 * �����11
 * ���ͣ�һ���ܺ���������Ϊ [6,5,4,3,2,1] ����ѯ��Ϊ [11]��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
 * �����47
 * ���ͣ�һ������������Ϊ [4,10,5,3,2,1] ����ѯ����ֱ�Ϊ [19,18,10]��
 *
 * <p>
 * ��ʾ��
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 0 <= nums[i]<= 105
 * 1 <= requests.length <=105
 * requests[i].length == 2
 * 0 <= starti<= endi<n
 * ͨ������3,293�ύ����11,254
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-sum-obtained-of-any-permutation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxSumRangeQuery {

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        final int mod = 1000000007;
        int length = nums.length;
        int[] counts = new int[length];
        for (int[] request : requests) {
            counts[request[0]]++;
            if (request[1] + 1 < length) {
                counts[request[1] + 1]--;
            }
        }
        for (int i = 1; i < length; i++) {
            counts[i] += counts[i - 1];
        }
        Arrays.sort(counts);
        Arrays.sort(nums);
        long sum = 0;
        for (int i = length - 1; i >= 0 && counts[i] > 0; i--) {
            sum += (long) nums[i] * counts[i];
        }
        return (int) (sum % mod);
    }
}
