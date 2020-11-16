package code.code;

/**
 * @author duson
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveElements {

    public static class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        ListNode iter = dumb;
        while (iter.next != null) {
            ListNode curr = iter.next;
            if (curr.val == val) {
                iter.next = curr.next;
                continue;
            }
            iter = iter.next;
        }
        return dumb.next;
    }

    public static void main(String[] args) {
        //1->2->6->3->4->5->6
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);

        RemoveElements removeElements = new RemoveElements();
        listNode = removeElements.removeElements(listNode, 1);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}
