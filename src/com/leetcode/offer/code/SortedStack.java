package com.leetcode.offer.code;

import java.util.Stack;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek?返回 -1。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * 示例2:
 * <p>
 * 输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * 输出：
 * [null,null,null,null,null,true]
 * 说明:
 * <p>
 * 栈中的元素数目在[0, 5000]范围内。
 * 通过次数2,031提交次数3,835
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> buffer;

    public SortedStack() {
        stack = new Stack<>();
        buffer = new Stack<>();
    }

    public void push(int val) {
        while (!stack.isEmpty() && val > stack.peek()) {
            buffer.push(stack.pop());
        }
        stack.push(val);
        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}