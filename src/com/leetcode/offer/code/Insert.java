package com.leetcode.offer.code;

/**
 * @author duson
 * 给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素，使这个列表仍然是循环升序的。给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * <p>
 * 如果有多个满足条件的插入位置，你可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * <p>
 * 如果列表为空（给定的节点是 null），你需要创建一个循环有序列表并返回这个点。否则。请返回原先给定的节点。
 * <p>
 * 下面的例子可以帮你更好的理解这个问题：
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2。
 * <p>
 *  
 * <p>
 * <p>
 *  
 * <p>
 * 新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3。
 * <p>
 * 通过次数451提交次数1,584
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Insert {

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node result = new Node(insertVal);
            result.next = result;
            return result;
        }
        Node node = head;
        while (node.next != head) {
            if (node.val <= insertVal && insertVal <= node.next.val) {
                break;
            } else if (node.val <= insertVal && node.val > node.next.val) {
                break;
            } else if (node.next.val >= insertVal && node.val > node.next.val) {
                break;
            } else {
                node = node.next;
            }
        }
        Node inserted = new Node(insertVal);
        inserted.next = node.next;
        node.next = inserted;
        return head;
    }
}
