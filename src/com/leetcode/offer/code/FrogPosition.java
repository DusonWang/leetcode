package com.leetcode.offer.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���� n ��������ɵ��������������Ŵ� 1 �� n�����ܴ� ���� 1 ��ʼ�������������£�
 * <p>
 * ��һ���ڣ����ܴ������ڵĵ�ǰ����������һ�� δ���� ���Ķ��㣨�������ֱ����������
 * �����޷������Ѿ����ʹ��Ķ��㡣
 * ������ܿ������������ͬ���㣬��ô��������������һ�������ϵĻ��ʶ���ͬ��
 * ������ܲ��������κ�δ���ʹ��Ķ����ϣ���ô��ÿ����Ծ����ͣ����ԭ�ء�
 * �������ı������� edges ���������� edges[i] = [fromi, toi] ��ζ�Ŵ���һ��ֱ����ͨ fromi �� toi ��������ıߡ�
 * <p>
 * ���������� t ���λ��Ŀ�궥�� target �ϵĸ��ʡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
 * �����0.16666666666666666
 * ���ͣ���ͼ��ʾ�����ܵ���Ծ·�������ܴӶ��� 1 �������� 1 �� �� 1/3 �ĸ����������� 2 ��Ȼ��� 2 �� �� 1/2 �ĸ����������� 4����������� 2 ���λ�ڶ��� 4 �ĸ����� 1/3 * 1/2 = 1/6 = 0.16666666666666666 ��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
 * �����0.3333333333333333
 * ���ͣ���ͼ��ʾ�����ܵ���Ծ·�������ܴӶ��� 1 �������� 1/3 = 0.3333333333333333 �ĸ����ܹ� 1 �� ���������� 7 ��
 * ʾ�� 3��
 * <p>
 * ���룺n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 20, target = 6
 * �����0.16666666666666666
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 100
 * edges.length == n-1
 * edges[i].length == 2
 * 1 <= edges[i][0], edges[i][1] <= n
 * 1 <= t?<= 50
 * 1 <= target?<= n
 * ��׼ȷֵ����� 10^-5 ֮�ڵĽ�������ж�Ϊ��ȷ��
 * ͨ������2,307�ύ����7,943
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/frog-position-after-t-seconds
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FrogPosition {

    public double frogPosition(int n, int[][] edges, int t, int target) {
        int initalTarget = target;
        Map<Integer, Integer> hm = new HashMap<>();
        Map<Integer, Integer> sizeMap = new HashMap<>();
        for (int[] ar : edges) {
            int parent = Math.min(ar[0], ar[1]);
            int child = Math.max(ar[0], ar[1]);
            hm.put(child, parent);
            sizeMap.putIfAbsent(parent, 0);
            sizeMap.put(parent, sizeMap.get(parent) + 1);
        }
        double prob = 1d * sizeMap.getOrDefault(1, 1);
        while (hm.containsKey(target) && t > 0) {
            prob *= sizeMap.getOrDefault(target, 1);
            target = hm.get(target);
            t--;
        }
        if (target == 1 && (t == 0 || !sizeMap.containsKey(initalTarget))) {
            return 1 / prob;
        }
        return 0d;
    }
}
