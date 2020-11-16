package code.code;

import java.util.TreeSet;

/**
 * @author duson
 * 花园里有 N 个花盆，每个花盆里都有一朵花。这 N 朵花会在 N 天内依次开放，每天有且仅有一朵花会开放并且会一直盛开下去。
 * <p>
 * 给定一个数组 flowers 包含从 1 到 N 的数字，每个数字表示在那一天开放的花所在的花盆编号。
 * <p>
 * 例如， flowers[i] = x 表示在第 i 天盛开的花在第 x 个花盆中，i 和 x 都在 1 到 N 的范围内。
 * <p>
 * 给你一个整数 k，请你输出在哪一天恰好有两朵盛开的花，他们中间间隔了 k 朵花并且都没有开放。
 * <p>
 * 如果不存在，输出 -1。
 * <p>
 *  
 * <p>
 * 样例 1:
 * <p>
 * 输入:
 * flowers: [1,3,2]
 * k: 1
 * 输出: 2
 * 解释: 在第二天，第一朵和第三朵花都盛开了。
 *  
 * <p>
 * 样例 2:
 * <p>
 * 输入:
 * flowers: [1,2,3]
 * k: 1
 * 输出: -1
 *  
 * <p>
 * 注释 :
 * <p>
 * 给定的数组范围是 [1, 20000]。
 *  
 * <p>
 * 通过次数517提交次数1,381
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-empty-slots
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KEmptySlots {

    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> slotSet = new TreeSet<>();
        for (int i = 0; i < bulbs.length; i++) {
            Integer low = slotSet.lower(bulbs[i]);
            if (low != null && bulbs[i] - low == k + 1) {
                return i + 1;
            }
            Integer high = slotSet.higher(bulbs[i]);
            if (high != null && high - bulbs[i] == k + 1) {
                return i + 1;
            }
            slotSet.add(bulbs[i]);
        }
        return -1;
    }
}
