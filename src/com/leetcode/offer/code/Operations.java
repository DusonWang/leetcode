package com.leetcode.offer.code;

/**
 * @author duson
 * ��ʵ���������ֵĳ˷��������ͳ������㣬��������Ϊ�������֣�������ֻ����ʹ�üӷ���������߼����������������г�������������������ʹ��λ���㡣
 * <p>
 * ���ʵ��Ӧ��֧�����²�����
 * <p>
 * Operations() ���캯��
 * minus(a, b) ����������a - b
 * multiply(a, b) �˷�������a * b
 * divide(a, b) ����������a / b
 * ʾ����
 * <p>
 * Operations operations = new Operations();
 * operations.minus(1, 2); //����-1
 * operations.multiply(3, 4); //����12
 * operations.divide(5, -2); //����-2
 * ��ʾ��
 * <p>
 * ����Լ��躯������һ������Ч�ģ����粻����ֳ�����ĸΪ0�����
 * ���������ĺ������ô������ᳬ��1000��
 * ͨ������397�ύ����883
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/operations-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Operations {

    public Operations() {

    }

    public int minus(int a, int b) {
        b = -b;
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public int multiply(int a, int b) {
        int ans = 0;
        boolean flag = (a > 0) == (b <= 0);
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans + a;
            }
            a <<= 1;
            b >>= 1;
        }
        return flag ? -ans : ans;
    }

    public int divide(int dividend, int divisor) {
        boolean s = (dividend ^ divisor) >= 0;
        long d1 = dividend;
        long d2 = divisor;
        d1 = d1 > 0 ? d1 : -d1;
        d2 = d2 > 0 ? d2 : -d2;
        if (d1 < d2) {
            return 0;
        }
        long d = 0x40_00_00_00_00L, c = 0L, res = 0L;
        while (d != 0) {
            c = (c << 1) | ((d & d1) == 0 ? 0 : 1);
            if (c >= d2) {
                res = (res << 1) | 1;
                c -= d2;
            } else {
                res = res << 1;
            }
            d = d >> 1;
        }
        return s ? res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res : (int) -res;
    }
}
