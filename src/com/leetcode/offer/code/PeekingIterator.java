package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author duson
 * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 * <p>
 * 示例:
 * <p>
 * 假设迭代器被初始化为列表 [1,2,3]。
 * <p>
 * 调用 next() 返回 1，得到列表中的第一个元素。
 * 现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
 * 最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
 * 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peeking-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PeekingIterator implements Iterator<Integer> {

    private int[] array;
    private int index = 0;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        List<Integer> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        int size = list.size();
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return array[index];
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasNext()) {
            return array[index++];
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }
}