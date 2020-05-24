package com.leetcode.offer.code;

import java.util.*;

/**
 * ���������������飬һ����һ���̣��̵�Ԫ�ؾ�����ͬ���ҵ��������а������������е�Ԫ�ص���������飬�����˳���޹ؽ�Ҫ��
 * <p>
 * ����������������˵���Ҷ˵㣬���ж�����������������飬������˵���С��һ�����������ڣ����ؿ����顣
 * <p>
 * ʾ�� 1:
 * <p>
 * ����:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * ���: [7,10]
 * ʾ�� 2:
 * <p>
 * ����:
 * big = [1,2,3]
 * small = [4]
 * ���: []
 * ��ʾ��
 * <p>
 * big.length?<= 100000
 * 1 <= small.length?<= 100000
 * ͨ������1,217�ύ����2,865
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shortest-supersequence-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ShortestSeq {

    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> goalMap = new HashMap<>(small.length);
        for (int each : small) {
            goalMap.put(each, 0);
        }
        LinkedList<Integer> containList = new LinkedList<>();
        int end = 0;
        int containNum = 0;
        List<Integer> resultList = new ArrayList<>();
        int len = Integer.MAX_VALUE;
        while (end < big.length) {
            while (containNum < small.length && end < big.length) {
                if (goalMap.containsKey(big[end])) {
                    int num = goalMap.get(big[end]);
                    if (num == 0) {
                        containNum++;
                    }
                    goalMap.put(big[end], num + 1);
                    containList.add(end);
                }
                end++;
            }
            while (!containList.isEmpty() && containNum == small.length) {
                int start = containList.pollFirst();
                int num = goalMap.get(big[start]);
                if (num == 1) {
                    containNum--;
                    if (end - start < len) {
                        resultList.clear();
                        resultList.add(start);
                        resultList.add(end - 1);
                        len = end - start;
                    }
                }
                goalMap.put(big[start], num - 1);
            }
        }
        if (resultList.size() == 0) {
            return new int[0];
        } else {
            int[] result = new int[2];
            result[0] = resultList.get(0);
            result[1] = resultList.get(1);
            return result;
        }
    }
}
