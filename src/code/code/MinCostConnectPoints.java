package code.code;

import java.util.*;

/**
 * ����һ��points?���飬��ʾ 2D ƽ���ϵ�һЩ�㣬����?points[i] = [xi, yi]?��
 * <p>
 * ���ӵ�?[xi, yi] �͵�?[xj, yj]?�ķ���Ϊ����֮��� �����پ���?��|xi - xj| + |yi - yj|?������?|val|?��ʾ?val?�ľ���ֵ��
 * <p>
 * ���㷵�ؽ����е����ӵ���С�ܷ��á�ֻ����������֮�� ���ҽ���?һ����·��ʱ������Ϊ���е㶼�����ӡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * �����20
 * ���ͣ�
 * <p>
 * ���ǿ��԰�����ͼ��ʾ�������е�õ���С�ܷ��ã��ܷ���Ϊ 20 ��
 * ע�⵽����������֮��ֻ��Ψһһ��·�����ൽ�
 * ʾ�� 2��
 * <p>
 * ���룺points = [[3,12],[-2,5],[-4,1]]
 * �����18
 * ʾ�� 3��
 * <p>
 * ���룺points = [[0,0],[1,1],[1,0],[-1,1]]
 * �����4
 * ʾ�� 4��
 * <p>
 * ���룺points = [[-1000000,-1000000],[1000000,1000000]]
 * �����4000000
 * ʾ�� 5��
 * <p>
 * ���룺points = [[0,0]]
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= points.length <= 1000
 * -106?<= xi, yi <= 106
 * ���е�?(xi, yi)?������ͬ��
 * ͨ������22,549�ύ����33,805
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinCostConnectPoints {

    public int minCostConnectPoints(int[][] points) {
        int vertexes = points.length;
        if (vertexes < 2) return 0;
        int checkPoint = 0;
        int cost = 0;
        int[] lowCost = new int[vertexes];
        Arrays.fill(lowCost, Integer.MAX_VALUE);
        lowCost[0] = 0;
        for (int i = 0; i < vertexes - 1; i++) {
            int minDist = Integer.MAX_VALUE;
            int temp = checkPoint;
            for (int v = 0; v < vertexes; v++) {
                if (lowCost[v] > 0) {
                    lowCost[v] = Math.min(lowCost[v], dis(points, v, checkPoint));
                    if (lowCost[v] < minDist) {
                        minDist = lowCost[v];
                        temp = v;
                    }
                }
            }
            checkPoint = temp;
            lowCost[checkPoint] = 0;
            cost += minDist;
        }
        return cost;
    }

    private int dis(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
}
