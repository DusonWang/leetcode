package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * ��һ������ͼ�У��ڵ�ֱ���Ϊ?0, 1, ..., n-1�����ͼ�е�ÿ���߲��Ǻ�ɫ������ɫ���Ҵ����Ի���ƽ�бߡ�
 * <p>
 * red_edges?�е�ÿһ��?[i, j]?�Ա�ʾ�ӽڵ� i ���ڵ� j �ĺ�ɫ����ߡ����Ƶأ�blue_edges?�е�ÿһ��?[i, j]?�Ա�ʾ�ӽڵ� i ���ڵ� j ����ɫ����ߡ�
 * <p>
 * ���س���Ϊ n ������?answer������?answer[X]?�Ǵӽڵ�?0?���ڵ�?X?�����·���ĳ��ȣ���·���Ϻ�ɫ�ߺ���ɫ�߽�����֡����������������·������ô answer[x] = -1��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * �����[0,1,-1]
 * ʾ�� 2��
 * <p>
 * ���룺n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * �����[0,1,-1]
 * ʾ�� 3��
 * <p>
 * ���룺n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * �����[0,-1,-1]
 * ʾ�� 4��
 * <p>
 * ���룺n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * �����[0,1,2]
 * ʾ�� 5��
 * <p>
 * ���룺n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * �����[0,1,1]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 * ͨ������2,996�ύ����8,883
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shortest-path-with-alternating-colors
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ShortestAlternatingPaths {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> rg = new ArrayList<>();
        List<List<Integer>> bg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rg.add(new ArrayList<>());
            bg.add(new ArrayList<>());
        }
        for (int[] red : redEdges) {
            rg.get(red[0]).add(red[1]);
        }
        for (int[] blue : blueEdges) {
            bg.get(blue[0]).add(blue[1]);
        }
        int[][] ans = new int[n][2];
        for (int[] ansColor : ans) {
            ansColor[0] = Integer.MAX_VALUE;
            ansColor[1] = Integer.MAX_VALUE;
        }
        ans[0][0] = 0;
        ans[0][1] = 0;
        dfs(ans, 0, 0, rg, bg);
        dfs(ans, 1, 0, rg, bg);
        int[] finalAns = new int[n];
        for (int i = 0; i < n; i++) {
            finalAns[i] = Math.min(ans[i][0], ans[i][1]);
            if (finalAns[i] == Integer.MAX_VALUE) {
                finalAns[i] = -1;
            }
        }
        return finalAns;
    }

    private void dfs(int[][] ans, int color, int i, List<List<Integer>> rg, List<List<Integer>> bg) {
        List<List<Integer>> g = color == 0 ? rg : bg;
        for (int j : g.get(i)) {
            if (ans[i][color] + 1 < ans[j][Math.abs(color - 1)]) {
                ans[j][Math.abs(color - 1)] = ans[i][color] + 1;
                dfs(ans, Math.abs(color - 1), j, rg, bg);
            }
        }
    }
}
