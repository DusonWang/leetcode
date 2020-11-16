package code.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duson
 * ����һ�� m x n ������ grid���������ÿ����Ԫ������һ���ֵ���grid[i][j] �Ľֵ������ǣ�
 * <p>
 * 1 ��ʾ������Ԫ����ҵ�Ԫ��Ľֵ���
 * 2 ��ʾ�����ϵ�Ԫ����µ�Ԫ��Ľֵ���
 * 3?��ʾ������Ԫ����µ�Ԫ��Ľֵ���
 * 4 ��ʾ�����ҵ�Ԫ����µ�Ԫ��Ľֵ���
 * 5 ��ʾ������Ԫ����ϵ�Ԫ��Ľֵ���
 * 6 ��ʾ�����ҵ�Ԫ����ϵ�Ԫ��Ľֵ���
 * <p>
 * <p>
 * ���ʼ�����Ͻǵĵ�Ԫ�� (0,0) ��ʼ�����������еġ���Ч·������ָ�����Ϸ��ĵ�Ԫ�� (0,0) ��ʼ��һֱ�����·��� (m-1,n-1) ������·������·������ֻ���Žֵ��ߡ�
 * <p>
 * ע�⣺�� ���� ����ֵ���
 * <p>
 * ��������д�����Ч��·�����򷵻� true�����򷵻� false ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺grid = [[2,4,3],[6,5,2]]
 * �����true
 * ���ͣ���ͼ��ʾ������Դ� (0, 0) ��ʼ�����������е����е�Ԫ�񲢵��� (m - 1, n - 1) ��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺grid = [[1,2,1],[1,2,1]]
 * �����false
 * ���ͣ���ͼ��ʾ����Ԫ�� (0, 0) �ϵĽֵ�û�����κ�������Ԫ���ϵĽֵ���������ֻ��ͣ�� (0, 0) ����
 * ʾ�� 3��
 * <p>
 * ���룺grid = [[1,1,2]]
 * �����false
 * ���ͣ����ͣ�� (0, 1)�������޷����� (0, 2) ��
 * ʾ�� 4��
 * <p>
 * ���룺grid = [[1,1,1,1,1,1,3]]
 * �����true
 * ʾ�� 5��
 * <p>
 * ���룺grid = [[2],[2],[2],[2],[2],[2],[6]]
 * �����true
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * 1 <= grid[i][j] <= 6
 * ͨ������2,969�ύ����7,675
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class HasValidPath {

    private final int[][] dirs = {{0, 1, 1, 3, 5}, {1, 0, 2, 5, 6}, {0, -1, 1, 4, 6}, {-1, 0, 2, 3, 4}};
    private final int[][] cs = {{}, {0, 2}, {1, 3}, {1, 2}, {0, 1}, {2, 3}, {0, 3}};

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] reach = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                return true;
            }
            int[] rds = cs[grid[cur[0]][cur[1]]];
            for (int rd : rds) {
                int[] d = dirs[rd];
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if (x >= m || x < 0 || y >= n || y < 0 || reach[x][y]) {
                    continue;
                }
                if (grid[x][y] == d[2] || grid[x][y] == d[3] || grid[x][y] == d[4]) {
                    queue.add(new int[]{x, y, 1});
                    reach[x][y] = true;
                }
            }
        }
        return false;
    }
}
