package com.leetcode.offer.day35;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author duson
 * 我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 * <p>
 * 实现一个叫「餐盘」的类 DinnerPlates：
 * <p>
 * DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
 * void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
 * int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
 * int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * 输出：
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 * <p>
 * 解释：
 * DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
 * D.push(1);
 * D.push(2);
 * D.push(3);
 * D.push(4);
 * D.push(5);         // 栈的现状为：    2  4
 *                                     1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 2。栈的现状为：      4
 *                               1  3  5
 * ﹈ ﹈ ﹈
 * D.push(20);        // 栈的现状为：  20  4
 *                                    1  3  5
 * ﹈ ﹈ ﹈
 * D.push(21);        // 栈的现状为：  20  4 21
 *                                    1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
 *                                1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(2);   // 返回 21。栈的现状为：       4
 *                                1  3  5
 * ﹈ ﹈ ﹈
 * D.pop()            // 返回 5。栈的现状为：        4
 *                                1  3
 * ﹈ ﹈
 * D.pop()            // 返回 4。栈的现状为：    1  3
 * ﹈ ﹈
 * D.pop()            // 返回 3。栈的现状为：    1
 * ﹈
 * D.pop()            // 返回 1。现在没有栈。
 * D.pop()            // 返回 -1。仍然没有栈。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * 最多会对 push，pop，和 popAtStack 进行 200000 次调用。
 * 在真实的面试中遇到过这道题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dinner-plate-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DinnerPlates {

    private List<Stack<Integer>> stacks = new ArrayList<>();

    private int capacity;

    private int left;

    private int right;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
    }

    public void push(int val) {
        if (stacks.isEmpty()) {
            stacks.add(new Stack<>());
            left = 0;
            right = 0;
        }
        while (left < stacks.size() && stacks.get(left).size() == capacity) {
            left++;
        }
        if (stacks.size() == left) {
            stacks.add(new Stack<>());
            right = left;
        }
        stacks.get(left).push(val);
    }

    public int pop() {
        while (right >= 0 && stacks.get(right).isEmpty()) {
            right--;
        }
        if (right == -1) {
            right = 0;
            return -1;
        }
        return stacks.get(right).pop();
    }

    public int popAtStack(int index) {
        if (stacks.size() <= index || stacks.get(index).isEmpty()) {
            return -1;
        }
        left = Math.min(left, index);
        return stacks.get(index).pop();
    }

    public static void main(String[] args) {
        //["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
        //[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]

        //[null,null,null,null,null,null,2,null,null,20,21,1,4,3,5,-1]
        //[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]

        DinnerPlates dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.push(3);
        dinnerPlates.push(4);
        dinnerPlates.push(5);
        System.out.println(dinnerPlates.popAtStack(0));

        dinnerPlates.push(20);
        dinnerPlates.push(21);

        System.out.println(dinnerPlates.popAtStack(0));
        System.out.println(dinnerPlates.popAtStack(2));
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
    }
}
