package com.leetcode.offer.day31;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duson
 * 不使用任何内建的哈希表库设计一个哈希映射
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 * <p>
 * 示例：
 * <p>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyHashMap {

    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<List<Pair>> list;
    private final int size = 10;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<>());
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = key % 10;
        if (list.get(index).isEmpty()) {
            list.get(index).add(new Pair(key, value));
        } else {
            List<Pair> listTmp = list.get(index);
            boolean contain = false;
            for (Pair pp : listTmp) {
                if (pp.key == key) {
                    pp.value = value;
                    contain = true;
                    break;
                }
            }
            if (!contain){
                listTmp.add(new Pair(key, value));
            }
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = key % 10;
        if (list.isEmpty() || list.get(index).isEmpty()) {
            return -1;
        }
        List<Pair> listTmp = list.get(index);
        for (Pair pp : listTmp) {
            if (pp.key == key) {
                return pp.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = key % 10;
        if (list.isEmpty() || list.get(index).isEmpty()) {
            return;
        }
        List<Pair> newList = list.get(index).stream().filter(tmp -> tmp.key != key).collect(Collectors.toList());
        list.set(index, newList);
    }
}
