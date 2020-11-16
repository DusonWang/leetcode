package code.code;

/**
 * @author duson
 * ����λ������Ҳ�����һ������������ɫ������Ϸ����Ϸ�У������������ĸ��ڵ�?root�������ܹ��� n ���ڵ㣬�� n Ϊ����������ÿ���ڵ��ϵ�ֵ��?1 ��?n?������ͬ��
 *
 * ?
 *
 * ��Ϸ�ӡ�һ�š���ҿ�ʼ����һ�š����Ϊ��ɫ�������š����Ϊ��ɫ�����ʼʱ��
 *
 * ��һ�š���Ҵ� [1, n]?��ȡһ��ֵ?x��1 <= x <= n����
 *
 * �����š����Ҳ��?[1, n]?��ȡһ��ֵ?y��1 <= y <= n����?y != x��
 *
 * ��һ�š���Ҹ�ֵΪ?x?�Ľڵ�Ⱦ�Ϻ�ɫ���������š���Ҹ�ֵΪ?y?�Ľڵ�Ⱦ����ɫ��
 *
 * ?
 *
 * ֮����λ����������в�����ÿһ�غϣ����ѡ��һ����֮ǰͿ����ɫ�Ľڵ㣬����ѡ�ڵ�һ�� δ��ɫ ���ڽڵ㣨�������ӽڵ㡢�򸸽ڵ㣩����Ⱦɫ��
 *
 * �����ǰ����޷��ҵ������Ľڵ���Ⱦɫʱ�����ĻغϾͻᱻ������
 *
 * ��������Ҷ�û�п���Ⱦɫ�Ľڵ�ʱ����Ϸ��������ɫ�ڵ�������λ��һ��ʤ�� ??��
 *
 * ?
 *
 * ���ڣ��������ǡ����š���ң����������������룬�������һ��?y?ֵ����ȷ����Ӯ���ⳡ��Ϸ���򷵻�?true�����޷���ʤ�����뷵�� false��
 *
 * ?
 *
 * ʾ����
 *
 *
 *
 * ���룺root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 * �����True
 * ���ͣ��ڶ�����ҿ���ѡ��ֵΪ 2 �Ľڵ㡣
 * ?
 *
 * ��ʾ��
 *
 * �������ĸ��ڵ�Ϊ?root�������� n ���ڵ㣬�ڵ��ϵ�ֵ�� 1 �� n ������ͬ��
 * n Ϊ������
 * 1 <= x <= n?<= 100
 * ͨ������3,105�ύ����7,445
 * ����ʵ�������������������
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/binary-tree-coloring-game
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BtreeGameWinningMove {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int left;

    private int right;

    private int num;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        num = x;
        dfs(root);
        int half = n / 2;
        return left > half || right > half || (left + right) < half;
    }

    private int dfs(TreeNode node) {
        int leftNum = 0;
        int rightNum = 0;
        if (node.left != null) {
            leftNum = dfs(node.left);
        }
        if (node.right != null) {
            rightNum = dfs(node.right);
        }
        if (node.val == num) {
            left = leftNum;
            right = rightNum;
        }
        return leftNum + rightNum + 1;
    }
}
