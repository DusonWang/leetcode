package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * ������ xy ƽ���ϵ�һ��㣬ȷ������Щ����ɵ��κξ��ε���С��������о��εı߲�һ��ƽ���� x ��� y �ᡣ
 * <p>
 * ���û���κξ��Σ��ͷ��� 0��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺[[1,2],[2,1],[1,0],[0,1]]
 * �����2.00000
 * ���ͣ���С����ľ��γ����� [1,2],[2,1],[1,0],[0,1] �������Ϊ 2��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺[[0,1],[2,1],[1,1],[1,0],[2,0]]
 * �����1.00000
 * ���ͣ���С����ľ��γ����� [1,0],[1,1],[2,1],[2,0] �������Ϊ 1��
 * ʾ�� 3��
 * <p>
 * <p>
 * <p>
 * ���룺[[0,3],[1,2],[3,1],[1,3],[2,1]]
 * �����0
 * ���ͣ�û������Щ��������κξ��Ρ�
 * ʾ�� 4��
 * <p>
 * <p>
 * <p>
 * ���룺[[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
 * �����2.00000
 * ���ͣ���С����ľ��γ����� [2,1],[2,3],[3,3],[3,1] �������Ϊ 2��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= points.length <= 50
 * 0 <=?points[i][0] <=?40000
 * 0 <=?points[i][1] <=?40000
 * ���еĵ㶼�ǲ�ͬ�ġ�
 * ����ʵֵ������ 10^-5?�Ĵ𰸽���Ϊ��ȷ�����
 * ͨ������1,396�ύ����2,946
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-area-rectangle-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinAreaFreeRect {

    public double minAreaFreeRect(int[][] p) {
        Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                double x = (p[i][0] + p[j][0]) / 2.0;
                double y = (p[i][1] + p[j][1]) / 2.0;
                String key = x + "," + y + "," + getDist(p, i, j);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(new int[]{i, j});
            }
        }
        double res = Double.MAX_VALUE;
        for (List<int[]> l : map.values()) {
            for (int i = 0; i < l.size(); i++) {
                for (int j = i + 1; j < l.size(); j++) {
                    res = Math.min(res, getArea(p, l.get(i), l.get(j)));
                }
            }
        }
        return res == Double.MAX_VALUE ? 0 : res;
    }

    private int getDist(int[][] p, int i, int j) {
        return (p[i][0] - p[j][0]) * (p[i][0] - p[j][0]) + (p[i][1] - p[j][1]) * (p[i][1] - p[j][1]);
    }

    private double getArea(int[][] p, int[] a, int[] b) {
        int dis1 = getDist(p, a[0], b[0]);
        int dis2 = getDist(p, a[0], b[1]);
        return Math.sqrt(dis1) * Math.sqrt(dis2);
    }
}
