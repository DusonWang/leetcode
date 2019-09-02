package com.leetcode.offer.day27;

/**
 * @author duson
 * 设计一个最大栈，支持 push、pop、top、peekMax 和 popMax 操作。
 * <p>
 *  
 * <p>
 * push(x) -- 将元素 x 压入栈中。
 * pop() -- 移除栈顶元素并返回这个值。
 * top() -- 返回栈顶元素。
 * peekMax() -- 返回栈中最大元素。
 * popMax() -- 返回栈中最大的元素，并将其删除。如果有多个最大元素，只要删除最靠近栈顶的那个。
 *  
 * <p>
 * 样例 1:
 * <p>
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 *  
 * <p>
 * 注释:
 * <p>
 * -1e7 <= x <= 1e7
 * 操作次数不会超过 10000。
 * 当栈为空的时候不会出现后四个操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxStack {
}
