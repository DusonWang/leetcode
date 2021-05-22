package code.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * ��׼���μ�һ��Զ��������һ����ά?rows x columns?�ĵ�ͼ?heights?������?heights[row][col]?��ʾ����?(row, col)?�ĸ߶ȡ�һ��ʼ���������Ͻǵĸ���?(0, 0)?������ϣ��ȥ�����½ǵĸ���?(rows-1, columns-1)?��ע���±�� 0 ��ʼ��ţ�����ÿ�ο����� �ϣ��£�����?�ĸ�����֮һ�ƶ�������Ҫ�ҵ��ķ� ���� ��С��һ��·����
 * <p>
 * һ��·���ķѵ� ����ֵ?��·�������ڸ���֮�� �߶Ȳ����ֵ?�� ���ֵ?�����ġ�
 * <p>
 * ���㷵�ش����Ͻ��ߵ����½ǵ���С?��������ֵ?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺heights = [[1,2,2],[3,8,2],[5,3,5]]
 * �����2
 * ���ͣ�·�� [1,3,5,3,5] �������ӵĲ�ֵ����ֵ���Ϊ 2 ��
 * ����·����·�� [1,2,2,2,5] ���ţ���Ϊ��һ��·����ֵ���ֵΪ 3 ��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺heights = [[1,2,3],[3,8,4],[5,3,5]]
 * �����1
 * ���ͣ�·�� [1,2,3,4,5] �����ڸ��Ӳ�ֵ����ֵ���Ϊ 1 ����·�� [1,3,5,3,5] ���š�
 * ʾ�� 3��
 * <p>
 * <p>
 * ���룺heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * �����0
 * ���ͣ���ͼ��ʾ·������Ҫ�����κ�������
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * ͨ������22,508�ύ����45,641
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/path-with-minimum-effort
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinimumEffortPath {

    private int[][] heights;
    private int m;
    private int n;
    private boolean[][] visited;

    public int minimumEffortPath(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        int left = 0;
        int right = 1000000;
        while (left < right) {
            int middle = (left + right) >>> 1;
            visited = new boolean[m][n];
            if (hasPath(0, 0, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    private boolean hasPath(int i, int j, int cost) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        visited[i][j] = true;
        if (i + 1 < m && !visited[i + 1][j] && Math.abs(heights[i][j] - heights[i + 1][j]) <= cost && hasPath(i + 1, j, cost)) {
            return true;
        }
        if (j + 1 < n && !visited[i][j + 1] && Math.abs(heights[i][j] - heights[i][j + 1]) <= cost && hasPath(i, j + 1, cost)) {
            return true;
        }
        if (i - 1 >= 0 && !visited[i - 1][j] && Math.abs(heights[i][j] - heights[i - 1][j]) <= cost && hasPath(i - 1, j, cost)) {
            return true;
        }
        return j - 1 >= 0 && !visited[i][j - 1] && Math.abs(heights[i][j] - heights[i][j - 1]) <= cost && hasPath(i, j - 1, cost);
    }
}
