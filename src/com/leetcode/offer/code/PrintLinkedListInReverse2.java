package com.leetcode.offer.code;

/**
 * @author duson
 * 给您一个不可变的链表，使用下列接口逆序打印每个节点的值：
 * <p>
 * ImmutableListNode: 描述不可变链表的接口，链表的头节点已给出。
 * 您需要使用以下函数来访问此链表（您 不能 直接访问 ImmutableListNode）：
 * <p>
 * ImmutableListNode.printValue()：打印当前节点的值。
 * ImmutableListNode.getNext()：返回下一个节点。
 * 输入只用来内部初始化链表。您不可以通过修改链表解决问题。也就是说，您只能通过上述 API 来操作链表。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 您是否可以：
 * <p>
 * 使用常数级空间复杂度解决问题？
 * 使用线性级时间复杂度和低于线性级空间复杂度解决问题？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[4,3,2,1]
 * 示例 2：
 * <p>
 * 输入：head = [0,-4,-1,3,-5]
 * 输出：[-5,3,-1,-4,0]
 * 示例 3：
 * <p>
 * 输入：head = [-2,0,6,4,4,-6]
 * 输出：[-6,4,4,6,0,-2]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表的长度在 [1, 1000] 之间。
 * 每个节点的值在 [-1000, 1000] 之间。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-immutable-linked-list-in-reverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrintLinkedListInReverse2 {

    /**
     * // This is the ImmutableListNode's API interface.
     * // You should not implement it, or speculate about its implementation.
     * interface ImmutableListNode {
     *     public void printValue(); // print the value of this node.
     *     public ImmutableListNode getNext(); // return the next node.
     * };
     */

//    public void printLinkedListInReverse(ImmutableListNode head) {
//        Stack<ImmutableListNode> s = new Stack<>();
//        while (head != null) {
//            s.push(head);
//            head = head.getNext();
//        }
//        ImmutableListNode newNode;
//        while (!s.isEmpty()) {
//            newNode = s.pop();
//            newNode.printValue();
//            newNode = newNode.getNext();
//        }
//    }
}
