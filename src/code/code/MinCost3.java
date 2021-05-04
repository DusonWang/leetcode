package code.code;

/**
 * ��һ��С�������?m?�������ų�һ�ţ�����Ҫ��ÿ������Ϳ�� n?����ɫ֮һ����ɫ���Ϊ 1 �� n?�����еķ���ȥ�������Ѿ�Ϳ����ɫ�ˣ�������Щ���Ӳ���Ҫ������Ϳɫ��
 * <p>
 * ���ǽ�������ͬ��ɫ�����ܶ�ķ��ӳ�Ϊһ�����������ȷ�˵ houses = [1,2,2,3,3,2,1,1] �������� 5 ������? [{1}, {2,2}, {3,3}, {2}, {1,1}] ����
 * <p>
 * ����һ������?houses?��һ��?m * n?�ľ���?cost?��һ������?target?�����У�
 * <p>
 * houses[i]���ǵ�?i?�����ӵ���ɫ��0?��ʾ������ӻ�û�б�Ϳɫ��
 * cost[i][j]���ǽ���?i?������Ϳ����ɫ?j+1?�Ļ��ѡ�
 * ���㷵�ط���Ϳɫ��������С�ܻ��ѣ�ʹ��ÿ�����Ӷ���Ϳɫ��ǡ�����?target?�����������û�п��õ�Ϳɫ�������뷵��?-1?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * �����9
 * ���ͣ�����Ϳɫ����Ϊ [1,2,2,1,1]
 * �˷������� target = 3 ���������ֱ��� [{1}, {2,2}, {1,1}]��
 * Ϳɫ���ܻ���Ϊ (1 + 1 + 1 + 1 + 5) = 9��
 * ʾ�� 2��
 * <p>
 * ���룺houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * �����11
 * ���ͣ��еķ����Ѿ���Ϳɫ�ˣ��ڴ˻�����Ϳɫ����Ϊ [2,2,1,2,2]
 * �˷������� target = 3 ���������ֱ��� [{2,2}, {1}, {2,2}]��
 * ����һ�������һ������Ϳɫ�Ļ���Ϊ (10 + 1) = 11��
 * ʾ�� 3��
 * <p>
 * ���룺houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 5, n = 2, target = 5
 * �����5
 * ʾ�� 4��
 * <p>
 * ���룺houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
 * �����-1
 * ���ͣ������Ѿ���Ϳɫ������� 4 ���������ֱ��� [{3},{1},{2},{3}] ���޷��γ� target = 3 ��������
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * m == houses.length == cost.length
 * n == cost[i].length
 * 1 <= m <= 100
 * 1 <= n <= 20
 * 1 <= target?<= m
 * 0 <= houses[i]?<= n
 * 1 <= cost[i][j] <= 10^4
 * ͨ������3,574�ύ����6,282
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/paint-house-iii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinCost3 {

    int[] houses = null;
    int[][] costs = null;
    int t = 0;
    int[][][] dp = null;
    static int MAX = Integer.MAX_VALUE;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.costs = cost;
        this.t = target;
        this.dp = new int[m + 1][n + 1][target + 1];

        int val = helper(0, 0, 0);
        return val == MAX ? -1 : val;
    }

    private int helper(int idx, int ne, int prev) {
        if (ne > t) {
            return MAX;
        }

        if (dp[idx][prev][ne] != 0) {
            return dp[idx][prev][ne];
        }

        if (idx == houses.length) {
            if (ne == t) {
                return 0;
            }
            return MAX;
        }

        int min = MAX;
        if (houses[idx] == 0) {
            for (int i = 1; i <= costs[idx].length; i++) {
                int val = helper(idx + 1, prev != i ? ne + 1 : ne, i);
                if (val != MAX) {
                    min = Math.min(min, costs[idx][i - 1] + val);
                }
            }
        } else {
            min = helper(idx + 1, prev != houses[idx] ? ne + 1 : ne, houses[idx]);
        }
        return dp[idx][prev][ne] = min;
    }
}
