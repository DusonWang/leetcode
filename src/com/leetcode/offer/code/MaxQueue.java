package com.leetcode.offer.code;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duson
 * �붨��һ�����в�ʵ�ֺ��� max_value �õ�����������ֵ��Ҫ����max_value��push_back �� pop_front �ľ�̯ʱ�临�Ӷȶ���O(1)��
 * <p>
 * ������Ϊ�գ�pop_front �� max_value?��Ҫ���� -1
 * <p>
 * ʾ�� 1��
 * <p>
 * ����:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * ���:?[null,null,null,2,1,2]
 * ʾ�� 2��
 * <p>
 * ����:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * ���:?[null,-1,-1]
 * ?
 * <p>
 * ���ƣ�
 * <p>
 * 1 <= push_back,pop_front,max_value���ܲ�����?<= 10000
 * 1 <= value <= 10^5
 * ͨ������22,848�ύ����47,087
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxQueue {

    private final Queue<Integer> queue;
    private final Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int value = queue.poll();
        if (maxQueue.peekFirst() != null
                && maxQueue.peekFirst() == value) {
            maxQueue.pollFirst();
        }
        return value;
    }
}
