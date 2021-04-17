package code.code;

import java.util.Arrays;

/**
 * ���ǽ����� x?�� Ȩ�� ����Ϊ������������ x?��� 1?����Ҫ�Ĳ�����
 * <p>
 * ���?x?��ż������ô?x = x / 2
 * ���?x?����������ô?x = 3 * x + 1
 * �ȷ�˵��x=3 ��Ȩ��Ϊ 7 ����Ϊ 3 ��Ҫ 7 ����� 1 ��3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1����
 * <p>
 * ������������?lo��?hi ��?k?����������ǽ�����?[lo, hi]?֮��������������ǵ�Ȩ��?��������?��������ڵ��� 2 ��������?��ͬ?��Ȩ�أ���ô����������������ֵ?��������?��
 * <p>
 * ���㷵������?[lo, hi]?֮���������Ȩ�������ĵ�?k?������
 * <p>
 * ע�⣬��Ŀ��֤������������?x?��lo <= x <= hi��?�������?1 ����Ҫ�Ĳ�����һ�� 32 λ�з���������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺lo = 12, hi = 15, k = 2
 * �����13
 * ���ͣ�12 ��Ȩ��Ϊ 9��12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1��
 * 13 ��Ȩ��Ϊ 9
 * 14 ��Ȩ��Ϊ 17
 * 15 ��Ȩ��Ϊ 17
 * �����ڵ�����Ȩ�������Ժ�Ľ��Ϊ [12,13,14,15] ������ k = 2 �����ǵڶ�������Ҳ���� 13 ��
 * ע�⣬12 �� 13 ����ͬ��Ȩ�أ��������ǰ������Ǳ�����������14 �� 15 ͬ����
 * ʾ�� 2��
 * <p>
 * ���룺lo = 1, hi = 1, k = 1
 * �����1
 * ʾ�� 3��
 * <p>
 * ���룺lo = 7, hi = 11, k = 4
 * �����7
 * ���ͣ����������� [7, 8, 9, 10, 11] ��Ӧ��Ȩ��Ϊ [16, 3, 19, 6, 14] ��
 * ��Ȩ�������õ��Ľ��Ϊ [8, 10, 11, 7, 9] ��
 * ����������е� 4 ������Ϊ 7 ��
 * ʾ�� 4��
 * <p>
 * ���룺lo = 10, hi = 20, k = 5
 * �����13
 * ʾ�� 5��
 * <p>
 * ���룺lo = 1, hi = 1000, k = 777
 * �����570
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= lo <= hi <= 1000
 * 1 <= k <= hi - lo + 1
 * ͨ������3,135�ύ����4,552
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sort-integers-by-the-power-value
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetKth {

    public int getKth(int lo, int hi, int k) {
        Power[] p = new Power[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            p[i - lo] = new Power(i);
        }
        Arrays.sort(p, (o1, o2) -> {
            if (o1.val > o2.val) {
                return 1;
            } else if (o1.val < o2.val) {
                return -1;
            } else {
                return o1.key > o2.key ? 1 : 0;
            }
        });
        return p[k - 1].key;
    }

    private static class Power {
        private final int key;
        private final int val;

        public Power(int key) {
            this.key = key;
            this.val = calcValue(key);
        }

        private int calcValue(int n) {
            int c = 0;
            while (n > 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = n * 3 + 1;
                }
                c++;
            }
            return c;
        }
    }
}