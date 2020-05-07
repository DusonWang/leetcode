package com.leetcode.offer.code;

/**
 * @author duson
 * ����һ����ά����?A��ÿ����Ԫ��Ϊ 0���������� 1������½�أ���
 * <p>
 * �ƶ���ָ��½���ϴ�һ���ط��ߵ���һ���ط������ĸ�����֮һ�����뿪����ı߽硣
 * <p>
 * �����������޷�������������ƶ����뿪����߽��½�ص�Ԫ���������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * �����3
 * ���ͣ�
 * ������ 1 �� 0 ��Χ��һ�� 1 û�б���Χ����Ϊ���ڱ߽��ϡ�
 * ʾ�� 2��
 * <p>
 * ���룺[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * �����0
 * ���ͣ�
 * ���� 1 ���ڱ߽��ϻ���Ե���߽硣
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * �����еĴ�С����ͬ
 * ͨ������3,504�ύ����6,895
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-enclaves
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumEnclaves {

    public int numEnclaves(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            dfs(A, i, 0);
        }
        for (int j = 0; j < A[0].length; j++) {
            dfs(A, 0, j);
        }
        for (int i = 0; i < A.length; i++) {
            dfs(A, i, A[0].length - 1);
        }
        for (int j = 0; j < A[0].length; j++) {
            dfs(A, A.length - 1, j);
        }
        int result = 0;
        for (int[] ints : A) {
            for (int y : ints) {
                result += y;
            }
        }
        return result;
    }

    private void dfs(int[][] A, int i, int j) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length) {
            return;
        }
        if (A[i][j] == 0) {
            return;
        }
        A[i][j] = 0;
        dfs(A, i - 1, j);
        dfs(A, i + 1, j);
        dfs(A, i, j - 1);
        dfs(A, i, j + 1);
    }
}
