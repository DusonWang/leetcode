package com.leetcode.offer.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 爱丽丝有一手（hand）由整数数组给定的牌。 
 * <p>
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * <p>
 * 如果她可以完成分组就返回 true，否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 * <p>
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsNStraightHand {

    public boolean isNStraightHand(int[] hand, int w) {
        if (hand.length % w != 0) {
            return false;
        }
        int[] arr = new int[w];
        for (int value : hand) {
            arr[value % w]++;
        }
        int size = hand.length / w;
        for (int j : arr) {
            if (j != size) {
                return false;
            }
        }
        return true;
    }
}
