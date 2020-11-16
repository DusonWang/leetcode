package code.code;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author duson
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 * <p>
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 * <p>
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 * <p>
 * 示例：
 * <p>
 * LFUCache cache = new LFUCache( 2 /* capacity (缓存容量)  );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回 1
 * cache.put(3,3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4,4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lfu-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LFUCache {

    private HashMap<Integer, Integer> keyValues;
    private HashMap<Integer, Integer> keyCounts;
    private HashMap<Integer, LinkedHashSet<Integer>> countKeySets;
    private int capacity;
    private int min;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.min = -1;
        keyValues = new HashMap<>();
        keyCounts = new HashMap<>();
        countKeySets = new HashMap<>();
        countKeySets.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!keyValues.containsKey(key)) {
            return -1;
        }
        int count = keyCounts.get(key);
        keyCounts.put(key, count + 1);
        countKeySets.get(count).remove(key);
        if (count == min && countKeySets.get(count).size() == 0) {
            min++;
        }
        if (!countKeySets.containsKey(count + 1)) {
            countKeySets.put(count + 1, new LinkedHashSet<>());
        }
        countKeySets.get(count + 1).add(key);
        return keyValues.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (keyValues.containsKey(key)) {
            keyValues.put(key, value);
            get(key);
            return;
        }
        if (keyValues.size() >= capacity) {
            int leastFreq = countKeySets.get(min).iterator().next();
            keyValues.remove(leastFreq);
            keyCounts.remove(leastFreq);
            countKeySets.get(min).remove(leastFreq);
        }
        keyValues.put(key, value);
        keyCounts.put(key, 1);
        countKeySets.get(1).add(key);
        min = 1;
    }
}
