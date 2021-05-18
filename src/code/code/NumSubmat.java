package code.code;

/**
 * ����һ��ֻ���� 0 �� 1 ��?rows * columns?����?mat?�����㷵���ж��ٸ�?�Ӿ���?��Ԫ��ȫ������ 1 ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺mat = [[1,0,1],
 * ?           [1,1,0],
 * ?           [1,1,0]]
 * �����13
 * ���ͣ�
 * �� 6?�� 1x1 �ľ��Ρ�
 * �� 2 �� 1x2 �ľ��Ρ�
 * �� 3 �� 2x1 �ľ��Ρ�
 * �� 1 �� 2x2 �ľ��Ρ�
 * �� 1 �� 3x1 �ľ��Ρ�
 * ������Ŀ�ܹ� = 6 + 2 + 3 + 1 + 1 = 13?��
 * ʾ�� 2��
 * <p>
 * ���룺mat = [[0,1,1,0],
 * ?           [0,1,1,1],
 * ?           [1,1,1,0]]
 * �����24
 * ���ͣ�
 * �� 8 �� 1x1 ���Ӿ��Ρ�
 * �� 5 �� 1x2 ���Ӿ��Ρ�
 * �� 2 �� 1x3 ���Ӿ��Ρ�
 * �� 4 �� 2x1 ���Ӿ��Ρ�
 * �� 2 �� 2x2 ���Ӿ��Ρ�
 * �� 2 �� 3x1 ���Ӿ��Ρ�
 * �� 1 �� 3x2 ���Ӿ��Ρ�
 * ������Ŀ�ܹ� = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 ��
 * ʾ�� 3��
 * <p>
 * ���룺mat = [[1,1,1,1,1,1]]
 * �����21
 * ʾ�� 4��
 * <p>
 * ���룺mat = [[1,0,1],[0,1,0],[1,0,1]]
 * �����5
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= rows?<= 150
 * 1 <= columns?<= 150
 * 0 <= mat[i][j] <= 1
 * ͨ������6,269�ύ����10,674
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-submatrices-with-all-ones
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumSubmat {

    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int height = mat[0].length;
        int[][] count = new int[row][height];
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < height; j++) {
                if (mat[i][j] == 0 || j == 0) {
                    count[i][j] = mat[i][j];
                } else {
                    count[i][j] = count[i][j - 1] + 1;
                }
                int col = count[i][j];
                for (int k = i; k >= 0 && col != 0; k--) {
                    col = Math.min(col, count[k][j]);
                    sum += col;
                }
            }
        }
        return sum;
    }
}
