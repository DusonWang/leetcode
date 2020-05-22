package com.leetcode.offer.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 * <p>
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * <p>
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * 输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * 示例2:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * 输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * 说明:
 * <p>
 * 收纳所的最大容量为20000
 * 通过次数1,955提交次数3,234
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/animal-shelter-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
