package com.leetcode.offer.code;

/**
 * @author duson
 * ������?n?�����࣬���Ƿֱ�� 1 �� n ���б�š�
 * <p>
 * ���������һ�ݺ���Ԥ�������е�?i?��Ԥ����¼?bookings[i] = [i, j, k]?��ζ�������ڴ�?i?��?j?��ÿ��������Ԥ���� k ����λ��
 * <p>
 * ���㷵��һ������Ϊ n ������?answer����������˳�򷵻�ÿ��������Ԥ������λ����
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * �����[10,55,45,25,25]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 * ͨ������8,886�ύ����20,355
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/corporate-flight-bookings
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counters = new int[n];
        for (int[] booking : bookings) {
            counters[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                counters[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; ++i) {
            counters[i] += counters[i - 1];
        }
        return counters;
    }
}
