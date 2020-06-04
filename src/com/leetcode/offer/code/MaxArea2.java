package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * ���ε���ĸ߶�Ϊ h �ҿ��Ϊ w������������������ horizontalCuts �� verticalCuts������ horizontalCuts[i] �ǴӾ��ε��ⶥ������? i ��ˮƽ�пڵľ��룬���Ƶأ� verticalCuts[j] �ǴӾ��ε������ൽ�� j ����ֱ�пڵľ��롣
 * <p>
 * ���㰴���� horizontalCuts �� verticalCuts ���ṩ��ˮƽ����ֱλ���и�������ҳ� ������ ���Ƿݵ��⣬�������� ��� �����ڴ𰸿�����һ���ܴ�����֣������Ҫ������� 10^9 + 7 ȡ��󷵻ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
 * �����4
 * ���ͣ���ͼ��ʾ�ľ��󵰸��У���ɫ�߱�ʾˮƽ����ֱ�����ϵ��пڡ��и�����ɫ���Ƿݵ���������
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
 * �����6
 * ���ͣ���ͼ��ʾ�ľ��󵰸��У���ɫ�߱�ʾˮƽ����ֱ�����ϵ��пڡ��и�����ɫ�ͻ�ɫ�����ݵ���������
 * ʾ�� 3��
 * <p>
 * ���룺h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
 * �����9
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= h,?w <= 10^9
 * 1 <=?horizontalCuts.length <?min(h, 10^5)
 * 1 <=?verticalCuts.length < min(w, 10^5)
 * 1 <=?horizontalCuts[i] < h
 * 1 <=?verticalCuts[i] < w
 * ��Ŀ���ݱ�֤ horizontalCuts �е�����Ԫ�ظ�����ͬ
 * ��Ŀ���ݱ�֤ verticalCuts?�е�����Ԫ�ظ�����ͬ
 * ͨ������3,469�ύ����12,536
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxArea2 {


    public int maxArea(int h, int w, int[] hc, int[] vc) {
        return (int) ((getMaxDist(h, hc) * getMaxDist(w, vc)) % (Math.pow(10, 9) + 7));
    }

    private long getMaxDist(int end, int[] cuts) {
        Arrays.sort(cuts);
        long res = 0, from = 0;
        for (int c : cuts) {
            res = Math.max(res, c - from);
            from = c;
        }
        return Math.max(res, end - from);
    }
}
