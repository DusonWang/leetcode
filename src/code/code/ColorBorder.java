package code.code;

/**
 * ����һ����ά��������grid�������е�ÿ��ֵ��ʾ��λ�ô�����������ɫ��
 * <p>
 * ֻ�е�������������ɫ��ͬ���������ĸ�����������һ������������ʱ����������ͬһ��ͨ������
 * <p>
 * ��ͨ�����ı߽���ָ��ͨ�����е������벻�ڷ����е����������ڣ��ĸ������ϣ������������Σ�����������ı߽��ϣ���һ��/�л����һ��/�У������������Ρ�
 * <p>
 * ����λ��(r0, c0)����������ɫcolor��ʹ��ָ����ɫcolorΪ������������ͨ�����ı߽������ɫ�����������յ�����grid ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * �����[[3, 3], [3, 2]]
 * ʾ�� 2��
 * <p>
 * ���룺grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * �����[[1, 3, 3], [2, 3, 3]]
 * ʾ�� 3��
 * <p>
 * ���룺grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * �����[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= grid.length <= 50
 * 1 <= grid[0].length <= 50
 * 1 <= grid[i][j] <= 1000
 * 0 <= r0 < grid.length
 * 0 <= c0 < grid[0].length
 * 1 <= color <= 1000
 * <p>
 * <p>
 * ͨ������3,719�ύ����8,689
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/coloring-a-border
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ColorBorder {

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid == null || grid.length == 0) {
            return grid;
        }
        int oldColor = grid[r0][c0];
        dfs(grid, r0, c0, oldColor);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private void dfs(int[][] grid, int i, int j, int oldColor) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != oldColor) {
            return;
        }
        grid[i][j] = -oldColor;
        dfs(grid, i + 1, j, oldColor);
        dfs(grid, i - 1, j, oldColor);
        dfs(grid, i, j + 1, oldColor);
        dfs(grid, i, j - 1, oldColor);
        if (i > 0 && j > 0
                && i < grid.length - 1
                && j < grid[0].length - 1
                && oldColor == Math.abs(grid[i + 1][j])
                && oldColor == Math.abs(grid[i - 1][j])
                && oldColor == Math.abs(grid[i][j + 1])
                && oldColor == Math.abs(grid[i][j - 1])) {
            grid[i][j] = oldColor;
        }
    }

}
