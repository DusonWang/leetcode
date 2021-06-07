package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ��2�� n �еĶ��������飺
 * <p>
 * ������һ�������ƾ�������ζ�ž����е�ÿ��Ԫ�ز���0����1��
 * �� 0 �е�Ԫ��֮��Ϊupper��
 * �� 1 �е�Ԫ��֮��Ϊ lower��
 * �� i �У��� 0 ��ʼ��ţ���Ԫ��֮��Ϊcolsum[i]��colsum��һ������Ϊn���������顣
 * ����Ҫ����upper��lower��colsum���ع�������󣬲��Զ�ά�����������ʽ��������
 * <p>
 * ����ж����ͬ�Ĵ𰸣���ô����һ��������ͨ�����⡣
 * <p>
 * ��������ڷ���Ҫ��Ĵ𰸣����뷵��һ���յĶ�ά���顣
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺upper = 2, lower = 1, colsum = [1,1,1]
 * �����[[1,1,0],[0,0,1]]
 * ���ͣ�[[1,0,1],[0,1,0]] �� [[0,1,1],[1,0,0]] Ҳ����ȷ�𰸡�
 * ʾ�� 2��
 * <p>
 * ���룺upper = 2, lower = 3, colsum = [2,2,1,1]
 * �����[]
 * ʾ�� 3��
 * <p>
 * ���룺upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * �����[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= colsum.length <= 10^5
 * 0 <= upper, lower <= colsum.length
 * 0 <= colsum[i] <= 2
 * ͨ������4,863�ύ����12,360
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ReconstructMatrix {

    public List<List<Integer>> reconstructMatrix(int u, int l, int[] cs) {
        boolean[][] res = new boolean[2][cs.length];
        for (int i = 0; i < cs.length; ++i) {
            res[0][i] = cs[i] == 2 || (cs[i] == 1 && l < u);
            res[1][i] = cs[i] == 2 || (cs[i] == 1 && !res[0][i]);
            u -= res[0][i] ? 1 : 0;
            l -= res[1][i] ? 1 : 0;
        }
        return l == 0 && u == 0 ? new ArrayList(Arrays.asList(res[0], res[1])) : new ArrayList<>();
    }
}
