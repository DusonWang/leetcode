package com.leetcode.offer.day32;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author duson
 * 给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * v1 = [1,2]
 * v2 = [3,4,5,6]
 * <p>
 * 输出: [1,3,2,4,5,6]
 * <p>
 * 解析: 通过连续调用 next 函数直到 hasNext 函数返回 false，
 *      next 函数返回值的次序应依次为: [1,3,2,4,5,6]。
 * 拓展：假如给你 k 个一维向量呢？你的代码在这种情况下的扩展性又会如何呢?
 * <p>
 * 拓展声明：
 *  “锯齿” 顺序对于 k > 2 的情况定义可能会有些歧义。所以，假如你觉得 “锯齿” 这个表述不妥，也可以认为这是一种 “循环”。例如：
 * <p>
 * 输入:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * <p>
 * 输出: [1,4,8,2,5,9,3,6,7].
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigzagIterator {

    private LinkedList<Iterator<Integer>> list;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        Iterator<Integer> it1 = v1.iterator();
        Iterator<Integer> it2 = v2.iterator();
        if (it1.hasNext()) {
            list.add(it1);
        }
        if (it2.hasNext()) {
            list.add(it2);
        }
    }

    public int next() {
        Iterator<Integer> it = list.poll();
        if (it == null) {
            return -1;
        }
        int v = it.next();
        if (it.hasNext()) {
            list.add(it);
        }
        return v;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
