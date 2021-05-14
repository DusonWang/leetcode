package code.code;

import java.util.LinkedList;
import java.util.List;

/**
 * �������һ�����У�֧����ǰ���У�������λ�õ� push?�� pop?������
 * <p>
 * �������?FrontMiddleBack?�ࣺ
 * <p>
 * FrontMiddleBack()?��ʼ�����С�
 * void pushFront(int val) ��?val?��ӵ����е� ��ǰ��?��
 * void pushMiddle(int val) ��?val?��ӵ����е� ���м�?��
 * void pushBack(int val)?��?val?��ӵ������ �����?��
 * int popFront()?�� ��ǰ�� ��Ԫ�شӶ�����ɾ��������ֵ�����ɾ��֮ǰ����Ϊ�գ���ô���� -1?��
 * int popMiddle() �� ���м�?��Ԫ�شӶ�����ɾ��������ֵ�����ɾ��֮ǰ����Ϊ�գ���ô���� -1?��
 * int popBack() �� ����� ��Ԫ�شӶ�����ɾ��������ֵ�����ɾ��֮ǰ����Ϊ�գ���ô���� -1?��
 * ��ע�⵱��?����?�м�λ�õ�ʱ��ѡ��ǰ���λ�ý��в������ȷ�˵��
 * <p>
 * �� 6?��ӵ�?[1, 2, 3, 4, 5]?���м�λ�ã��������Ϊ?[1, 2, 6, 3, 4, 5]?��
 * ��?[1, 2, 3, 4, 5, 6]?���м�λ�õ���Ԫ�أ�����?3?�������Ϊ?[1, 2, 4, 5, 6]?��
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺
 * ["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
 * [[], [1], [2], [3], [4], [], [], [], [], []]
 * �����
 * [null, null, null, null, null, 1, 3, 4, 2, -1]
 * <p>
 * ���ͣ�
 * FrontMiddleBackQueue q = new FrontMiddleBackQueue();
 * q.pushFront(1);   // [1]
 * q.pushBack(2);    // [1, 2]
 * q.pushMiddle(3);  // [1, 3, 2]
 * q.pushMiddle(4);  // [1, 4, 3, 2]
 * q.popFront();     // ���� 1 -> [4, 3, 2]
 * q.popMiddle();    // ���� 3 -> [4, 2]
 * q.popMiddle();    // ���� 4 -> [2]
 * q.popBack();      // ���� 2 -> []
 * q.popFront();     // ���� -1 -> [] ������Ϊ�գ�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= val <= 109
 * ������?1000?��?pushFront��?pushMiddle��?pushBack��?popFront��?popMiddle?��?popBack ��
 * ͨ������3,314�ύ����6,245
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/design-front-middle-back-queue
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FrontMiddleBackQueue {

    private final List<Integer> list;

    public FrontMiddleBackQueue() {
        list = new LinkedList<>();
    }

    public void pushFront(int val) {
        if (list.isEmpty()) {
            list.add(val);
            return;
        }
        list.add(0, val);
    }

    public void pushMiddle(int val) {
        if (list.isEmpty()) {
            list.add(val);
            return;
        }
        int size = list.size();
        list.add(size / 2, val);
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(0);
    }

    public int popMiddle() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove((list.size() - 1) / 2);
    }

    public int popBack() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q.popFront());     // ���� 1 -> [4, 3, 2]
        System.out.println(q.popMiddle());    // ���� 3 -> [4, 2]
        System.out.println(q.popMiddle());    // ���� 4 -> [2]
        System.out.println(q.popBack());      // ���� 2 -> []
        System.out.println(q.popFront());     // ���� -1 -> [] ������Ϊ�գ�
    }
}
