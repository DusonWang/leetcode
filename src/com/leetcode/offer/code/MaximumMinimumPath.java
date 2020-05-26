package com.leetcode.offer.code;

import java.util.PriorityQueue;

/**
 * @author duson
 * 给你一个 R 行 C 列的整数矩阵?A。矩阵上的路径从?[0,0]?开始，在?[R-1,C-1]?结束。
 * <p>
 * 路径沿四个基本方向（上、下、左、右）展开，从一个已访问单元格移动到任一相邻的未访问单元格。
 * <p>
 * 路径的得分是该路径上的 最小 值。例如，路径 8 →? 4 →? 5 →? 9 的值为 4 。
 * <p>
 * 找出所有路径中得分 最高 的那条路径，返回其?得分。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[[5,4,5],[1,2,6],[7,4,6]]
 * 输出：4
 * 解释：
 * 得分最高的路径用黄色突出显示。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[[2,2,1,2,2,2],[1,2,2,2,1,2]]
 * 输出：2
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：[[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * 输出：3
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= R, C?<= 100
 * 0 <= A[i][j] <= 10^9
 * 通过次数1,720提交次数5,669
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-with-maximum-minimum-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
