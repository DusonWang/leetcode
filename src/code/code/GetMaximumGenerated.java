package code.code;

/**
 * ����һ������ n ����������������һ������Ϊ n + 1 ������ nums ��
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * �� 2 <= 2 * i <= n ʱ��nums[2 * i] = nums[i]
 * �� 2 <= 2 * i + 1 <= n ʱ��nums[2 * i + 1] = nums[i] + nums[i + 1]
 * ������������ nums �е� ��� ֵ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 7
 * �����3
 * ���ͣ����ݹ���
 * nums[0] = 0
 * nums[1] = 1
 * nums[(1 * 2) = 2] = nums[1] = 1
 * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * nums[(2 * 2) = 4] = nums[2] = 1
 * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * nums[(3 * 2) = 6] = nums[3] = 2
 * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * ��ˣ�nums = [0,1,1,2,1,3,2,3]�����ֵ 3
 * ʾ�� 2��
 * <p>
 * ���룺n = 2
 * �����1
 * ���ͣ����ݹ���nums[0]��nums[1] �� nums[2] ֮�е����ֵ�� 1
 * ʾ�� 3��
 * <p>
 * ���룺n = 3
 * �����2
 * ���ͣ����ݹ���nums[0]��nums[1]��nums[2] �� nums[3] ֮�е����ֵ�� 2
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= n <= 100
 * ͨ������6,247�ύ����12,362
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/get-maximum-in-generated-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetMaximumGenerated {

    public int getMaximumGenerated(int n) {
        int[] nums = new int[n + 1];
        if (n < 2) {
            return n;
        }
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 2; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
