package code.code;

import java.util.Arrays;

/**
 * ����һ������������?nums?������Ҫ����ɾ��һ��Ԫ�ء�
 * <p>
 * ������ɾ��Ԫ�صĽ�������У����������ֻ���� 1 �ķǿ�������ĳ��ȡ�
 * <p>
 * ��������������������飬�뷵�� 0 ��
 * <p>
 * ?
 * <p>
 * ��ʾ 1��
 * <p>
 * ���룺nums = [1,1,0,1]
 * �����3
 * ���ͣ�ɾ��λ�� 2 ������[1,1,1] ���� 3 �� 1 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [0,1,1,1,0,1,1,0,1]
 * �����5
 * ���ͣ�ɾ��λ�� 4 �����ֺ�[0,1,1,1,1,1,0,1] ���ȫ 1 ������Ϊ [1,1,1,1,1] ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,1,1]
 * �����2
 * ���ͣ������Ҫɾ��һ��Ԫ�ء�
 * ʾ�� 4��
 * <p>
 * ���룺nums = [1,1,0,0,1,1,1,0,1]
 * �����4
 * ʾ�� 5��
 * <p>
 * ���룺nums = [0,0,0]
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 10^5
 * nums[i]?Ҫô��?0?Ҫô��?1 ��
 * ͨ������5,953�ύ����10,647
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LongestSubarray2 {

    public int longestSubarray(int[] nums) {
        int a = 0;
        int b = 0;
        int result = 0;
        for (int num : nums) {
            if (num == 0) {
                result = Math.max(result, a + b);
                a = b;
                b = 0;
            } else {
                b++;
            }
        }
        result = Math.max(result, a + b);
        return result == nums.length ? result - 1 : result;
    }

    public static void main(String[] args) {
        LongestSubarray2 longestSubarray2 = new LongestSubarray2();
        System.out.println(longestSubarray2.longestSubarray(new int[]{1, 1, 0, 1}));
    }
}
