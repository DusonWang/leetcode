package code.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author duson
 * �ڶ�ά��ͼ�ϣ�?0������?1����½�أ��������ֻ�ܽ�һ��?0 ������?1���½�ء�
 * <p>
 * �����֮�󣬵�ͼ�����ĵ�������Ƕ��٣����ϡ��¡������ĸ�����������?1?���γɵ��죩
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [[1, 0], [0, 1]]
 * ���: 3
 * ����: ��һ��0���1��������ͨ����С���õ����Ϊ 3 �ĵ��졣
 * ʾ�� 2:
 * <p>
 * ����: [[1, 1], [1, 0]]
 * ���: 4
 * ����: ��һ��0���1��������������Ϊ 4��
 * ʾ�� 3:
 * <p>
 * ����: [[1, 1], [1, 1]]
 * ���: 4
 * ����: û��0���������Ǳ��1�������ȻΪ 4��
 * ˵��:
 * <p>
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 1
 * ͨ������1,912�ύ����4,780
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/making-a-large-island
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LargestIsland {

    private final int[] dr = new int[]{-1, 0, 1, 0};
    private final int[] dc = new int[]{0, -1, 0, 1};
    private int[][] grid;
    private int N;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        int index = 2;
        int[] area = new int[N * N + 2];
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] == 1) {
                    area[index] = dfs(r, c, index++);
                }
            }
        }
        int ans = 0;
        for (int x : area) {
            ans = Math.max(ans, x);
        }
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    for (Integer move : neighbors(r, c)) {
                        if (grid[move / N][move % N] > 1) {
                            seen.add(grid[move / N][move % N]);
                        }
                    }
                    int bns = 1;
                    for (int i : seen) {
                        bns += area[i];
                    }
                    ans = Math.max(ans, bns);
                }
            }
        }
        return ans;
    }

    private int dfs(int r, int c, int index) {
        int ans = 1;
        grid[r][c] = index;
        for (Integer move : neighbors(r, c)) {
            if (grid[move / N][move % N] == 1) {
                grid[move / N][move % N] = index;
                ans += dfs(move / N, move % N, index);
            }
        }

        return ans;
    }

    private List<Integer> neighbors(int r, int c) {
        List<Integer> ans = new ArrayList<>();
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                ans.add(nr * N + nc);
            }
        }
        return ans;
    }
}
