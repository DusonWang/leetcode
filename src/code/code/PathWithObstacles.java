package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * �����и�����������һ����������Ͻǣ����� r �� c �С�������ֻ�����»������ƶ����������ߵ�һЩ����ֹ���������ϰ�������һ���㷨��Ѱ�һ����˴����Ͻ��ƶ������½ǵ�·����
 * <p>
 * <p>
 * <p>
 * �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
 * <p>
 * ����һ�����е�·����·���ɾ�����������кź��к���ɡ����Ͻ�Ϊ 0 �� 0 �С����û�п��е�·�������ؿ����顣
 * <p>
 * ʾ��?1:
 * <p>
 * ����:
 * [
 * ? [0,0,0],
 * ? [0,1,0],
 * ? [0,0,0]
 * ]
 * ���: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * ����:
 * �����б�ֵ�λ�ü�Ϊ�����ʾ��·������
 * 0��0�У����Ͻǣ� -> 0��1�� -> 0��2�� -> 1��2�� -> 2��2�У����½ǣ�
 * ˵����r?�� c ��ֵ�������� 100��
 * <p>
 * ͨ������2,616�ύ����7,748
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/robot-in-a-grid-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class PathWithObstacles {

    private int m;
    private int n;
    private int[][] grid;

    private boolean dfs(int row, int col, boolean[][] visited, List<List<Integer>> pathList) {
        if (row >= m || col >= n || grid[row][col] == 1 || visited[row][col]) {
            return false;
        }

        pathList.add(Arrays.asList(row, col));
        if (row == m - 1 && col == n - 1) {
            return true;
        }

        visited[row][col] = true;

        if (dfs(row + 1, col, visited, pathList) || dfs(row, col + 1, visited, pathList)) {
            return true;
        }

        pathList.remove(pathList.size() - 1);
        return false;
    }

    public List<List<Integer>> pathWithObstacles(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        List<List<Integer>> ansList = new ArrayList<>();
        dfs(0, 0, new boolean[m][n], ansList);
        return ansList;
    }
}
