package com.leetcode.offer.code;

/**
 * �������� k?�����㷵�غ�Ϊ?k?��쳲��������ֵ�������Ŀ�����У�ÿ��쳲��������ֶ����Ա�ʹ�ö�Ρ�
 * <p>
 * 쳲��������ֶ���Ϊ��
 * <p>
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2?�� ���� n > 2 ��
 * ���ݱ�֤���ڸ����� k?��һ�����ҵ����н⡣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺k = 7
 * �����2
 * ���ͣ�쳲���������Ϊ��1��1��2��3��5��8��13������
 * ���� k = 7 �����ǿ��Եõ� 2 + 5 = 7 ��
 * ʾ�� 2��
 * <p>
 * ���룺k = 10
 * �����2
 * ���ͣ����� k = 10 �����ǿ��Եõ� 2 + 8 = 10 ��
 * ʾ�� 3��
 * <p>
 * ���룺k = 19
 * �����3
 * ���ͣ����� k = 19 �����ǿ��Եõ� 1 + 5 + 13 = 19 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= k <= 10^9
 * ͨ������2,169�ύ����4,028
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author duson
 */
public class FindMinFibonacciNumbers {

    public int findMinFibonacciNumbers(int k) {
        int a = 1;
        int b = 1;
        while (a + b <= k) {
            int c = a + b;
            a = b;
            b = c;
        }
        int count = 0;
        while (k > 0) {
            if (b <= k) {
                k = k - b;
                count++;
            }
            int c = b - a;
            b = a;
            a = c;
        }
        return count;
    }
}
