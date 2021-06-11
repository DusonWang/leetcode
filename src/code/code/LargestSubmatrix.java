package code.code;

import java.util.Arrays;

/**
 * ����һ�������ƾ���matrix�����Ĵ�СΪm x n������Խ� matrix�е� �а�����˳���������С�
 * <p>
 * ���㷵�����ŷ����½� matrix�������к�ȫ�� 1���Ӿ��������
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺matrix = [[0,0,1],[1,1,1],[1,0,1]]
 * �����4
 * ���ͣ�����԰�����ͼ��ʽ�������о����ÿһ�С�
 * ����ȫ 1 �Ӿ�������ͼ�мӴֵĲ��֣����Ϊ 4 ��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺matrix = [[1,0,1,0,1]]
 * �����3
 * ���ͣ�����԰�����ͼ��ʽ�������о����ÿһ�С�
 * ����ȫ 1 �Ӿ�������ͼ�мӴֵĲ��֣����Ϊ 3 ��
 * ʾ�� 3��
 * <p>
 * ���룺matrix = [[1,1,0],[1,0,1]]
 * �����2
 * ���ͣ�������ֻ���������������Ų�������û�б����Ϊ 2 �����ȫ 1 �Ӿ��Ρ�
 * ʾ�� 4��
 * <p>
 * ���룺matrix = [[0,0],[0,0]]
 * �����0
 * ���ͣ����ھ�����û�� 1 ��û���κ�ȫ 1 ���Ӿ����������Ϊ 0 ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m * n <= 105
 * matrix[i][j]Ҫô��0��Ҫô��1 ��
 * ͨ������3,087�ύ����5,406
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/largest-submatrix-with-rearrangements
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LargestSubmatrix {

    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        int res = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = m - 1; j >= 0; j--) {
                int height = row[j];
                res = Math.max(res, height * (m - j));
            }
        }
        return res;
    }

}
