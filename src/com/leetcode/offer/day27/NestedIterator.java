package com.leetcode.offer.day27;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author duson
 * 给定一个嵌套的整型列表。设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的项或者为一个整数，或者是另一个列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 * <p>
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,4,6]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NestedIterator implements Iterator<Integer> {

    public interface NestedInteger {

        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    private List<Integer> list;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = convert(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    private List<Integer> convert(List<NestedInteger> nestedList) {
        ArrayList<Integer> list = new ArrayList<>(nestedList.size());
        for (NestedInteger tmp : nestedList) {
            if (tmp.isInteger()) {
                list.add(tmp.getInteger());
            } else {
                list.addAll(convert(tmp.getList()));
            }
        }
        return list;
    }
}
