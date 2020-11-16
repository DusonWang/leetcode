package code.code;

/**
 * @author duson
 * ������һ��m��n�еķ��񣬴����� [0,0] ������ [m-1,n-1] ��һ�������˴����� [0, 0] �ĸ��ӿ�ʼ�ƶ�����ÿ�ο��������ҡ��ϡ����ƶ�һ�񣨲����ƶ��������⣩��Ҳ���ܽ�������������������λ֮�ʹ���k�ĸ��ӡ����磬��kΪ18ʱ���������ܹ����뷽�� [35, 37] ����Ϊ3+5+3+7=18���������ܽ��뷽�� [35, 38]����Ϊ3+5+3+8=19�����ʸû������ܹ�������ٸ����ӣ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺m = 2, n = 3, k = 1
 * �����3
 * ʾ�� 2��
 * <p>
 * ���룺m = 3, n = 1, k = 0
 * �����1
 * ��ʾ��
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k?<= 20
 * ͨ������35,124�ύ����72,938
 * ����ʵ�������������������
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MovingCount {

    private int counts = 0;

    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        helper(visited, 0, 0, m - 1, n - 1, k);
        return counts;
    }

    private void helper(int[][] visited, int i, int j, int m, int n, int k) {
        if (i <= m && j <= n && visited[i][j] != 1 && indexSum(i) + indexSum(j) <= k) {
            counts++;
            visited[i][j] = 1;
            helper(visited, i + 1, j, m, n, k);
            helper(visited, i, j + 1, m, n, k);
        }
    }

    private int indexSum(int index) {
        int sum = index % 10;
        int tmp = index / 10;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum;
    }

}
