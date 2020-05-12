package com.leetcode.offer.code;

/**
 * @author duson
 * ��һ�Ŷ���ŵ�����У�A[i] �� B[i]?�ֱ����� i ������ŵ���Ƶ��ϰ벿�ֺ��°벿�֡���һ������ŵ�������� 1 �� 6 ������ͬ��ƽ���γɵ�?���� ��ƽ�̵�ÿһ���϶���һ�����֡���
 * <p>
 * ���ǿ�����ת��?i?�Ŷ���ŵ��ʹ��?A[i] ��?B[i]?��ֵ������
 * <p>
 * ������ʹ A ������ֵ���� B ������ֵ����ͬ����С��ת������
 * <p>
 * ����޷�����������?-1.
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * �����2
 * ���ͣ�
 * ͼһ��ʾ����������ת֮ǰ�� A �� B �����Ķ���ŵ�ơ�
 * ���������ת�ڶ����͵��ĸ�����ŵ���ƣ����ǿ���ʹ����һ���е�ÿ��ֵ������ 2����ͼ����ʾ��
 * ʾ�� 2��
 * <p>
 * ���룺A = [3,5,1,2,3], B = [3,6,3,3,4]
 * �����-1
 * ���ͣ�
 * ����������£���������ת����ŵ��ʹһ�е�ֵ��ȡ�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 * ͨ������2,828�ύ����6,388
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-domino-rotations-for-equal-row
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinDominoRotations {

    public int minDominoRotations(int[] A, int[] B) {
        int min = A.length;
        min = Math.min(min, count(A, B, A[0]));
        if (A[0] != B[0]) {
            min = Math.min(min, count(A, B, B[0]));
        }
        return min == A.length ? -1 : min;
    }

    private int count(int[] A, int[] B, int number) {
        int commons = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != number && B[i] != number) {
                return A.length;
            } else if (A[i] != B[i]) {
                if (A[i] == number) {
                    a++;
                } else {
                    b++;
                }
            }
        }
        return Math.min(a, b);
    }
}
