package code.code;

/**
 * ���������Ǹ���������?rowSum ��?colSum?������?rowSum[i]?�Ƕ�ά�����е� i?��Ԫ�صĺͣ� colSum[j]?�ǵ� j?��Ԫ�صĺ͡�����֮�㲻֪���������ÿ��Ԫ�أ�������֪��ÿһ�к�ÿһ�еĺ͡�
 * <p>
 * ���ҵ���СΪ?rowSum.length x colSum.length?������ �Ǹ�����?�����Ҹþ�������?rowSum ��?colSum?��Ҫ��
 * <p>
 * ���㷵������һ��������ĿҪ��Ķ�ά������Ŀ��֤���� ����һ��?���о���
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺rowSum = [3,8], colSum = [4,7]
 * �����[[3,0],
 * [1,7]]
 * ���ͣ�
 * �� 0 �У�3 + 0 = 3 == rowSum[0]
 * �� 1 �У�1 + 7 = 8 == rowSum[1]
 * �� 0 �У�3 + 1 = 4 == colSum[0]
 * �� 1 �У�0 + 7 = 7 == colSum[1]
 * �к��еĺͶ�������ĿҪ�������о���Ԫ�ض��ǷǸ��ġ�
 * ��һ�����еľ���Ϊ��[[1,2],
 * [3,5]]
 * ʾ�� 2��
 * <p>
 * ���룺rowSum = [5,7,10], colSum = [8,6,8]
 * �����[[0,5,0],
 * [6,1,0],
 * [2,0,8]]
 * ʾ�� 3��
 * <p>
 * ���룺rowSum = [14,9], colSum = [6,9,8]
 * �����[[0,9,5],
 * [6,0,3]]
 * ʾ�� 4��
 * <p>
 * ���룺rowSum = [1,0], colSum = [1]
 * �����[[1],
 * [0]]
 * ʾ�� 5��
 * <p>
 * ���룺rowSum = [0], colSum = [0]
 * �����[[0]]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= rowSum.length, colSum.length <= 500
 * 0 <= rowSum[i], colSum[i] <= 108
 * sum(rows) == sum(columns)
 * ͨ������2,710�ύ����3,745
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-valid-matrix-given-row-and-column-sums
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class RestoreMatrix {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            int min = Math.min(rowSum[i], colSum[j]);
            ans[i][j] = min;
            if (min == rowSum[i]) {
                colSum[j] -= min;
                rowSum[i++] = 0;
            } else {
                rowSum[i] -= min;
                colSum[j++] = 0;
            }
        }
        return ans;
    }
}
