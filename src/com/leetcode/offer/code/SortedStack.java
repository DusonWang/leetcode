package com.leetcode.offer.code;

import java.util.Stack;

/**
 * ջ���� ��д���򣬶�ջ��������ʹ��СԪ��λ��ջ�������ֻ��ʹ��һ����������ʱջ������ݣ������ý�Ԫ�ظ��Ƶ�������ݽṹ�������飩�С���ջ֧�����²�����push��pop��peek �� isEmpty����ջΪ��ʱ��peek?���� -1��
 * <p>
 * ʾ��1:
 * <p>
 * ���룺
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * �����
 * [null,null,null,1,null,2]
 * ʾ��2:
 * <p>
 * ���룺
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * �����
 * [null,null,null,null,null,true]
 * ˵��:
 * <p>
 * ջ�е�Ԫ����Ŀ��[0, 5000]��Χ�ڡ�
 * ͨ������2,031�ύ����3,835
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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