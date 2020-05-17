package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author duson
 * ���������ڶ�ȡһ��������ÿ��һ��ʱ�䣬��ϣ�����ҳ����� x ����(С�ڻ���� x ��ֵ�ĸ���)����ʵ�����ݽṹ���㷨��֧����Щ������Ҳ����˵��
 * <p>
 * ʵ�� track(int x)?������ÿ����һ�����ֶ�����ø÷�����
 * <p>
 * ʵ�� getRankOfNumber(int x) ����������С�ڻ���� x ��ֵ�ĸ�����
 * <p>
 * ע�⣺�������ԭ�������Ķ�
 * <p>
 * ʾ��:
 * <p>
 * ����:
 * ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
 * [[], [1], [0], [0]]
 * ���:
 * [null,0,null,1]
 * ��ʾ��
 * <p>
 * x <= 50000
 * track?��?getRankOfNumber �����ĵ��ô����������� 2000 ��
 * ͨ������749�ύ����1,252
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/rank-from-stream-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class StreamRank {

    private final ArrayList<Integer> list;

    public StreamRank() {
        list = new ArrayList<>(50000);
    }

    public void track(int x) {
        int idx = Collections.binarySearch(list, x);
        if (idx < 0) {
            idx = -idx - 1;
        }
        list.add(idx, x);
    }

    public int getRankOfNumber(int x) {
        int idx = Collections.binarySearch(list, x);
        if (idx < 0) {
            idx = -idx - 1;
        }
        while (idx < list.size() && list.get(idx) <= x) {
            ++idx;
        }
        return idx;
    }
}
