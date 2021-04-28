package code.code;

/**
 * ����һ����СΪ rows x cols �ľ��� mat������ mat[i][j] �� 0 �� 1���뷵�� ����?mat ������λ�õ���Ŀ ��
 * <p>
 * ����λ�� ���壺��� mat[i][j] == 1 ���ҵ� i �к͵� j ���е���������Ԫ�ؾ�Ϊ 0���к��е��±�� �� 0 ��ʼ ������λ�� (i, j) ����Ϊ����λ�á�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺mat = [[1,0,0],
 * ?           [0,0,1],
 * ?           [1,0,0]]
 * �����1
 * ���ͣ�(1,2) ��һ������λ�ã���Ϊ mat[1][2] == 1 ���������к�������������Ԫ�ض��� 0
 * ʾ�� 2��
 * <p>
 * ���룺mat = [[1,0,0],
 * ?           [0,1,0],
 * ?           [0,0,1]]
 * �����3
 * ���ͣ�(0,0), (1,1) �� (2,2) ��������λ��
 * ʾ�� 3��
 * <p>
 * ���룺mat = [[0,0,0,1],
 * ?           [1,0,0,0],
 * ?           [0,1,1,0],
 * ?           [0,0,0,0]]
 * �����2
 * ʾ�� 4��
 * <p>
 * ���룺mat = [[0,0,0,0,0],
 * ?           [1,0,0,0,0],
 * ?           [0,1,0,0,0],
 * ?           [0,0,1,0,0],
 * ?           [0,0,0,1,1]]
 * �����3
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] �� 0 �� 1
 * ͨ������8,182�ύ����12,178
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/special-positions-in-a-binary-matrix
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumSpecial {

    public int numSpecial(int[][] mat) {
        int count = 0;
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
