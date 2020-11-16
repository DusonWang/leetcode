package code.code;

/**
 * ����һ����������?arr��ÿһ�β����㶼����ѡ��ɾ������һ�� ���� ������?arr[i], arr[i+1], ..., arr[j]�� i <= j����
 * <p>
 * ע�⣬ÿ����ɾ����һ�������飬�Ҳ�Ԫ�ض���������ǰ�ƶ����λ��
 * <p>
 * ������㲢���ش�������ɾ������������������ٲ���������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = [1,2]
 * �����2
 * ʾ�� 2��
 * <p>
 * ���룺arr = [1,3,4,1,5]
 * �����3
 * ���ͣ���ɾ�� [4]��Ȼ��ɾ�� [1,3,1]�������ɾ�� [5]��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 20
 * ͨ������1,072�ύ����2,384
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/palindrome-removal
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinimumMoves {

    public int minimumMoves(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (i == j - 1) {
                    dp[i][j] = arr[i] == arr[j] ? 1 : 2;
                    continue;
                }
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][len - 1];
    }
}
