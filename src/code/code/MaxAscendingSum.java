package code.code;

/**
 * ����һ����������ɵ����� nums ������ nums ��һ�� ���� �������������Ԫ�غ͡�
 * <p>
 * �������������е�һ�������������С�
 * <p>
 * ��֪������ [numsl, numsl+1, ..., numsr-1, numsr] ���������� i��l <= i < r����numsi < numsi+1 �������������һ������Ϊ ���� �����顣ע�⣬��СΪ 1 ��������Ҳ���� ���� �����顣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [10,20,30,5,10,50]
 * �����65
 * ���ͣ�[5,10,50] ��Ԫ�غ��������������飬���Ԫ�غ�Ϊ 65 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [10,20,30,40,50]
 * �����150
 * ���ͣ�[10,20,30,40,50] ��Ԫ�غ��������������飬���Ԫ�غ�Ϊ 150 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [12,17,15,13,10,11,12]
 * �����33
 * ���ͣ�[10,11,12] ��Ԫ�غ��������������飬���Ԫ�غ�Ϊ 33 ��
 * ʾ�� 4��
 * <p>
 * ���룺nums = [100,10,1]
 * �����100
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * ͨ������6,500�ύ����9,323
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-ascending-subarray-sum easy
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxAscendingSum {

    public int maxAscendingSum(int[] nums) {
        int result = -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int k = nums[i];
            while (i + 1 < len && nums[i + 1] > nums[i]) {
                k += nums[++i];
            }
            if (k > result) {
                result = k;
            }
        }
        return result;
    }
}
