package com.leetcode.offer.sword;

/**
 * @author duson
 */
public class ReverseList {

    private static ListNode reverse(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode reverseHead = null;
        ListNode preNode = null;
        ListNode pNode = listNode;
        while (pNode != null) {
            ListNode pNextNode = pNode.nextNode;
            if (pNextNode == null) {
                reverseHead = pNode;
            }
            pNode.nextNode = preNode;
            preNode = pNode;
            pNode = pNextNode;
        }
        return reverseHead;
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

        ListNode listNodeTmp = listNode;

        int i = 0;
        System.out.println("reverse before order is ");
        while (listNode != null) {
            System.out.println((i++) + "<>" + listNode.getValue());
            listNode = listNode.nextNode;
        }

        ListNode newListNode = reverse(listNodeTmp);

        System.out.println("reverse after order is ");
        i = 0;
        while (newListNode != null) {
            System.out.println((i++) + "<>" + newListNode.getValue());
            newListNode = newListNode.nextNode;
        }
    }

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
}
