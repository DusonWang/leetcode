package code.sword;

/**
 * @author duson
 */
public class FindKthToTail {

    public static class ListNode {

        private int value;

        private ListNode nextNode;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }
    }

    private static ListNode findKthToTail(ListNode listNode, int k) {
        if (listNode == null || k <= 0) {
            return null;
        }

        ListNode ahead = listNode;
        ListNode behind;
        for (int i = 0; i < k - 1; i++) {
            ahead = ahead.nextNode;
        }

        behind = listNode;
        while (ahead.nextNode != null) {
            ahead = ahead.nextNode;
            behind = behind.nextNode;
        }
        return behind;
    }

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode();
        listNode4.setValue(4);

        ListNode listNode5 = new ListNode();
        listNode5.setValue(5);

        ListNode listNode2 = new ListNode();
        listNode2.setValue(2);

        ListNode listNode3 = new ListNode();
        listNode3.setValue(3);

        ListNode listNode1 = new ListNode();
        listNode1.setValue(1);

        ListNode listNode = new ListNode();
        listNode.setValue(0);

        listNode5.setNextNode(null);
        listNode4.setNextNode(listNode5);
        listNode3.setNextNode(listNode4);
        listNode2.setNextNode(listNode3);
        listNode1.setNextNode(listNode2);
        listNode.setNextNode(listNode1);


        System.out.println("k==2 node is " + findKthToTail(listNode, 2).getValue());
        System.out.println("k==3 node is " + findKthToTail(listNode, 3).getValue());
        System.out.println("k==3 node is " + findKthToTail(listNode, 1).getValue());

        int i = 0;
        while (listNode != null) {
            System.out.println((i++) + "<>" + listNode.getValue());
            listNode = listNode.nextNode;
        }

    }
}
