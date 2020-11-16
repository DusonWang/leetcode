package code.code;

/**
 * @author duson
 * ��һ�� m*n �����̵�ÿһ�񶼷���һ�����ÿ�����ﶼ��һ���ļ�ֵ����ֵ���� 0��������Դ����̵����Ͻǿ�ʼ�ø�����������ÿ�����һ��������ƶ�һ��ֱ���������̵����½ǡ�����һ�����̼������������ļ�ֵ���������������õ����ټ�ֵ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1:
 * <p>
 * ����:
 * [
 * ? [1,3,1],
 * ? [1,5,1],
 * ? [4,2,1]
 * ]
 * ���: 12
 * ����: ·�� 1��3��5��2��1 �����õ�����ֵ������
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * ͨ������13,859�ύ����20,565
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxValue {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
