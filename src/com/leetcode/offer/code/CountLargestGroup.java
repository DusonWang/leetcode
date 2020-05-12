package com.leetcode.offer.code;

/**
 * @author duson
 * ����һ������ n?������������� 1?�� n ��ÿ������ 10 ���Ʊ�ʾ�µ���λ�ͣ�ÿһλ�ϵ�������ӣ���Ȼ�����λ����ȵ����ַŵ�ͬһ�����С�
 * <p>
 * ����ͳ��ÿ�����е�������Ŀ��������������Ŀ�����������ж��ٸ���
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 13
 * �����4
 * ���ͣ��ܹ��� 9 ���飬�� 1 �� 13 ����λ��ͺ���Щ��ֱ��ǣ�
 * [1,10]��[2,11]��[3,12]��[4,13]��[5]��[6]��[7]��[8]��[9]���ܹ��� 4 ����ӵ�е����ֲ�����ࡣ
 * ʾ�� 2��
 * <p>
 * ���룺n = 2
 * �����2
 * ���ͣ��ܹ��� 2 ����СΪ 1 ���� [1]��[2]��
 * ʾ�� 3��
 * <p>
 * ���룺n = 15
 * �����6
 * ʾ�� 4��
 * <p>
 * ���룺n = 24
 * �����5
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 10^4
 * ͨ������2,880�ύ����4,520
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-largest-group
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountLargestGroup {

    public int countLargestGroup(int n) {
        int[] arr = new int[37];
        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
            int curr = digitSum(i);
            arr[curr]++;
            maxSize = Math.max(maxSize, arr[curr]);
        }
        int res = 0;
        for (int value : arr) {
            if (value == maxSize) {
                res++;
            }
        }
        return res;
    }

    private int digitSum(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10);
            n /= 10;
        }
        return res;
    }
}
