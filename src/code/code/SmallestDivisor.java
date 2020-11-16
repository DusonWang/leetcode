package code.code;

/**
 * @author duson
 * ����һ����������?nums ��һ��������?threshold ?������Ҫѡ��һ����������Ϊ������Ȼ��������ÿ�����������������Գ��������͡�
 * <p>
 * �����ҳ��ܹ�ʹ�������С�ڵ�����ֵ?threshold?�ĳ����� ��С ���Ǹ���
 * <p>
 * ÿ�������Գ���������ȡ�����ȷ�˵ 7/3 = 3 �� 10/2 = 5 ��
 * <p>
 * ��Ŀ��֤һ���н⡣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,5,9], threshold = 6
 * �����5
 * ���ͣ��������Ϊ 1 �����ǿ��Եõ���Ϊ 17 ��1+2+5+9����
 * �������Ϊ 4 �����ǿ��Եõ���Ϊ 7 (1+1+2+3) ���������Ϊ 5 ����Ϊ 5 (1+1+1+2)��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [2,3,5,7,11], threshold = 11
 * �����3
 * ʾ�� 3��
 * <p>
 * ���룺nums = [19], threshold = 5
 * �����4
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 5 * 10^4
 * 1 <= nums[i] <= 10^6
 * nums.length <=?threshold <= 10^6
 * ͨ������3,456�ύ����9,511
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SmallestDivisor {

    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 1_000_000;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int res = cal(nums, mid);
            if (res > threshold) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int cal(int[] nums, int div) {
        int sum = 0;
        for (int n : nums) {
            sum += n / div;
            if (n % div != 0) {
                sum += 1;
            }
        }
        return sum;
    }
}
