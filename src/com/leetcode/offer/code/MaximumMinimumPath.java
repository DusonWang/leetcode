package com.leetcode.offer.code;

import java.util.PriorityQueue;

/**
 * @author duson
 * ����һ�� R �� C �е���������?A�������ϵ�·����?[0,0]?��ʼ����?[R-1,C-1]?������
 * <p>
 * ·�����ĸ����������ϡ��¡����ң�չ������һ���ѷ��ʵ�Ԫ���ƶ�����һ���ڵ�δ���ʵ�Ԫ��
 * <p>
 * ·���ĵ÷��Ǹ�·���ϵ� ��С ֵ�����磬·�� 8 ��? 4 ��? 5 ��? 9 ��ֵΪ 4 ��
 * <p>
 * �ҳ�����·���е÷� ��� ������·����������?�÷֡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺[[5,4,5],[1,2,6],[7,4,6]]
 * �����4
 * ���ͣ�
 * �÷���ߵ�·���û�ɫͻ����ʾ��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺[[2,2,1,2,2,2],[1,2,2,2,1,2]]
 * �����2
 * ʾ�� 3��
 * <p>
 * <p>
 * <p>
 * ���룺[[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * �����3
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= R, C?<= 100
 * 0 <= A[i][j] <= 10^9
 * ͨ������1,720�ύ����5,669
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/path-with-maximum-minimum-value
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaximumMinimumPath {

    public int maximumMinimumPath(int[][] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (a.length == 1 && a[0].length == 1) {
            return 1;
        }
        PriorityQueue<Point> qu = new PriorityQueue<>();
        boolean[][] visit = new boolean[a.length][a[0].length];
        Point startPoint = new Point(0, 0, a[0][0], a[0][0]);
        qu.add(startPoint);
        visit[0][0] = true;
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int row = a.length;
        int col = a[0].length;

        while (!qu.isEmpty()) {
            Point tempPoint = qu.poll();
            if (tempPoint.x == row - 1 && tempPoint.y == col - 1) {
                return tempPoint.minPath;
            }
            for (int[] ints : direction) {
                int newX = tempPoint.x + ints[0];
                int newY = tempPoint.y + ints[1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visit[newX][newY]) {
                    int minPath = Math.min(tempPoint.minPath, a[newX][newY]);
                    qu.add(new Point(newX, newY, a[newX][newY], minPath));
                    visit[newX][newY] = true;
                }
            }
        }
        return -1;
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    int val;
    int minPath;

    public Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    public Point(int x, int y, int val, int minPath) {
        this.x = x;
        this.y = y;
        this.val = val;
        this.minPath = minPath;
    }

    @Override
    public int compareTo(Point o) {
        return o.minPath - this.minPath;
    }
}
