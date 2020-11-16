package code.code;

/**
 * @author duson
 * �� n?�����У����� 0 �� n-1?��š�����һ��������?edges������ edges[i] = [fromi, toi, weighti]?����?fromi?��?toi?��������֮���˫���Ȩ�ߣ�������ֵ��һ������?distanceThreshold��
 * <p>
 * ������ͨ��ĳЩ·����������������Ŀ���١���·������ ��� Ϊ?distanceThreshold?�ĳ��С�����ж�������ĳ��У��򷵻ر�����ĳ��С�
 * <p>
 * ע�⣬���ӳ��� i �� j ��·���ľ�������ظ�·�������бߵ�Ȩ��֮�͡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * �����3
 * ���ͣ����зֲ�ͼ���ϡ�
 * ÿ��������ֵ���� distanceThreshold = 4 �ڵ��ھӳ��зֱ��ǣ�
 * ���� 0 -> [���� 1, ���� 2]?
 * ���� 1 -> [���� 0, ���� 2, ���� 3]?
 * ���� 2 -> [���� 0, ���� 1, ���� 3]?
 * ���� 3 -> [���� 1, ���� 2]?
 * ���� 0 �� 3 ����ֵ���� 4 ���ڶ��� 2 ���ھӳ��У��������Ǳ��뷵�س��� 3����Ϊ���ı�����
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
 * �����0
 * ���ͣ����зֲ�ͼ���ϡ�?
 * ÿ��������ֵ���� distanceThreshold = 2 �ڵ��ھӳ��зֱ��ǣ�
 * ���� 0 -> [���� 1]?
 * ���� 1 -> [���� 0, ���� 4]?
 * ���� 2 -> [���� 3, ���� 4]?
 * ���� 3 -> [���� 2, ���� 4]
 * ���� 4 -> [���� 1, ���� 2, ���� 3]?
 * ���� 0 ����ֵ���� 4 ����ֻ�� 1 ���ھӳ��С�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= n <= 100
 * 1 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti,?distanceThreshold <= 10^4
 * ���� (fromi, toi)?���ǲ�ͬ�ġ�
 * ͨ������1,926�ύ����4,252
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindTheCity {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dist[j][i] != Integer.MAX_VALUE
                            && dist[i][k] != Integer.MAX_VALUE
                            && dist[j][i] + dist[i][k] < dist[j][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
        int mincount = n, cityId = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += ((i != j && dist[i][j] <= distanceThreshold) ? 1 : 0);
            }
            if (count <= mincount) {
                cityId = i;
                mincount = count;
            }
        }
        return cityId;
    }
}
