package code.code;

import java.util.Arrays;

/**
 * ����һ������?nums?��������?n?��������������Ҫ�������зǿ�����������ĺͣ��������ǰ��������򣬵õ�һ���µİ���?n * (n + 1) / 2?�����ֵ����顣
 * <p>
 * ���㷵�������������±�Ϊ?left?��?right ���±�� 1 ��ʼ�����������ֺͣ��������Ҷ˵㣩�����ڴ𰸿��ܴܺ����㽫���� 10^9 + 7 ȡģ�󷵻ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3,4], n = 4, left = 1, right = 5
 * �����13
 * ���ͣ����е��������Ϊ 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 ��������������������ǵõ��µ����� [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] ���±�� le = 1 �� ri = 5 �ĺ�Ϊ 1 + 2 + 3 + 3 + 4 = 13 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,2,3,4], n = 4, left = 3, right = 4
 * �����6
 * ���ͣ�����������ʾ�� 1 һ��������������Ϊ [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] ���±�� le = 3 �� ri = 4 �ĺ�Ϊ 3 + 3 = 6 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,2,3,4], n = 4, left = 1, right = 10
 * �����50
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 10^3
 * nums.length == n
 * 1 <= nums[i] <= 100
 * 1 <= left <= right?<= n * (n + 1) / 2
 * ͨ������5,465�ύ����9,913
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/range-sum-of-sorted-subarray-sums
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class RangeSum {

    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MODULO = 1000000007;
        int sumsLength = n * (n + 1) / 2;
        int[] sums = new int[sumsLength];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[index++] = sum;
            }
        }
        Arrays.sort(sums);
        int ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans = (ans + sums[i]) % MODULO;
        }
        return ans;
    }

    public static void main(String[] args) {
        RangeSum rangeSum = new RangeSum();
        System.out.println(rangeSum.rangeSum(new int[]{1,2,3,4},4,1,5));
    }
}
