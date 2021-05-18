package code.code;

import java.util.Arrays;

/**
 * ����һ���������� nums ��һ������ target ��
 * <p>
 * ����ͳ�Ʋ����� nums ������������СԪ�������Ԫ�ص� �� С�ڻ���� target �� �ǿ� �����е���Ŀ��
 * <p>
 * ���ڴ𰸿��ܴܺ��뽫����� 10^9 + 7 ȡ��󷵻ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [3,5,6,7], target = 9
 * �����4
 * ���ͣ��� 4 �������������������
 * [3] -> ��СԪ�� + ���Ԫ�� <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * ʾ�� 2��
 * <p>
 * ���룺nums = [3,3,6,8], target = 10
 * �����6
 * ���ͣ��� 6 ���������������������nums �п������ظ����֣�
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * ʾ�� 3��
 * <p>
 * ���룺nums = [2,3,3,4,6,7], target = 12
 * �����61
 * ���ͣ����� 63 ���ǿ������У����� 2 ��������������[6,7], [7]��
 * ��Ч��������Ϊ��63 - 2 = 61��
 * ʾ�� 4��
 * <p>
 * ���룺nums = [5,2,4,1,7,6,8], target = 16
 * �����127
 * ���ͣ����зǿ������ж��������� (2^7 - 1) = 127
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * 1 <= target <= 10^6
 * ͨ������4,551�ύ����13,704
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumSubseq {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int mod = 1000000007;
        int len = nums.length;
        int[] pow = new int[len];
        pow[0] = 1;
        for (int i = 1; i < len; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                res = (res + pow[j - i]) % mod;
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumSubseq numSubseq = new NumSubseq();
        System.out.println(numSubseq.numSubseq(new int[]{3, 4}, 8));
    }
}
