package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * ����һ��?N?�ˣ����Ϊ?1, 2, ..., N����?�������ÿ���˷ֽ������С�����顣
 * <p>
 * ÿ���˶����ܲ�ϲ�������ˣ���ô���ǲ�Ӧ������ͬһ�顣
 * <p>
 * ��ʽ�ϣ���� dislikes[i] = [a, b]����ʾ���������Ϊ a �� b ���˹���ͬһ�顣
 * <p>
 * �����������ַ�����ÿ���˷ֽ�����ʱ������ true�����򷵻� false��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * �����true
 * ���ͣ�group1 [1,4], group2 [2,3]
 * ʾ�� 2��
 * <p>
 * ���룺N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * �����false
 * ʾ�� 3��
 * <p>
 * ���룺N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * �����false
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * ����?dislikes[i] == dislikes[j]?������?i != j?
 * ͨ������2,193�ύ����6,082
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/possible-bipartition
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            g[d[0]].add(d[1]);
            g[d[1]].add(d[0]);
        }
        int[] cl = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (cl[i] == 0 && !dfs(g, cl, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<Integer>[] g, int[] cl, int i, int c) {
        cl[i] = c;
        for (int j : g[i]) {
            if (cl[j] == c) {
                return false;
            }
            if (cl[j] == 0 && !dfs(g, cl, j, -c)) {
                return false;
            }
        }
        return true;
    }
}
