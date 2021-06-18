package code.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����һ����СΪm x n����������isWater����������һ���� ½�غ� ˮ��Ԫ����ɵĵ�ͼ��
 * <p>
 * ���isWater[i][j] == 0������(i, j)��һ�� ½�ظ��ӡ�
 * ���isWater[i][j] == 1������(i, j)��һ�� ˮ����ӡ�
 * ����Ҫ�������¹����ÿ����Ԫ���Ÿ߶ȣ�
 * <p>
 * ÿ�����ӵĸ߶ȶ������ǷǸ��ġ�
 * ���һ���������� ˮ����ô���ĸ߶ȱ���Ϊ 0��
 * �������ڵĸ��Ӹ߶Ȳ� ����Ϊ 1���������������������ϡ��������������໥�����ţ��ͳ�����Ϊ���ڵĸ��ӡ���Ҳ����˵������һ�������ߣ�
 * �ҵ�һ�ְ��Ÿ߶ȵķ�����ʹ�þ����е���߸߶�ֵ���
 * <p>
 * ���㷵��һ����СΪm x n���������� height������ height[i][j]�Ǹ��� (i, j)�ĸ߶ȡ�����ж��ֽⷨ���뷵������һ����
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺isWater = [[0,1],[0,0]]
 * �����[[1,0],[2,1]]
 * ���ͣ���ͼչʾ�˸��������Ӱ��ŵĸ߶ȡ�
 * ��ɫ������ˮ�����ɫ������½�ظ�
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺isWater = [[0,0,1],[1,0,0],[0,0,0]]
 * �����[[1,1,0],[0,1,1],[1,2,2]]
 * ���ͣ����а��ŷ����У���߿��и߶�Ϊ 2 ��
 * ���ⰲ�ŷ����У�ֻҪ��߸߶�Ϊ 2 �ҷ�����������ģ���Ϊ���з�����
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * m == isWater.length
 * n == isWater[i].length
 * 1 <= m, n <= 1000
 * isWater[i][j]Ҫô��0��Ҫô��1��
 * ������ 1��ˮ����ӡ�
 * ͨ������3,111�ύ����5,464
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/map-of-highest-peak
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class HighestPeak {

    private final int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[][] highestPeak(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visi = new boolean[row][col];
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.remove();
            ans[node[0]][node[1]] = node[2];
            for (int[] d : dir) {
                int x = node[0] + d[0];
                int y = node[1] + d[1];
                if (x >= 0 && x < row && y >= 0 && y < col && !visi[x][y] && mat[x][y] == 0) {
                    queue.add(new int[]{x, y, node[2] + 1});
                    visi[x][y] = true;
                }
            }
        }
        return ans;
    }
}
