package code.code;

/**
 * @author duson
 * ����һ��?m * n?����������ÿ����Ԫ����?0���գ�����?1���ϰ����ÿһ�������������ڿհ׵�Ԫ�����ϡ��¡������ƶ���
 * <p>
 * ����� ��� �������� k ���ϰ�����ҳ������Ͻ� (0, 0) �����½� (m-1, n-1) �����·����������ͨ����·������Ĳ���������Ҳ���������·�����򷵻� -1��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺
 * grid =
 * [[0,0,0],
 * ?[1,1,0],
 * [0,0,0],
 * ?[0,1,1],
 * [0,0,0]],
 * k = 1
 * �����6
 * ���ͣ�
 * �������κ��ϰ������·���� 10��
 * ����λ�� (3,2) �����ϰ������·���� 6 ����·���� (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * ?
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺
 * grid =
 * [[0,1,1],
 * ?[1,1,1],
 * ?[1,0,0]],
 * k = 1
 * �����-1
 * ���ͣ�
 * ����������Ҫ���������ϰ������ҵ�������·����
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * grid.length?== m
 * grid[0].length?== n
 * 1 <= m, n <= 40
 * 1 <= k <= m*n
 * grid[i][j] == 0 or 1
 * grid[0][0] == grid[m-1][n-1] == 0
 * ͨ������4,618�ύ����12,915
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shortest-path-in-a-grid-with-obstacles-elimination
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ShortestPath {

    private int res = Integer.MAX_VALUE;

    public int shortestPath(int[][] grid, int k) {
        dfs(grid, 0, 0, k, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int[][] grid, int x, int y, int k, int step) {
        if (k < 0) {
            return;
        }
        if (res == grid.length - 1 + grid[0].length - 1) {
            return;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            res = Math.min(res, step);
            return;
        }
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 2) {
            if (grid[x][y] == 1) {
                grid[x][y] = 2;
                dfs(grid, x + 1, y, k - 1, step + 1);
                dfs(grid, x, y + 1, k - 1, step + 1);
                dfs(grid, x - 1, y, k - 1, step + 1);
                dfs(grid, x, y - 1, k - 1, step + 1);
                grid[x][y] = 1;
            } else if (grid[x][y] == 0) {
                grid[x][y] = 2;
                dfs(grid, x + 1, y, k, step + 1);
                dfs(grid, x, y + 1, k, step + 1);
                dfs(grid, x - 1, y, k, step + 1);
                dfs(grid, x, y - 1, k, step + 1);
                grid[x][y] = 0;
            }
        }
    }
}
