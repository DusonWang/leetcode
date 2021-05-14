package code.code;

import java.util.LinkedList;
import java.util.List;

/**
 * 请你设计一个队列，支持在前，中，后三个位置的 push?和 pop?操作。
 * <p>
 * 请你完成?FrontMiddleBack?类：
 * <p>
 * FrontMiddleBack()?初始化队列。
 * void pushFront(int val) 将?val?添加到队列的 最前面?。
 * void pushMiddle(int val) 将?val?添加到队列的 正中间?。
 * void pushBack(int val)?将?val?添加到队里的 最后面?。
 * int popFront()?将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1?。
 * int popMiddle() 将 正中间?的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1?。
 * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1?。
 * 请注意当有?两个?中间位置的时候，选择靠前面的位置进行操作。比方说：
 * <p>
 * 将 6?添加到?[1, 2, 3, 4, 5]?的中间位置，结果数组为?[1, 2, 6, 3, 4, 5]?。
 * 从?[1, 2, 3, 4, 5, 6]?的中间位置弹出元素，返回?3?，数组变为?[1, 2, 4, 5, 6]?。
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
 * [[], [1], [2], [3], [4], [], [], [], [], []]
 * 输出：
 * [null, null, null, null, null, 1, 3, 4, 2, -1]
 * <p>
 * 解释：
 * FrontMiddleBackQueue q = new FrontMiddleBackQueue();
 * q.pushFront(1);   // [1]
 * q.pushBack(2);    // [1, 2]
 * q.pushMiddle(3);  // [1, 3, 2]
 * q.pushMiddle(4);  // [1, 4, 3, 2]
 * q.popFront();     // 返回 1 -> [4, 3, 2]
 * q.popMiddle();    // 返回 3 -> [4, 2]
 * q.popMiddle();    // 返回 4 -> [2]
 * q.popBack();      // 返回 2 -> []
 * q.popFront();     // 返回 -1 -> [] （队列为空）
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= val <= 109
 * 最多调用?1000?次?pushFront，?pushMiddle，?pushBack，?popFront，?popMiddle?和?popBack 。
 * 通过次数3,314提交次数6,245
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-front-middle-back-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        System.out.println(q.popFront());     // 返回 1 -> [4, 3, 2]
        System.out.println(q.popMiddle());    // 返回 3 -> [4, 2]
        System.out.println(q.popMiddle());    // 返回 4 -> [2]
        System.out.println(q.popBack());      // 返回 2 -> []
        System.out.println(q.popFront());     // 返回 -1 -> [] （队列为空）
    }
}
