package code.code;

/**
 * n �����к�һЩ������Щ���еĵ�· roads ��ͬ���һ��������ʩ���硣ÿ�� roads[i] = [ai, bi] ����ʾ�ڳ��� ai �� bi ֮����һ��˫���·��
 * <p>
 * ������ͬ���й��ɵ� ���ж� �� ������ ����Ϊ�������������� ֱ�� �����ĵ�·�������������һ����·ֱ���������������У���������·ֻ���� һ�� ��
 * <p>
 * ����������ʩ����� ��������� �����в�ͬ���ж��е� ��������� ��
 * <p>
 * �������� n ������ roads����������������ʩ����� ��������� ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * �����4
 * ���ͣ����� 0 �� 1 ���������� 4����Ϊ���� 4 ����·����� 0 �� 1 ������λ�� 0 �� 1 ֮��ĵ�·ֻ����һ�Ρ�
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
 * �����5
 * ���ͣ����� 5 ����·����� 1 �� 2 ������
 * ʾ�� 3��
 * <p>
 * ���룺n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
 * �����5
 * ���ͣ�2 �� 5 ��������Ϊ 5��ע�Ⲣ�����еĳ��ж���Ҫ����������
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= n <= 100
 * 0 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 2
 * 0 <= ai, bi<= n-1
 * ai!=bi
 * ÿ�Գ���֮�� ���ֻ��һ����·����
 * ͨ������4,847�ύ����9,809
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximal-network-rank
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        if (roads == null || roads.length == 0) {
            return 0;
        }
        int[] edges = new int[n + 1];
        boolean[][] adj = new boolean[n + 1][n + 1];
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            edges[from]++;
            edges[to]++;
            adj[from][to] = true;
            adj[to][from] = true;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, edges[i] + edges[j] - (adj[i][j] ? 1 : 0));
            }
        }
        return res;
    }

}
