package com.leetcode.offer.code;

/**
 * @author duson
 * ����?n?�ʶ�����ÿ�ʶ�������Ҫ��ݷ���
 * <p>
 * ����ͳ��������Ч�� �ռ�/���� ���е���Ŀ��ȷ���� i ����Ʒ�����ͷ���?delivery(i) ���������ռ�����?pickup(i) ֮��
 * <p>
 * ���ڴ𰸿��ܴܺ��뷵�ش𰸶� 10^9 + 7 ȡ��Ľ����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 1
 * �����1
 * ���ͣ�ֻ��һ������ (P1, D1)����Ʒ 1 �����ͷ���D1������Ʒ 1 ���ռ�����P1����
 * ʾ�� 2��
 * <p>
 * ���룺n = 2
 * �����6
 * ���ͣ����п��ܵ����а�����
 * (P1,P2,D1,D2)��(P1,P2,D2,D1)��(P1,D1,P2,D2)��(P2,P1,D1,D2)��(P2,P1,D2,D1) �� (P2,D2,P1,D1)��
 * (P1,D2,P2,D1) ��һ����Ч�����У���Ϊ��Ʒ 2 ���ռ�����P2����Ӧ����Ʒ 2 �����ͷ���D2��֮��
 * ʾ�� 3��
 * <p>
 * ���룺n = 3
 * �����90
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 500
 * ͨ������1,462�ύ����2,712
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-all-valid-pickup-and-delivery-options
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountOrders {

    private static final long MOD = (long) 1e9 + 7;

    public int countOrders(int n) {
        long current = 1;

        for (int i = 1; i <= n; i++) {
            current = (i + i - 1) * i * current % MOD;
        }

        return (int) current;
    }
}
