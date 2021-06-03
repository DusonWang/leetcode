package code.code;

import java.util.Arrays;

/**
 * ����һ������?nums?��ÿ�β��������ѡ��?nums?�е�����һ��Ԫ�ز������ĳ�����ֵ��
 * <p>
 * ���㷵�����β����� nums?�����ֵ����Сֵ�Ĳ����Сֵ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [5,3,2,4]
 * �����0
 * ���ͣ������� [5,3,2,4] ��� [2,2,2,2].
 * ���ֵ����Сֵ�Ĳ�Ϊ 2-2 = 0 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,5,0,10,14]
 * �����1
 * ���ͣ������� [1,5,0,10,14] ��� [1,1,0,1,1] ��
 * ���ֵ����Сֵ�Ĳ�Ϊ 1-0 = 1 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [6,6,0,1,1,4,6]
 * �����2
 * ʾ�� 4��
 * <p>
 * ���룺nums = [1,5,6,14,15]
 * �����1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * ͨ������4,270�ύ����7,881
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinDifference {

    public int minDifference(int[] a) {
        int n = a.length;
        int res = Integer.MAX_VALUE;
        if (n < 5) {
            return 0;
        }
        Arrays.sort(a);
        for (int i = 0; i < 4; ++i) {
            res = Math.min(res, a[n - 4 + i] - a[i]);
        }
        return res;
    }
}
