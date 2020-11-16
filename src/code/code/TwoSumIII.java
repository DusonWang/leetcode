package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 设计并实现一个 TwoSum 的类，使该类需要支持 add 和 find 的操作。
 * <p>
 * add 操作 -  对内部数据结构增加一个数。
 * find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。
 * <p>
 * 示例 1:
 * <p>
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * 示例 2:
 * <p>
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iii-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumIII {

    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TwoSumIII() {

    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        int times = map.getOrDefault(number, 0);
        map.put(number, times + 1);
    }

    public boolean find(int value) {
        for (int val : map.keySet()) {
            int rest = value - val;
            if (map.containsKey(rest)) {
                if (rest != val) {
                    return true;
                } else {
                    if (map.get(rest) > 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
