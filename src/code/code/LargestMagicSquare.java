package code.code;

/**
 * һ��k x k�Ļ÷�ָ����һ��k x k���������ķ�������ÿһ�С�ÿһ���Լ������Խ��ߵĺ� ȫ����ȡ��÷��е����� ����Ҫ������ͬ����Ȼ��ÿ��1 x 1�ķ�����һ���÷���
 * <p>
 * ����һ��m x n����������grid�����㷵�ؾ��������÷��ĳߴ磨���߳� k����
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
 * �����3
 * ���ͣ����÷��ߴ�Ϊ 3 ��
 * ÿһ�У�ÿһ���Լ������Խ��ߵĺͶ����� 12 ��
 * - ÿһ�еĺͣ�5+1+6 = 5+4+3 = 2+7+3 = 12
 * - ÿһ�еĺͣ�5+5+2 = 1+4+7 = 6+3+3 = 12
 * - �Խ��ߵĺͣ�5+4+3 = 6+4+2 = 12
 * ʾ�� 2��
 * <p>
 * <p>
 * ���룺grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
 * �����2
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j] <= 106
 * ͨ������1,527�ύ����2,930
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/largest-magic-square
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LargestMagicSquare {

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 1;
        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int step = result; i + step < m && j + step < n; step++) {
                    if (isMagic(grid, rowSum, colSum, i, j, step)) {
                        result = step + 1;
                    }
                }
            }
        }
        return result;
    }

    private boolean isMagic(int[][] grid, int[][] rowSum, int[][] colSum, int x1, int y1, int step) {
        int sum = 0;
        int subsum = 0;
        for (int i = 0; i <= step; i++) {
            sum += grid[x1 + i][y1 + i];
            subsum += grid[x1 + step - i][y1 + i];
        }
        if (sum != subsum) {
            return false;
        }
        for (int i = 0; i <= step; i++) {
            if (sum != rowSum[x1 + i][y1 + step + 1] - rowSum[x1 + i][y1]) {
                return false;
            }
            if (sum != colSum[x1 + step + 1][y1 + i] - colSum[x1][y1 + i]) {
                return false;
            }
        }
        return true;
    }

}
