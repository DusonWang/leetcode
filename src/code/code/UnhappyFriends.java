package code.code;

/**
 * ����һ�� n λ���ѵ��׽��̶��б����� n ���� ż�� ��
 * <p>
 * ��ÿλ���� i��preferences[i] ����һ�� ���׽��̶ȴӸߵ������� �������б����仰˵�������б�ǰ��������� i ���׽��̶ȱ������б��������Ѹ��ߡ�ÿ���б��е����Ѿ��� 0 �� n-1 ֮���������ʾ��
 * <p>
 * ���е����ѱ��ֳɼ��ԣ����������б� pairs ���������� pairs[i] = [xi, yi] ��ʾ xi �� yi ��ԣ��� yi �� xi ��ԡ�
 * <p>
 * ���ǣ����������������ܻ������в������Ѹе������ġ��� x �� y ����� u �� v ��Ե�����£����ͬʱ������������������x �ͻ᲻���ģ�
 * <p>
 * x �� u ���׽��̶�ʤ�� x �� y����
 * u �� x ���׽��̶�ʤ�� u �� v
 * ���� �����ĵ����ѵ���Ŀ ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
 * �����2
 * ���ͣ�
 * ���� 1 �����ģ���Ϊ��
 * - 1 �� 0 ��ԣ��� 1 �� 3 ���׽��̶ȱ� 1 �� 0 �ߣ���
 * - 3 �� 1 ���׽��̶ȱ� 3 �� 2 �ߡ�
 * ���� 3 �����ģ���Ϊ��
 * - 3 �� 2 ��ԣ��� 3 �� 1 ���׽��̶ȱ� 3 �� 2 �ߣ���
 * - 1 �� 3 ���׽��̶ȱ� 1 �� 0 �ߡ�
 * ���� 0 �� 2 ���ǿ��ĵġ�
 * ʾ�� 2��
 * <p>
 * ���룺n = 2, preferences = [[1], [0]], pairs = [[1, 0]]
 * �����0
 * ���ͣ����� 0 �� 1 �����ġ�
 * ʾ�� 3��
 * <p>
 * ���룺n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs = [[1, 3], [0, 2]]
 * �����4
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= n <= 500
 * n ��ż��
 * preferences.length== n
 * preferences[i].length== n - 1
 * 0 <= preferences[i][j] <= n - 1
 * preferences[i] ������ i
 * preferences[i] �е�����ֵ���Ƕ�һ�޶���
 * pairs.length== n/2
 * pairs[i].length== 2
 * xi != yi
 * 0 <= xi, yi<= n - 1
 * ÿλ���Ѷ� ǡ�� ��������һ����
 * ͨ������3,732�ύ����6,804
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-unhappy-friends
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class UnhappyFriends {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] degree = new int[n][n];
        int res = 0;
        for (int[] pair : pairs) {
            judge(preferences, degree, pair[0], pair[1]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (degree[i][j] == 1 && degree[j][i] == 1) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    private void judge(int[][] preferences, int[][] degree, int first, int last) {
        for (int i = 0; preferences[first][i] != last; i++) {
            degree[first][preferences[first][i]] = 1;
        }
        for (int i = 0; preferences[last][i] != first; i++) {
            degree[last][preferences[last][i]] = 1;
        }
    }
}
