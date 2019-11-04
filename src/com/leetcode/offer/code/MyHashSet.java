package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 不使用任何内建的哈希表库设计一个哈希集合
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * 示例:
 * <p>
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);        
 * hashSet.add(2);        
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);          
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);          
 * hashSet.contains(2);    // 返回  false (已经被删除)
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyHashSet {

    private List<List<Integer>> list;

    private final int size = 10;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        int index = key % size;
        if (list.get(index).isEmpty() || !list.get(index).contains(key)) {
            list.get(index).add(key);
        }
    }

    public void remove(int key) {
        int index = key % size;
        if (list.get(index).isEmpty() || !list.get(index).contains(key)) {
            return;
        }
        List<Integer> newList = new ArrayList<>();
        for (int m : list.get(index)) {
            if (m != key) {
                newList.add(m);
            }
        }
        list.set(index, newList);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = key % size;
        if (list.get(index).isEmpty() || !list.get(index).contains(key)) {
            return false;
        }
        return list.get(index).contains(key);
    }
}
