package com.leetcode.offer.code;

/**
 * @author duson
 * �������һ��֧������������ջ��
 * <p>
 * ʵ���Զ���ջ�� CustomStack ��
 * <p>
 * CustomStack(int maxSize)���� maxSize ��ʼ������maxSize ��ջ����������ɵ�Ԫ��������ջ�������� maxSize ֮����֧�� push ������
 * void push(int x)�����ջ��δ������ maxSize ���ͽ� x ��ӵ�ջ����
 * int pop()������ջ��Ԫ�أ�������ջ����ֵ����ջΪ��ʱ���� -1 ��
 * void inc(int k, int val)��ջ�׵� k ��Ԫ�ص�ֵ������ val �����ջ��Ԫ������С�� k ����ջ�е�����Ԫ�ض����� val ��
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺
 * ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
 * [[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
 * �����
 * [null,null,null,2,null,null,null,null,null,103,202,201,-1]
 * ���ͣ�
 * CustomStack customStack = new CustomStack(3); // ջ�ǿյ� []
 * customStack.push(1);                          // ջ��Ϊ [1]
 * customStack.push(2);                          // ջ��Ϊ [1, 2]
 * customStack.pop();                            // ���� 2 --> ����ջ��ֵ 2��ջ��Ϊ [1]
 * customStack.push(2);                          // ջ��Ϊ [1, 2]
 * customStack.push(3);                          // ջ��Ϊ [1, 2, 3]
 * customStack.push(4);                          // ջ��Ȼ�� [1, 2, 3]�������������Ԫ��ʹջ��С��Ϊ 4
 * customStack.increment(5, 100);                // ջ��Ϊ [101, 102, 103]
 * customStack.increment(2, 100);                // ջ��Ϊ [201, 202, 103]
 * customStack.pop();                            // ���� 103 --> ����ջ��ֵ 103��ջ��Ϊ [201, 202]
 * customStack.pop();                            // ���� 202 --> ����ջ��ֵ 202��ջ��Ϊ [201]
 * customStack.pop();                            // ���� 201 --> ����ջ��ֵ 201��ջ��Ϊ []
 * customStack.pop();                            // ���� -1 --> ջΪ�գ����� -1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= maxSize <= 1000
 * 1 <= x <= 1000
 * 1 <= k <= 1000
 * 0 <= val <= 100
 * ÿ�ַ��� increment��push �Լ� pop �ֱ������� 1000 ��
 * ͨ������4,292�ύ����5,854
 * ����ʵ������������������⣿
 * <p>
 * ��
 * <p>
 * <p>
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/design-a-stack-with-increment-operation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CustomStack {

    private final int[] stack;
    private int size = 0;

    private final int[] increment;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        increment = new int[maxSize + 1];
    }

    public void push(int x) {
        if (size == stack.length) {
            return;
        }
        stack[size++] = x;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        int val = stack[size - 1];
        if (increment[size] != 0) {
            val += increment[size];
            increment[size - 1] += increment[size];
            increment[size] = 0;
        }
        size--;
        return val;
    }

    public void increment(int k, int val) {
        int t = Math.min(k, size);
        increment[t] += val;
    }
}
