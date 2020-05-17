package com.leetcode.offer.code;

/**
 * @author duson
 * ʵ�ֺ���double Power(double base, int exponent)����base��exponent�η�������ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ������⡣
 * <p>
 * ?
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 2.00000, 10
 * ���: 1024.00000
 * ʾ��?2:
 * <p>
 * ����: 2.10000, 3
 * ���: 9.26100
 * ʾ��?3:
 * <p>
 * ����: 2.00000, -2
 * ���: 0.25000
 * ����: 2-2 = 1/22 = 1/4 = 0.25
 * ?
 * <p>
 * ˵��:
 * <p>
 * -100.0 <?x?< 100.0
 * n?�� 32 λ�з�������������ֵ��Χ��?[?231,?231?? 1] ��
 * ע�⣺��������վ 50 ����ͬ��https://leetcode-cn.com/problems/powx-n/
 * <p>
 * ͨ������15,058�ύ����46,491
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MyPow {

    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow2(x, n / 2);
        double mod = myPow2(x, n % 2);
        return half * half * mod;
    }
}
