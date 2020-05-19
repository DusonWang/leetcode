package com.leetcode.offer.code;

/**
 * @author duson
 * ����һ������ A[0,1,��,n-1]���빹��һ������ B[0,1,��,n-1]������ B �е�Ԫ�� B[i]=A[0]��A[1]������A[i-1]��A[i+1]������A[n-1]������ʹ�ó�����
 * <p>
 * ?
 * <p>
 * ʾ��:
 * <p>
 * ����: [1,2,3,4,5]
 * ���: [120,60,40,30,24]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * ����Ԫ�س˻�֮�Ͳ������ 32 λ����
 * a.length <= 100000
 * ͨ������9,073�ύ����15,741
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ConstructArr {

    public int[] constructArr(int[] a) {
        int n = a.length, tmp = 1;
        if (n == 0) {
            return new int[0];
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            tmp *= a[i - 1];
            res[i] = tmp;
        }
        tmp = 1;
        for (int i = n - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}
