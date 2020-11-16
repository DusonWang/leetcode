package code.code;

/**
 * ����һ�ö�������ÿ���ڵ��ֵΪ 1 �� 9 �����ǳƶ������е�һ��·���� ��α���ġ��ģ��������㣺·�����������нڵ�ֵ�������У�����һ���������С�
 * <p>
 * ���㷵�شӸ���Ҷ�ӽڵ������·����?α����?·������Ŀ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺root = [2,3,1,3,1,null,1]
 * �����2
 * ���ͣ���ͼΪ�����Ķ��������ܹ��� 3 ���Ӹ���Ҷ�ӵ�·������ɫ·�� [2,3,3] ����ɫ·�� [2,1,1] ��·�� [2,3,1] ��
 * ����Щ·���У�ֻ�к�ɫ����ɫ��·����α����·������Ϊ��ɫ·�� [2,3,3] ���ڻ������� [3,2,3] ����ɫ·�� [2,1,1] ���ڻ������� [1,2,1] ��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺root = [2,1,1,1,3,null,null,null,null,null,1]
 * �����1
 * ���ͣ���ͼΪ�������������ܹ��� 3 ���Ӹ���Ҷ�ӵ�·������ɫ·�� [2,1,1] ��·�� [2,1,3,1] ��·�� [2,1] ��
 * ��Щ·����ֻ����ɫ·����α����·������Ϊ [2,1,1] ���ڻ������� [1,2,1] ��
 * ʾ�� 3��
 * <p>
 * ���룺root = [9]
 * �����1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * �����������Ľڵ���Ŀ��?1?��?10^5?֮�䡣
 * �ڵ�ֵ��?1 ��?9?֮�䡣
 * ͨ������2,171�ύ����3,606
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class PseudoPalindromicPaths {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int count;

    public int pseudoPalindromicPaths(TreeNode root) {
        count = 0;
        dfs(root, 0);
        return count;
    }

    private void dfs(TreeNode node, int v) {
        v ^= 1 << node.val;
        if (node.left == null && node.right == null) {
            if (v == 0 || (v & -v) == v) {
                count++;
            }
        }
        if (node.left != null) {
            dfs(node.left, v);
        }
        if (node.right != null) {
            dfs(node.right, v);
        }
    }
}
