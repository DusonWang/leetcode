package code.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ���һ�ö���������������������������Գ�Ϊ ��ż�� ��
 * <p>
 * ���������ڵ����ڲ��±�Ϊ 0 �������ӽڵ����ڲ��±�Ϊ 1 ��������ڵ����ڲ��±�Ϊ 2 ���������ơ�
 * ż���±� ���ϵ����нڵ��ֵ���� �� �����������Ұ�˳�� �ϸ����
 * �����±� ���ϵ����нڵ��ֵ���� ż �����������Ұ�˳�� �ϸ�ݼ�
 * ����������ĸ��ڵ㣬���������Ϊ ��ż�� ���򷵻� true �����򷵻� false ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * �����true
 * ���ͣ�ÿһ��Ľڵ�ֵ�ֱ��ǣ�
 * 0 �㣺[1]
 * 1 �㣺[10,4]
 * 2 �㣺[3,7,9]
 * 3 �㣺[12,8,6,2]
 * ���� 0 ��� 2 ���ϵĽڵ�ֵ�����������ϸ�������� 1 ��� 3 ���ϵĽڵ�ֵ����ż�����ϸ�ݼ����������һ����ż����
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺root = [5,4,2,3,3,7]
 * �����false
 * ���ͣ�ÿһ��Ľڵ�ֵ�ֱ��ǣ�
 * 0 �㣺[5]
 * 1 �㣺[4,2]
 * 2 �㣺[3,3,7]
 * 2 ���ϵĽڵ�ֵ�������ϸ�����������������ⲻ��һ����ż����
 * ʾ�� 3��
 * <p>
 * <p>
 * <p>
 * ���룺root = [5,9,1,3,5,7]
 * �����false
 * ���ͣ�1 ���ϵĽڵ�ֵӦΪż����
 * ʾ�� 4��
 * <p>
 * ���룺root = [1]
 * �����true
 * ʾ�� 5��
 * <p>
 * ���룺root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
 * �����true
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * ���нڵ����ڷ�Χ [1, 105] ��
 * 1 <= Node.val <= 106
 * ͨ������6,071�ύ����11,756
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/even-odd-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsEvenOddTree {

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

    public boolean isEvenOddTree(TreeNode root) {
        List<LinkedList<Integer>> levList = new ArrayList<>();
        return levelOrder(root, levList, 0);
    }

    private boolean levelOrder(TreeNode root, List<LinkedList<Integer>> levList, int level) {
        if (root == null) {
            return true;
        }
        if (levList.size() < level + 1) {
            levList.add(new LinkedList<>());
        }
        if (level % 2 == 0) {
            if (root.val % 2 == 0 || !levList.get(level).isEmpty() && root.val <= levList.get(level).getLast()) {
                return false;
            }
        } else {
            if (root.val % 2 == 1 || !levList.get(level).isEmpty() && root.val >= levList.get(level).getLast()) {
                return false;
            }
        }
        levList.get(level).add(root.val);
        return levelOrder(root.left, levList, level + 1)
                && levelOrder(root.right, levList, level + 1);
    }

    public boolean isEvenOddTree2(TreeNode root) {
        boolean flag = false;
        int top = -1;
        int index = -1;
        TreeNode[] queue = new TreeNode[100001];
        queue[++top] = root;
        while (index != top) {
            int max = flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            int len = top - index;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue[++index];
                if (node.left != null) {
                    queue[++top] = node.left;
                }
                if (node.right != null) {
                    queue[++top] = node.right;
                }
                if (flag) {
                    if ((node.val & 1) == 1) {
                        return false;
                    } else if (node.val < max) {
                        max = node.val;
                    } else {
                        return false;
                    }
                } else {
                    if ((node.val & 1) == 0) {
                        return false;
                    } else if (node.val > max) {
                        max = node.val;
                    } else {
                        return false;
                    }
                }
            }
            flag = !flag;
        }
        return true;
    }
}
