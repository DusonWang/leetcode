package com.leetcode.offer.code;

import java.util.List;

/**
 * @author duson
 * ������һ�������⣩
 * <p>
 * ���ǳ�ֻ����Ԫ��?0?��?1?�ľ���Ϊ�����ƾ��󡣾�����ÿ���������ж����ǵݼ�˳������
 * <p>
 * ����һ�������Ķ����ƾ��󣬷������ٰ���һ��?1?��������е��������� 0 ��ʼ��������������в����ڣ�����?-1��
 * <p>
 * ������ֱ�ӷ��ʸö����ƾ�����ֻ����ͨ��?BinaryMatrix?�ӿ������ʡ�
 * <p>
 * BinaryMatrix.get(row, col)?����λ������?(row, col)?���� 0 ��ʼ����Ԫ�ء�
 * BinaryMatrix.dimensions()?���غ��� 2 ��Ԫ�ص��б�?[rows, cols]����ʾ����һ��?rows *?cols�ľ���
 * ����ύ�Ĵ𰸵���?BinaryMatrix.get?���� 1000 �Σ���ô𰸻ᱻ�ж�Ϊ����𰸡��ύ�κ���ͼ����ж����ƵĴ𰸽��ᱻȡ���ʸ�
 * <p>
 * ����ʾ���У�?mat?Ϊ�����Ķ����ƾ���������ֱ�ӷ��ʸþ���
 * <p>
 * ?
 * <p>
 * ʾ�� 1:
 * <p>
 * <p>
 * <p>
 * ����: mat = [[0,0],[1,1]]
 * ���: 0
 * ʾ�� 2:
 * <p>
 * <p>
 * <p>
 * ����: mat = [[0,0],[0,1]]
 * ���: 1
 * ʾ�� 3:
 * <p>
 * <p>
 * <p>
 * ����: mat = [[0,0],[0,0]]
 * ���: -1
 * ʾ�� 4:
 * <p>
 * <p>
 * <p>
 * ����: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * ���: 1
 * ?
 * <p>
 * ��ʾ:
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols?<= 100
 * mat[i][j]?ֻ����?0?��?1��
 * mat[i]?�Ѱ��ǵݼ�˳������
 * ͨ������95�ύ����129
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/leftmost-column-with-at-least-a-one
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeftMostColumnWithOne {

    static class BinaryMatrix {
        public int get(int row, int col) {
            return 0;
        }

        public List<Integer> dimensions() {
            return null;
        }
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int n = dimension.get(0);
        int m = dimension.get(1);
        int i = n - 1, j = m - 1, res = -1;
        while (i >= 0 && j >= 0) {
            int cur = binaryMatrix.get(i, j);
            if (cur == 0) {
                i--;
            } else {
                res = j;
                j--;
            }
        }
        return res;
    }
}
