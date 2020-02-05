package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * 序列化是指将一个数据结构转化为位序列的过程，因此可以将其存储在文件中或内存缓冲区中，以便稍后在相同或不同的计算机环境中恢复结构。
 * <p>
 * 设计一个序列化和反序列化 N 叉树的算法。一个 N 叉树是指每个节点都有不超过 N 个孩子节点的有根树。序列化 / 反序列化算法的算法实现没有限制。你只需要保证 N 叉树可以被序列化为一个字符串并且该字符串可以被反序列化成原树结构即可。
 * <p>
 * 例如，你需要序列化下面的 3-叉 树。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 为 [1 [3[5 6] 2 4]]。你不需要以这种形式完成，你可以自己创造和实现不同的方法。
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * N 的范围在 [1, 1000]
 * 不要使用类成员 / 全局变量 / 静态变量来存储状态。你的序列化和反序列化算法应是无状态的。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec5 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(",");
        sb.append(root.children.size()).append(",");
        for (Node child : root.children) {
            serializeHelper(child, sb);
        }
    }

    public Node deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private Node deserializeHelper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        int val = Integer.parseInt(queue.poll());
        if (queue.isEmpty()) {
            return null;
        }
        int size = Integer.parseInt(queue.poll());
        Node root = new Node(val, new ArrayList<>());
        for (int i = 0; i < size; i++) {
            root.children.add(deserializeHelper(queue));
        }
        return root;
    }
}
