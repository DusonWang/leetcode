package com.leetcode.offer.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �������������мҶ���������ֻ���ݹ���è�����ϸ����ء��Ƚ��ȳ�����ԭ�����������������Ķ���ʱ��������ֻ���������ж����С����ϡ������������������ʱ�䳤�̶������Ķ�����߿�����ѡè�򹷣�ͬʱ�����������ද���С����ϡ��ģ�������֮�������˲���������ѡ�������Ķ����봴�����������ϵͳ�����ݽṹ��ʵ�ָ��ֲ�������������enqueue��dequeueAny��dequeueDog��dequeueCat������ʹ��Java���õ�LinkedList���ݽṹ��
 * <p>
 * enqueue������һ��animal������animal[0]�������ţ�animal[1]���������࣬���� 0 ����è��1 ������
 * <p>
 * dequeue*��������һ���б�[������, ��������]����û�п��������Ķ���򷵻�[-1,-1]��
 * <p>
 * ʾ��1:
 * <p>
 * ���룺
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * �����
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * ʾ��2:
 * <p>
 * ���룺
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * �����
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * ˵��:
 * <p>
 * ���������������Ϊ20000
 * ͨ������1,955�ύ����3,234
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/animal-shelter-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * @author duson
 */
public class AnimalShelf {

    private final Queue<int[]> q1;
    private final Queue<int[]> q2;

    public AnimalShelf() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            q1.offer(animal);
        } else {
            q2.offer(animal);
        }
    }

    public int[] dequeueAny() {
        if (q1.isEmpty() && q2.isEmpty()) {
            return new int[]{-1, -1};
        }
        if (q1.isEmpty() || q2.isEmpty()) {
            return q1.isEmpty() ? q2.poll() : q1.poll();
        }
        int[] te1 = q1.peek();
        int[] te2 = q2.peek();
        if (te1[0] < te2[0]) {
            return q1.poll();
        } else {
            return q2.poll();
        }
    }

    public int[] dequeueDog() {
        if (q2.isEmpty()) {
            return new int[]{-1, -1};
        }
        return q2.poll();
    }

    public int[] dequeueCat() {
        if (q1.isEmpty()) {
            return new int[]{-1, -1};
        }
        return q1.poll();
    }

}
