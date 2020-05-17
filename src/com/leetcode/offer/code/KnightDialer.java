package com.leetcode.offer.code;

/**
 * @author duson
 * ���������е���ʿ���԰���ͼ��ʾ�����ƶ���
 * <p>
 * ?.? ? ? ? ? ?
 * <p>
 * <p>
 * ��һ�Σ����ǽ�?����ʿ�� ���ڵ绰�����̵��������ּ�������ͼ��ʾ���ϣ�����������ʿ������?N-1 ����ÿһ�������Ǵ�һ�����ּ�������һ�����ּ���
 * <p>
 * ÿ��������һ�����ϣ�������ʿ�ĳ�ʼλ�ã������Ღ��������Ӧ�����֣��ܹ�����?N λ���֡�
 * <p>
 * ���������ַ�ʽ�������ٸ���ͬ�ĺ��룿
 * <p>
 * ��Ϊ�𰸿��ܴܺ����������ģ?10^9 + 7��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺1
 * �����10
 * ʾ�� 2��
 * <p>
 * ���룺2
 * �����20
 * ʾ�� 3��
 * <p>
 * ���룺3
 * �����46
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= N <= 5000
 * ͨ������2,403�ύ����5,493
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/knight-dialer
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class KnightDialer {

    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }
        int mod = 1000000007;
        long a1 = 1, a2 = 1, a3 = 1, a4 = 1, a6 = 1, a7 = 1, a8 = 1, a9 = 1, a0 = 1;
        for (int i = 0; i < n - 1; i++) {
            long aa1 = (a8 + a6) % mod;
            long aa2 = (a7 + a9) % mod;
            long aa3 = (a4 + a8) % mod;
            long aa4 = (a3 + a9 + a0) % mod;
            long aa6 = (a1 + a7 + a0) % mod;
            long aa7 = (a2 + a6) % mod;
            long aa8 = (a1 + a3) % mod;
            long aa9 = (a2 + a4) % mod;
            long aa0 = (a4 + a6) % mod;
            a1 = aa1;
            a2 = aa2;
            a3 = aa3;
            a4 = aa4;
            a6 = aa6;
            a7 = aa7;
            a8 = aa8;
            a9 = aa9;
            a0 = aa0;
        }
        return (int) ((a1 + a2 + a3 + a4 + a6 + a7 + a8 + a9 + a0) % mod);
    }
}