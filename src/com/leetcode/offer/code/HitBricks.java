package com.leetcode.offer.code;

/**
 * ������һ�����1��0����������1��ʾש�顣?���ҽ���һ��שֱ�����ӵ�����Ķ�����������������һ�����ڣ�4?������֮һ��ש�鲻�����ʱ�����Ų������¡�
 * <p>
 * ���ǻ���������һЩש�顣ÿ����������?(i, j) λ��ʱ�� ��Ӧλ�õ�ש�飨�����ڣ�����ʧ��Ȼ��������ש�������Ϊ������������¡�
 * <p>
 * ����һ�������ʾÿ������������Ӧ���µ�ש����Ŀ��
 * <p>
 * ʾ�� 1��
 * ���룺
 * grid = [[1,0,0,0],[1,1,1,0]]
 * hits = [[1,0]]
 * ���: [2]
 * ����:
 * �����������(1, 0)λ�õ�ש��, ��(1, 1) ��(1, 2) ��ש������¡���������Ӧ�÷���2��
 * ʾ�� 2��
 * ���룺
 * grid = [[1,0,0,0],[1,1,0,0]]
 * hits = [[1,1],[1,0]]
 * �����[0,0]
 * ���ͣ�
 * ����������(1, 0)��ש��ʱ��(1, 1)��ש���Ѿ�������һ����������ʧ�ˡ�����ÿ�����������������ש�����¡�ע��(1, 0)ש�鲻��������µ�ש�顣
 * ע��:
 * <p>
 * ����������������ķ�Χ��[1, 200]��
 * ���������ֲ��ᳬ�����������
 * ���Ա�֤ÿ�ε�����������ͬ������λ��������ڲ���
 * һ��������λ�ÿ���û��ש�飬��������Ļ����Ͳ�����ש�����¡�
 * ͨ������781�ύ����3,134
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/bricks-falling-when-hit
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author duson
 */
public class HitBricks {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) {
                grid[hit[0]][hit[1]] = -1;
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            connect(grid, 0, j);
        }
        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int row = hits[i][0];
            int col = hits[i][1];
            if (grid[row][col] == -1) {
                grid[row][col] = 1;
                if (connectedToTop(grid, row, col)) {
                    res[i] = connect(grid, row, col) - 1;
                }
            }
        }
        return res;
    }

    private boolean connectedToTop(int[][] grid, int i, int j) {
        if (i == 0) {
            return true;
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 2) {
            return true;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 2) {
            return true;
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 2) {
            return true;
        }
        return j + 1 < grid[0].length && grid[i][j + 1] == 2;
    }

    private int connect(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        int res = 1;
        res += connect(grid, i - 1, j);
        res += connect(grid, i + 1, j);
        res += connect(grid, i, j + 1);
        res += connect(grid, i, j - 1);
        return res;
    }
}
