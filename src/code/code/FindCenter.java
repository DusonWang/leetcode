package code.code;

/**
 * ��һ������� ���� ͼ���� n ����Ŵ� 1 �� n �Ľڵ���ɡ�����ͼ��һ�� ���� �ڵ㣬����ǡ�� n - 1 ���߽����Ľڵ�������ÿ���ڵ�����������
 * <p>
 * ����һ����ά�������� edges ������?edges[i] = [ui, vi] ��ʾ�ڽڵ� ui �� vi ֮�����һ���ߡ������ҳ�������?edges ����ʾ����ͼ�����Ľڵ㡣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺edges = [[1,2],[2,3],[4,2]]
 * �����2
 * ���ͣ�����ͼ��ʾ���ڵ� 2 ������ÿ���ڵ㶼���������Խڵ� 2 �����Ľڵ㡣
 * ʾ�� 2��
 * <p>
 * ���룺edges = [[1,2],[5,1],[1,3],[1,4]]
 * �����1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 3 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 * ��Ŀ���ݸ����� edges ��ʾһ����Ч������ͼ
 * ͨ������7,210�ύ����8,926
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-center-of-star-graph
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindCenter {

    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
}