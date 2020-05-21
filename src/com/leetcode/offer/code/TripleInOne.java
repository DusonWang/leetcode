package com.leetcode.offer.code;

/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * <p>
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 * 通过次数1,860提交次数3,434
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
