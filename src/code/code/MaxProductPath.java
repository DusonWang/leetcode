package code.code;

/**
 * ����һ����СΪ rows x cols �ľ��� grid ���������λ�����Ͻ� (0, 0) ��ÿһ����������ھ����� ���� �� ���� �ƶ���
 * <p>
 * �ڴ����Ͻ� (0, 0) ��ʼ�����½� (rows - 1, cols - 1) ����������·���У��ҳ����� ���Ǹ��� ��·����·���Ļ�����·�����ʵĵ�Ԫ�������������ĳ˻���
 * <p>
 * ���� ���Ǹ��� �� 109+ 7 ȡ�� �Ľ�����������Ϊ�������򷵻� -1 ��
 * <p>
 * ע�⣬ȡ�����ڵõ�����֮��ִ�еġ�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺grid = [[-1,-2,-3],
 * [-2,-3,-3],
 * [-3,-3,-2]]
 * �����-1
 * ���ͣ��� (0, 0) �� (2, 2) ��·�����޷��õ��Ǹ��������Է��� -1
 * ʾ�� 2��
 * <p>
 * ���룺grid = [[1,-2,1],
 * [1,-2,1],
 * [3,-4,1]]
 * �����8
 * ���ͣ����Ǹ�����Ӧ��·���Ѿ��ô����� (1 * 1 * -2 * -4 * 1 = 8)
 * ʾ�� 3��
 * <p>
 * ���룺grid = [[1, 3],
 * [0,-4]]
 * �����0
 * ���ͣ����Ǹ�����Ӧ��·���Ѿ��ô����� (1 * 0 * -4 = 0)
 * ʾ�� 4��
 * <p>
 * ���룺grid = [[ 1, 4,4,0],
 * [-2, 0,0,1],
 * [ 1,-1,1,1]]
 * �����2
 * ���ͣ����Ǹ�����Ӧ��·���Ѿ��ô����� (1 * -2 * 1 * -1 * 1 * 1 = 2)
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= rows, cols <= 15
 * -4 <= grid[i][j] <= 4
 * ͨ������3,735�ύ����12,108
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-non-negative-product-in-a-matrix
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxProductPath {

    private long result = -1;

    public int maxProductPath(int[][] grid) {
        dfs(grid, 0, 0, grid[0][0]);
        return (int) (result % 1000000007);
    }

    private void dfs(int[][] grid, int i, int j, long curr) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            result = Math.max(result, curr);
            return;
        }
        if (grid[i][j] == 0) {
            result = Math.max(result, 0);
            return;
        }
        if (i + 1 < grid.length) {
            dfs(grid, i + 1, j, curr * grid[i + 1][j]);
        }
        if (j + 1 < grid[0].length) {
            dfs(grid, i, j + 1, curr * grid[i][j + 1]);
        }
    }

}
