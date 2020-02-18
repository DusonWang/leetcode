package com.leetcode.offer.code;

/**
 * @author duson
 * 510. 二叉搜索树中的中序后继 II
 * 给定一棵二叉搜索树和其中的一个节点，找到该节点在树中的中序后继。
 * <p>
 * 一个结点 p 的中序后继是键值比 p.val大所有的结点中键值最小的那个。
 * <p>
 * 你可以直接访问结点，但无法直接访问树。每个节点都会有其父节点的引用。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入:
 * root = {"$id":"1","left":{"$id":"2","left":null,"parent":{"$ref":"1"},"right":null,"val":1},"parent":null,"right":{"$id":"3","left":null,"parent":{"$ref":"1"},"right":null,"val":3},"val":2}
 * p = 1
 * 输出: 2
 * 解析: 1的中序后继结点是2。注意p和返回值都是Node类型的。
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入:
 * root = {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":{"$id":"4","left":null,"parent":{"$ref":"3"},"right":null,"val":1},"parent":{"$ref":"2"},"right":null,"val":2},"parent":{"$ref":"1"},"right":{"$id":"5","left":null,"parent":{"$ref":"2"},"right":null,"val":4},"val":3},"parent":null,"right":{"$id":"6","left":null,"parent":{"$ref":"1"},"right":null,"val":6},"val":5}
 * p = 6
 * 输出: null
 * 解析: 该结点没有中序后继，因此返回null。
 * 示例 3:
 * <p>
 * <p>
 * <p>
 * 输入:
 * root = {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":{"$id":"4","left":null,"parent":{"$ref":"3"},"right":null,"val":2},"parent":{"$ref":"2"},"right":{"$id":"5","left":null,"parent":{"$ref":"3"},"right":null,"val":4},"val":3},"parent":{"$ref":"1"},"right":{"$id":"6","left":null,"parent":{"$ref":"2"},"right":{"$id":"7","left":{"$id":"8","left":null,"parent":{"$ref":"7"},"right":null,"val":9},"parent":{"$ref":"6"},"right":null,"val":13},"val":7},"val":6},"parent":null,"right":{"$id":"9","left":{"$id":"10","left":null,"parent":{"$ref":"9"},"right":null,"val":17},"parent":{"$ref":"1"},"right":{"$id":"11","left":null,"parent":{"$ref":"9"},"right":null,"val":20},"val":18},"val":15}
 * p = 15
 * 输出: 17
 * 示例 4:
 * <p>
 * <p>
 * <p>
 * 输入:
 * root = {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":{"$id":"4","left":null,"parent":{"$ref":"3"},"right":null,"val":2},"parent":{"$ref":"2"},"right":{"$id":"5","left":null,"parent":{"$ref":"3"},"right":null,"val":4},"val":3},"parent":{"$ref":"1"},"right":{"$id":"6","left":null,"parent":{"$ref":"2"},"right":{"$id":"7","left":{"$id":"8","left":null,"parent":{"$ref":"7"},"right":null,"val":9},"parent":{"$ref":"6"},"right":null,"val":13},"val":7},"val":6},"parent":null,"right":{"$id":"9","left":{"$id":"10","left":null,"parent":{"$ref":"9"},"right":null,"val":17},"parent":{"$ref":"1"},"right":{"$id":"11","left":null,"parent":{"$ref":"9"},"right":null,"val":20},"val":18},"val":15}
 * p = 13
 * 输出: 15
 * <p>
 * <p>
 * 注意:
 * <p>
 * 如果给定结点不存在中序后继，返回null。
 * 树中各结点的值均保证唯一。
 * <font color="#333333" face="Helvetica Neue, Helvetica, Arial, sans-serif">注意我们使用的是</font>Node类型而不是TreeNode类型，它们的字符串表示不一样。
 * <p>
 * <p>
 * 延伸:
 * <p>
 * 你能否在不访问任何结点的值的情况下解决问题?
 * <p>
 * 通过次数451提交次数781
 * 在真实的面试中遇到过这道题？
 * <p>
 * 是
 * <p>
 * 否
 */
public class InorderSuccessor2 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node x) {
        if (x.right != null) {
            Node cur = x.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            Node parent = x.parent;
            while (parent != null && parent.left != x) {
                x = parent;
                parent = x.parent;
            }
            return parent;
        }
    }
}
