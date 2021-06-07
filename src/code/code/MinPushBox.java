package code.code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * �������ӡ���һ�����ȫ�������С��Ϸ�������Ҫ�������Ƶ��ֿ��е�Ŀ��λ�á�
 * <p>
 * ��Ϸ��ͼ�ô�СΪ n * m ������ grid ��ʾ������ÿ��Ԫ�ؿ�����ǽ���ذ���������ӡ�
 * <p>
 * �����㽫��Ϊ��Ҳ�����Ϸ������������'B'�ƶ���Ŀ��λ��'T' ��
 * <p>
 * ������ַ�'S'��ʾ��ֻҪ���ڵذ��ϣ��Ϳ��������������ϡ��¡������ĸ������ƶ���
 * �ذ����ַ�'.'��ʾ����ζ�ſ����������ߡ�
 * ǽ���ַ�'#'��ʾ����ζ���ϰ������ͨ�С�
 * ���ӽ���һ�������ַ�'B'��ʾ����Ӧ�أ���������һ��Ŀ��λ��'T'��
 * �����Ҫվ�������Աߣ�Ȼ���������ӵķ�������ƶ�����ʱ���ӻᱻ�ƶ������ڵĵذ嵥Ԫ�񡣼���һ�Ρ��ƶ�����
 * ����޷�Խ�����ӡ�
 * ���ؽ������Ƶ�Ŀ��λ�õ���С �ƶ� ����������޷��������뷵��-1��
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺grid = [["#","#","#","#","#","#"],
 * ["#","T","#","#","#","#"],
 * ["#",".",".","B",".","#"],
 * ["#",".","#","#",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * �����3
 * ���ͣ�����ֻ��Ҫ���������ӵĴ�����
 * ʾ�� 2��
 * <p>
 * ���룺grid = [["#","#","#","#","#","#"],
 * ["#","T","#","#","#","#"],
 * ["#",".",".","B",".","#"],
 * ["#","#","#","#",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * �����-1
 * ʾ�� 3��
 * <p>
 * ���룺grid = [["#","#","#","#","#","#"],
 * ["#","T",".",".","#","#"],
 * ["#",".","#","B",".","#"],
 * ["#",".",".",".",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * �����5
 * ���ͣ����¡������������������ϡ�
 * ʾ�� 4��
 * <p>
 * ���룺grid = [["#","#","#","#","#","#","#"],
 * ["#","S","#",".","B","T","#"],
 * ["#","#","#","#","#","#","#"]]
 * �����-1
 *
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= grid.length <= 20
 * 1 <= grid[i].length <= 20
 * grid �������ַ�'.', '#', 'S' , 'T', �Լ�'B'��
 * grid��'S', 'B'��'T'��ֻ�ܳ���һ����
 * ͨ������2,670�ύ����6,438
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-moves-to-move-a-box-to-their-target-location hard
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinPushBox {

    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int row;
    private int col;
    private char[][] grid;
    private boolean[][] searchSign;

    private boolean isReachable(int srcx, int srcy, int dstx, int dsty) {
        if (dstx < 0 || dstx >= row || dsty < 0 || dsty >= col || grid[dstx][dsty] == '#') {
            return false;
        }
        for (boolean[] line : searchSign) {
            Arrays.fill(line, false);
        }
        searchSign[srcx][srcy] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{srcx, srcy});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == dstx && cur[1] == dsty) {
                return true;
            }
            for (int[] dir : dirs) {
                int ni = cur[0] + dir[0];
                int nj = cur[1] + dir[1];
                if (ni < 0 || ni >= row || nj < 0 || nj >= col || searchSign[ni][nj] || grid[ni][nj] == '#' || grid[ni][nj] == 'B') {
                    continue;
                }
                searchSign[ni][nj] = true;
                queue.offer(new int[]{ni, nj});
            }
        }
        return false;
    }

    public int minPushBox(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        this.grid = grid;
        searchSign = new boolean[row][col];
        int[] starter = new int[4];
        int[] end = new int[2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'S') {
                    starter[2] = i;
                    starter[3] = j;
                } else if (grid[i][j] == 'B') {
                    starter[0] = i;
                    starter[1] = j;
                } else if (grid[i][j] == 'T') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(starter);
        boolean[][] visited = new boolean[row * col][row * col];
        visited[starter[0] * col + starter[1]][starter[2] * col + starter[3]] = true;
        int stride = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                count--;
                int[] cur = queue.poll();
                if (cur[0] == end[0] && cur[1] == end[1]) {
                    return stride;
                }
                grid[cur[0]][cur[1]] = 'B';
                grid[cur[2]][cur[3]] = 'S';
                for (int[] dir : dirs) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if (ni < 0 || ni >= row || nj < 0 || nj >= col || visited[ni * col + nj][cur[0] * col + cur[1]] || grid[ni][nj] == '#') {
                        continue;
                    }
                    if (!isReachable(cur[2], cur[3], cur[0] - dir[0], cur[1] - dir[1])) {
                        continue;
                    }
                    visited[ni * col + nj][cur[0] * col + cur[1]] = true;
                    queue.offer(new int[]{ni, nj, cur[0], cur[1]});
                }
                grid[cur[0]][cur[1]] = '.';
                grid[cur[2]][cur[3]] = '.';
            }
            stride++;
        }
        return -1;
    }
}
