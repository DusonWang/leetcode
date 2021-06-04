package code.code;

/**
 * ����һ������������ n ���ڵ㣬���� 0 �� n-1 ��š����Ը��ڵ��������ʽ���������� parent[i] �ǽڵ� i �ĸ��ڵ㡣���ĸ��ڵ��Ǳ��Ϊ 0 �Ľڵ㡣
 * <p>
 * ������Ʋ�ʵ�� getKthAncestor(int node, int k) �������������ؽڵ� node �ĵ� k �����Ƚڵ㡣������������������Ƚڵ㣬���� -1 ��
 * <p>
 * ���ڵ�ĵ� k �����Ƚڵ��ǴӸýڵ㵽���ڵ�·���ϵĵ� k ���ڵ㡣
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * <p>
 * <p>
 * ���룺
 * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
 * [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
 * <p>
 * �����
 * [null,1,0,-1]
 * <p>
 * ���ͣ�
 * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
 * <p>
 * treeAncestor.getKthAncestor(3, 1);  // ���� 1 ������ 3 �ĸ��ڵ�
 * treeAncestor.getKthAncestor(5, 2);  // ���� 0 ������ 5 ���游�ڵ�
 * treeAncestor.getKthAncestor(6, 3);  // ���� -1 ��Ϊ����������Ҫ������Ƚڵ�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= k <=?n <= 5*10^4
 * parent[0] == -1 ��ʾ���Ϊ 0 �Ľڵ��Ǹ��ڵ㡣
 * �������е� 0 <?i < n ��0 <= parent[i] < n �ܳ���
 * 0 <= node < n
 * �����ѯ 5*10^4 ��
 * ͨ������2,911�ύ����9,812
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/kth-ancestor-of-a-tree-node
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class TreeAncestor {

    private final int[][] jump;

    private final int maxPow;

    public TreeAncestor(int n, int[] parent) {
        maxPow = (int) (Math.log(n) / Math.log(2)) + 1;
        jump = new int[maxPow][n];
        jump[0] = parent;
        for (int p = 1; p < maxPow; p++) {
            for (int j = 0; j < n; j++) {
                int pre = jump[p - 1][j];
                jump[p][j] = pre == -1 ? -1 : jump[p - 1][pre];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int max = this.maxPow;
        while (k > 0 && node > -1) {
            if (k >= 1 << max) {
                node = jump[max][node];
                k -= 1 << max;
            } else {
                max -= 1;
            }
        }
        return node;
    }
}
