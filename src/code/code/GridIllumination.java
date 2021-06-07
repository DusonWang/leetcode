package code.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * ��N x N������ grid �ϣ�ÿ����Ԫ����һյ�ƣ�����ƶ����� �ر� ״̬��
 * <p>
 * ����lamps ��ʾ�򿪵ĵƵ�λ�á�lamps[i] = [rowi, coli] ��ʾ �� λ�� grid[rowi][coli] �ĵ� i յ�� ��ÿյ�ƶ���������Ԫ���Լ�ͬһ�С�ͬһ�к������Խ����ϵ�����������Ԫ��
 * <p>
 * ��ѯ���� queries �У��� i �β�ѯqueries[i] = [rowi, coli]�������Ԫ�� [rowi, coli] �Ǳ������ģ����ѯ���Ϊ 1 ������Ϊ 0 ���ڵ� i �β�ѯ֮�� [���ղ�ѯ��˳��] ���ر� λ�ڵ�Ԫ�� grid[rowi][coli] �ϻ������� 8 �������ϣ��뵥Ԫ�� grid[rowi][coli] ����ǻ�ߣ����κεơ�
 * <p>
 * ���ش����� ans �� answer[i] Ӧ���ڵ� i�β�ѯqueries[i]�Ľ����1 ��ʾ������0 ��ʾδ������
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
 * �����[1,0]
 * ���ͣ�������еƶ��ǹرյġ���ִ�в�ѯ֮ǰ����λ�� [0, 0] �� [4, 4] �ĵơ��� 0�β�ѯ��� grid[1][1] �Ƿ���������ɫ���򣩡��õ�Ԫ������������ ans[0] = 1 ��Ȼ�󣬹رպ�ɫ�����е����еơ�
 * <p>
 * �� 1�β�ѯ��� grid[1][0] �Ƿ���������ɫ���򣩡��õ�Ԫ��û�б����������� ans[1] = 0 ��Ȼ�󣬹رպ�ɫ�����е����еơ�
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
 * �����[1,1]
 * ʾ�� 3��
 * <p>
 * ���룺N = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
 * �����[1,1,0]
 *
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= N <= 109
 * 0 <= lamps.length <= 20000
 * lamps[i].length == 2
 * 0 <= lamps[i][j] < N
 * 0 <= queries.length <= 20000
 * queries[i].length == 2
 * 0 <= queries[i][j] < N
 * ͨ������1,925�ύ����6,609
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/grid-illumination
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GridIllumination {

    private final int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    private final int[] dy = {1, 0, -1, 1, 0, -1, 1, 0, -1};

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        HashMap<Integer, Integer> d = new HashMap<>();
        HashMap<Integer, Integer> ud = new HashMap<>();
        Set<Long> set = new HashSet<>();
        for (int[] l : lamps) {
            if (set.contains(((long) N * l[0]) + l[1])) {
                continue;
            }
            row.put(l[0], row.getOrDefault(l[0], 0) + 1);
            col.put(l[1], col.getOrDefault(l[1], 0) + 1);
            d.put(l[0] - l[1], d.getOrDefault(l[0] - l[1], 0) + 1);
            ud.put(l[0] + l[1], ud.getOrDefault(l[0] + l[1], 0) + 1);
            set.add((long) N * l[0] + l[1]);
        }
        int len = queries.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int[] cur = queries[i];
            if (row.getOrDefault(cur[0], 0) > 0
                    || col.getOrDefault(cur[1], 0) > 0
                    || d.getOrDefault(cur[0] - cur[1], 0) > 0
                    || ud.getOrDefault(cur[0] + cur[1], 0) > 0) {
                res[i] = 1;
            }
            for (int j = 0; j < 9; j++) {
                int tx = dx[j] + cur[0];
                int ty = dy[j] + cur[1];
                if (tx < 0 || tx >= N || ty < 0 || ty >= N) {
                    continue;
                }
                if (set.contains((long) tx * N + ty)) {
                    set.remove((long) tx * N + ty);
                    row.put(tx, row.get(tx) - 1);
                    col.put(ty, col.get(ty) - 1);
                    d.put(tx - ty, d.get(tx - ty) - 1);
                    ud.put(tx + ty, ud.get(tx + ty) - 1);
                }
            }
        }
        return res;
    }
}
