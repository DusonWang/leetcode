package code.code;

import java.util.Arrays;

/**
 * ����һ���������� nums ��һ������ k ��
 * <p>
 * ÿһ�������У�����Ҫ��������ѡ����Ϊ k ���������������������Ƴ����顣
 * <p>
 * ��������Զ�����ִ�е�����������
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3,4], k = 5
 * �����2
 * ���ͣ���ʼʱ nums = [1,2,3,4]��
 * - �Ƴ� 1 �� 4 ��֮�� nums = [2,3]
 * - �Ƴ� 2 �� 3 ��֮�� nums = []
 * �����к�Ϊ 5 �����ԣ�������ִ�� 2 �β�����
 * ʾ�� 2��
 * <p>
 * ���룺nums = [3,1,3,4,3], k = 6
 * �����1
 * ���ͣ���ʼʱ nums = [3,1,3,4,3]��
 * - �Ƴ�ǰ���� 3 ��֮��nums = [1,4,3]
 * �����к�Ϊ 6 �����ԣ�������ִ�� 1 �β�����
 *
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 * ͨ������6,191�ύ����12,629
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/max-number-of-k-sum-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxOperations {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int ans = 0;
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                i++;
                j--;
                ans++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
}
