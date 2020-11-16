package code.code;

/**
 * @author duson
 * ����һ���������� nums?�������ѡ�������?���� startValue ��Ϊ��ʼֵ��
 * <p>
 * ����Ҫ�����ұ��� nums?���飬���� startValue �����ۼ���?nums?�����е�ֵ��
 * <p>
 * ������ȷ���ۼӺ�ʼ�մ��ڵ��� 1 ��ǰ���£�ѡ��һ����С��?����?��Ϊ startValue ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [-3,2,-3,4,2]
 * �����5
 * ���ͣ������ѡ�� startValue = 4���ڵ������ۼ�ʱ����С�� 1 ��
 * �ۼ����
 * ?               startValue = 4 | startValue = 5 | nums
 * ?                 (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 * ?                 (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 * ?                 (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 * ?                 (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 * ?                 (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,2]
 * �����1
 * ���ͣ���С�� startValue ��Ҫ��������
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,-2,-3]
 * �����5
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * ͨ������3,263�ύ����4,727
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinStartValue {

    public int minStartValue(int[] nums) {
        int res = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            res = Math.min(sum, res);
        }
        return Math.max(1 - res, 1);
    }
}
