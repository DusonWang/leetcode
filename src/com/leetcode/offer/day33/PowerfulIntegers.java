package com.leetcode.offer.day33;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author duson
 * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 * <p>
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 * <p>
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 100
 * 1 <= y <= 100
 * 0 <= bound <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powerful-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int xLim = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = xLim; i <= bound; i *= x) {
            int yLim = 1;
            for (int j = yLim; i + j <= bound; j *= y) {
                set.add(i + j);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(set);
    }
}
