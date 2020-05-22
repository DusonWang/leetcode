package com.leetcode.offer.code;

/**
 * ���롣��������32λ������N��M���Լ���ʾ����λ�õ�i��j����дһ�ַ�������M����N��ʹ��M��N�ĵ�jλ��ʼ������iλ�������ٶ���jλ��iλ��������M��Ҳ����M = 10 011����ôj��i֮�����ٿ�����5��λ�����磬�����ܳ���j = 3��i = 2���������Ϊ��3λ�͵�2λ֮��Ų���M��
 * <p>
 * ʾ��1:
 * <p>
 * ���룺N = 10000000000, M = 10011, i = 2, j = 6
 * �����N = 10001001100
 * ʾ��2:
 * <p>
 * ���룺 N = 0, M = 11111, i = 0, j = 4
 * �����N = 11111
 * ͨ������1,554�ύ����3,241
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/insert-into-bits-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class InsertBits {

    public int insertBits(int n, int m, int i, int j) {
        for (int k = i; k < j + 1; k++) {
            n = n & Integer.rotateLeft(~1, k);
        }
        return n | (m << i);
    }

}
