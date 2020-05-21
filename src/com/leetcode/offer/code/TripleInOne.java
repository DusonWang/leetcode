package com.leetcode.offer.code;

/**
 * ����һ���������ֻ��һ��������ʵ������ջ��
 * <p>
 * ��Ӧ��ʵ��push(stackNum, value)��pop(stackNum)��isEmpty(stackNum)��peek(stackNum)������stackNum��ʾջ�±꣬value��ʾѹ���ֵ��
 * <p>
 * ���캯���ᴫ��һ��stackSize����������ÿ��ջ�Ĵ�С��
 * <p>
 * ʾ��1:
 * <p>
 * ���룺
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * �����
 * [null, null, null, 1, -1, -1, true]
 * ˵������ջΪ��ʱ`pop, peek`����-1����ջ��ʱ`push`��ѹ��Ԫ�ء�
 * ʾ��2:
 * <p>
 * ���룺
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * �����
 * [null, null, null, null, 2, 1, -1, -1]
 * ͨ������1,860�ύ����3,434
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/three-in-one-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class TripleInOne {

    private final int[] arr;
    private final int size;

    public TripleInOne(int stackSize) {
        arr = new int[3 + 3 * stackSize];
        size = stackSize;
    }

    public void push(int stackNum, int value) {
        if (arr[stackNum] == size) {
            return;
        }
        arr[stackNum * size + 3 + arr[stackNum]++] = value;
    }

    public int pop(int stackNum) {
        if (arr[stackNum] == 0) {
            return -1;
        }
        return arr[stackNum * size + 3 + --arr[stackNum]];
    }

    public int peek(int stackNum) {
        if (arr[stackNum] == 0) {
            return -1;
        }
        return arr[stackNum * size + 3 + arr[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return arr[stackNum] == 0;
    }
}
