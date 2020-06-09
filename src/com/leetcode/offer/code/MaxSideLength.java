package com.leetcode.offer.code;

/**
 * @author duson
 * ����һ����СΪ?m x n?�ľ���?mat?��һ��������ֵ?threshold��
 * <p>
 * ���㷵��Ԫ���ܺ�С�ڻ������ֵ����������������߳������û�������������������򷵻� 0?��
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * �����2
 * ���ͣ��ܺ�С�� 4 �������ε����߳�Ϊ 2����ͼ��ʾ��
 * ʾ�� 2��
 * <p>
 * ���룺mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * �����0
 * ʾ�� 3��
 * <p>
 * ���룺mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
 * �����3
 * ʾ�� 4��
 * <p>
 * ���룺mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
 * �����2
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= m, n <= 300
 * m == mat.length
 * n == mat[i].length
 * 0 <= mat[i][j] <= 10000
 * 0 <= threshold?<= 10^5
 * ͨ������2,749�ύ����6,562
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxSideLength {

    public int maxSideLength(int[][] mat, int threshold) {
        int high = mat.length, length = mat[0].length, size = 0;
        int[][] prefix = new int[high + 1][length + 1];
        for (int i = 1; i <= high; i++) {
            for (int j = 1; j <= length; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= high; i++) {
            for (int j = 1; j <= length; j++) {
                if (mat[i - 1][j - 1] > threshold) {
                    continue;
                }
                for (int k = 1; j - k >= 0 && i - k >= 0; k++) {
                    int sum = prefix[i][j] - prefix[i - k][j] - prefix[i][j - k] + prefix[i - k][j - k];
                    if (sum > threshold) {
                        break;
                    }
                    size = Math.max(size, k);
                }
            }
        }
        return size;
    }
}
