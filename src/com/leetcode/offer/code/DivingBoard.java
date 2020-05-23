package com.leetcode.offer.code;

/**
 * ������ʹ��һ��ľ�彨����ˮ�塣���������͵�ľ�壬���г��Ƚ϶̵�ľ�峤��Ϊshorter�����Ƚϳ���ľ�峤��Ϊlonger�����������ʹ��k��ľ�塣��дһ��������������ˮ�����п��ܵĳ��ȡ�
 * <p>
 * ���صĳ�����Ҫ��С�������С�
 * <p>
 * ʾ����
 * <p>
 * ���룺
 * shorter = 1
 * longer = 2
 * k = 3
 * ����� {3,4,5,6}
 * ��ʾ��
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * ͨ������3,823�ύ����9,420
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/diving-board-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{k * shorter};
        }

        int[] res = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            res[i] = (k - i) * shorter + i * longer;
        }
        return res;
    }
}
