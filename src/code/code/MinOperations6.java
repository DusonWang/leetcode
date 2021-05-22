package code.code;

/**
 * ����һ���������� nums ��һ������ x ��ÿһ�β���ʱ����Ӧ���Ƴ����� nums ����߻����ұߵ�Ԫ�أ�Ȼ��� x �м�ȥ��Ԫ�ص�ֵ����ע�⣬��Ҫ �޸� �����Թ��������Ĳ���ʹ�á�
 * <p>
 * ������Խ� x?ǡ�� ����?0 ������ ��С������ �����򣬷��� -1 ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,1,4,2,3], x = 5
 * �����2
 * ���ͣ���ѽ���������Ƴ�������Ԫ�أ��� x ���� 0 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [5,6,7,8,9], x = 4
 * �����-1
 * ʾ�� 3��
 * <p>
 * ���룺nums = [3,2,20,1,1,3], x = 10
 * �����5
 * ���ͣ���ѽ���������Ƴ�������Ԫ�غ�ǰ����Ԫ�أ��ܹ� 5 �β��������� x ���� 0 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 * ͨ������6,684�ύ����23,640
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-operations-to-reduce-x-to-zero
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinOperations6 {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int maxLength = -1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int cnt = sum - x;
        if (cnt < 0) {
            return -1;
        }
        int sumNumbs = 0;
        while (right < n) {
            sumNumbs += nums[right];
            while (sumNumbs > cnt) {
                sumNumbs -= nums[left];
                left++;
            }
            if (sumNumbs == cnt) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength == -1 ? -1 : n - maxLength;
    }
}
