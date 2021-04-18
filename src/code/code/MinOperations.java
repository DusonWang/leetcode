package code.code;

/**
 * ����һ����������?nums?���±�� 0 ��ʼ����ÿһ�β����У������ѡ��������һ��Ԫ�أ�����������?1?��
 * <p>
 * �ȷ�˵�����?nums = [1,2,3]?�������ѡ������?nums[1]?�õ�?nums = [1,3,3]?��
 * ���㷵��ʹ nums?�ϸ����?�� ����?����������
 * <p>
 * ���ǳ�����?nums?�� �ϸ������?����������������е�?0 <= i < nums.length - 1?����?nums[i] < nums[i+1]?��һ������Ϊ 1?���������ϸ������һ�����������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,1,1]
 * �����3
 * ���ͣ�����Խ������²�����
 * 1) ���� nums[2] �������Ϊ [1,1,2] ��
 * 2) ���� nums[1] �������Ϊ [1,2,2] ��
 * 3) ���� nums[2] �������Ϊ [1,2,3] ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,5,2,4,1]
 * �����14
 * ʾ�� 3��
 * <p>
 * ���룺nums = [8]
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 5000
 * 1 <= nums[i] <= 104
 * ͨ������2,916�ύ����3,543
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-increasing
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinOperations {

    public int minOperations(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                count = count + (nums[i - 1] - nums[i] + 1);
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }
}
