package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * ����������ĸ��ڵ� root ��һ������ distance ��
 * <p>
 * ��������������� Ҷ �ڵ�֮��� ���·������ С�ڻ��ߵ��� distance �������ǾͿ��Թ���һ�� ��Ҷ�ӽڵ�� ��
 * <p>
 * �������� ��Ҷ�ӽڵ�Ե����� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ?
 * <p>
 * <p>
 * <p>
 * ���룺root = [1,2,3,null,4], distance = 3
 * �����1
 * ���ͣ�����Ҷ�ڵ��� 3 �� 4 ������֮������·���ĳ����� 3 ������Ψһ�ĺ�Ҷ�ӽڵ�ԡ�
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺root = [1,2,3,4,5,6,7], distance = 3
 * �����2
 * ���ͣ���Ҷ�ӽڵ��Ϊ [4,5] �� [6,7] �����·�����ȶ��� 2 ������Ҷ�ӽڵ�� [4,6] ������Ҫ����Ϊ����֮������·������Ϊ 4 ��
 * ʾ�� 3��
 * <p>
 * ���룺root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
 * �����1
 * ���ͣ�Ψһ�ĺ�Ҷ�ӽڵ���� [2,5] ��
 * ʾ�� 4��
 * <p>
 * ���룺root = [100], distance = 1
 * �����0
 * ʾ�� 5��
 * <p>
 * ���룺root = [1,1,1], distance = 2
 * �����1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * tree �Ľڵ����� [1, 2^10] ��Χ�ڡ�
 * ÿ���ڵ��ֵ���� [1, 100] ֮�䡣
 * 1 <= distance <= 10
 * ͨ������7,488�ύ����13,588
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountPairs {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countPairs(TreeNode root, int distance) {
        return traverse(root, distance);
    }

    private int traverse(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }
        int curCount = calculateCurRoot(root, distance);
        int leftCount = traverse(root.left, distance);
        int rightCount = traverse(root.right, distance);
        return curCount + leftCount + rightCount;
    }

    private int calculateCurRoot(TreeNode root, int distance) {
        int count = 0;
        List<Integer> leftDepth = new ArrayList<>();
        List<Integer> rightDepth = new ArrayList<>();
        childrenDepth(root.left, distance, 1, leftDepth);
        childrenDepth(root.right, distance, 1, rightDepth);
        for (int left : leftDepth) {
            for (int right : rightDepth) {
                if (left + right <= distance) {
                    count++;
                }
            }
        }
        return count;

    }

    private void childrenDepth(TreeNode root, int distance, int depth, List<Integer> leaf) {
        if (root == null) {
            return;
        }
        if (depth > distance) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaf.add(depth);
            return;
        }
        childrenDepth(root.left, distance, depth + 1, leaf);
        childrenDepth(root.right, distance, depth + 1, leaf);
    }
}
