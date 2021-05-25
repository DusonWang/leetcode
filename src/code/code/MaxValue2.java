package code.code;

/**
 * �������������� n��index �� maxSum ������Ҫ����һ��ͬʱ���������������������� nums���±� �� 0 ��ʼ ��������
 * <p>
 * nums.length == n
 * nums[i] �� ������ ������ 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ������ 0 <= i < n-1
 * nums ������Ԫ��֮�Ͳ����� maxSum
 * nums[index] ��ֵ�� ���
 * ������������������е� nums[index] ��
 * <p>
 * ע�⣺abs(x) ���� x ��ǰ���� x >= 0 ������abs(x) ���� -x ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 4, index = 2,  maxSum = 6
 * �����2
 * ���ͣ����� [1,1,2,1] �� [1,2,2,1] ��������������������������ָ���±괦���и���ֵ����Ч���顣
 * ʾ�� 2��
 * <p>
 * ���룺n = 6, index = 1,  maxSum = 10
 * �����3
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= maxSum <= 109
 * 0 <= index < n
 * ͨ������3,693�ύ����14,358
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-value-at-a-given-index-in-a-bounded-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxValue2 {

    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int left = 0, right = maxSum, mid;
        while (left < right) {
            mid = (left + right + 1) / 2;
            if (test(n, index, mid) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;
    }

    private long test(int n, int index, int a) {
        int b = Math.max(a - index, 0);
        long res = (long) (a + b) * (a - b + 1) / 2;
        b = Math.max(a - ((n - 1) - index), 0);
        res += (long) (a + b) * (a - b + 1) / 2;
        return res - a;
    }
}
