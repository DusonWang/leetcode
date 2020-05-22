package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ����һ�ö����������һ���㷨����������ĳһ��������нڵ���������磬��һ���������Ϊ D����ᴴ���� D ������������һ������������ȵ���������顣
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺[1,2,3,4,5,null,7,8]
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * <p>
 * �����[[1],[2,3],[4,5,7],[8]]
 * ͨ������3,303�ύ����4,061
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/list-of-depth-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ListOfDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        List<ListNode> resArr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode node = new ListNode(0);
            ListNode head = node;
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                ListNode n = new ListNode(p.val);
                node.next = n;
                node = n;
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
            resArr.add(head.next);
        }
        return resArr.toArray(new ListNode[0]);
    }
}
