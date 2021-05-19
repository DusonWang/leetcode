package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ����ά���� matrix ��һ������ k �������СΪ?m x n �ɷǸ�������ɡ�
 * <p>
 * ���������� (a, b) �� ֵ ���ɶ��������� 0 <= i <= a < m �� 0 <= j <= b < n ��Ԫ�� matrix[i][j]���±�� 0 ��ʼ������ִ���������õ���
 * <p>
 * �����ҳ�?matrix �����������е� k ���ֵ��k ��ֵ�� 1 ��ʼ��������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺matrix = [[5,2],[1,6]], k = 1
 * �����7
 * ���ͣ����� (0,1) ��ֵ�� 5 XOR 2 = 7 ��Ϊ����ֵ��
 * ʾ�� 2��
 * <p>
 * ���룺matrix = [[5,2],[1,6]], k = 2
 * �����5
 * ���ͣ����� (0,0) ��ֵ�� 5 = 5 ��Ϊ�� 2 ���ֵ��
 * ʾ�� 3��
 * <p>
 * ���룺matrix = [[5,2],[1,6]], k = 3
 * �����4
 * ���ͣ����� (1,0) ��ֵ�� 5 XOR 1 = 4 ��Ϊ�� 3 ���ֵ��
 * ʾ�� 4��
 * <p>
 * ���룺matrix = [[5,2],[1,6]], k = 4
 * �����0
 * ���ͣ����� (1,1) ��ֵ�� 5 XOR 2 XOR 1 XOR 6 = 0 ��Ϊ�� 4 ���ֵ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 106
 * 1 <= k <= m * n
 * ͨ������14,844�ύ����22,672
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class KthLargestValue {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                results.add(pre[i][j]);
            }
        }
        results.sort((num1, num2) -> num2 - num1);
        return results.get(k - 1);
    }

}
