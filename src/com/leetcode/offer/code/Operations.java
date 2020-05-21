package com.leetcode.offer.code;

import java.math.BigInteger;

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
        return BigInteger.valueOf(a).subtract(BigInteger.valueOf(b)).intValue();
    }

    public int multiply(int a, int b) {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).intValue();
    }

    public int divide(int a, int b) {
        return BigInteger.valueOf(a).divide(BigInteger.valueOf(b)).intValue();
    }
}
