package code.code;

/**
 * ����������СΪ n x n �Ķ����ƾ��� mat �� target ���� �� 90 ��˳ʱ����ת ���� mat �е�Ԫ�� ���ɴ� ������ܹ�ʹ mat ��target һ�£����� true �����򣬷��� false ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * �����true
 * ���ͣ�˳ʱ����ת 90 ��һ�ο���ʹ mat �� target һ�¡�
 * ʾ�� 2��
 * <p>
 * <p>
 * ���룺mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * �����false
 * ���ͣ��޷�ͨ����ת�����е�Ԫ��ʹ equal �� target һ�¡�
 * ʾ�� 3��
 * <p>
 * <p>
 * ���룺mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * �����true
 * ���ͣ�˳ʱ����ת 90 �����ο���ʹ mat �� target һ�¡�
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] �� target[i][j] ���� 0 ���� 1
 * ͨ������4,210�ύ����7,502
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/determine-whether-matrix-can-be-obtained-by-rotation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindRotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = true;
        boolean b4 = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[n - j - 1][i] != target[i][j]) {
                    b1 = false;
                }
                if (mat[n - i - 1][n - j - 1] != target[i][j]) {
                    b2 = false;
                }
                if (mat[j][n - i - 1] != target[i][j]) {
                    b3 = false;
                }
                if (mat[i][j] != target[i][j]) {
                    b4 = false;
                }
            }
        }
        return b1 || b2 || b3 || b4;
    }

}
