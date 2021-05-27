package code.code;

/**
 * ���ǳ�һ���ָ���������ķ����� �õ�?���������㣺
 * <p>
 * ���鱻�ֳ����� �ǿ�?���������飬�������ҷֱ�����Ϊ?left?��?mid?��?right?��
 * left?��Ԫ�غ�С�ڵ���?mid?��Ԫ�غͣ�mid?��Ԫ�غ�С�ڵ���?right?��Ԫ�غ͡�
 * ����һ�� �Ǹ� ��������?nums?�����㷵��?�õ� �ָ� nums?������Ŀ�����ڴ𰸿��ܻ�ܴ����㽫����� 109?+ 7?ȡ��󷵻ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,1,1]
 * �����1
 * ���ͣ�Ψһһ�ֺõķָ���ǽ� nums �ֳ� [1] [1] [1] ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,2,2,2,5,0]
 * �����3
 * ���ͣ�nums �ܹ��� 3 �ֺõķָ����
 * [1] [2] [2,2,5,0]
 * [1] [2,2] [2,5,0]
 * [1,2] [2,2] [5,0]
 * ʾ�� 3��
 * <p>
 * ���룺nums = [3,2,1]
 * �����0
 * ���ͣ�û�кõķָ����
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 3 <= nums.length <= 105
 * 0 <= nums[i] <= 104
 * ͨ������4,767�ύ����17,836
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/ways-to-split-array-into-three-subarrays
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class WaysToSplit {

    public int waysToSplit(int[] nums) {
        int sz = nums.length;
        int res = 0;
        for (int i = 1; i < sz; ++i) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0, j = 0, k = 0; i < sz - 2; ++i) {
            while (j <= i || j < sz - 1 && nums[j] < nums[i] * 2) {
                ++j;
            }
            while (k < j || k < sz - 1 && nums[k] - nums[i] <= nums[sz - 1] - nums[k]) {
                ++k;
            }
            res = (res + k - j) % 1000000007;
        }
        return res;
    }
}
