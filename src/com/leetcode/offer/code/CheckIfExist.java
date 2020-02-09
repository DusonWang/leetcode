package com.leetcode.offer.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * <p>
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * 示例 2：
 * <p>
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * 示例 3：
 * <p>
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-n-and-its-double-exist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckIfExist {

    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }
        for (int a : arr) {
            if (a == 0 && map.get(0) > 1) {
                return true;
            } else if (a != 0 && map.containsKey(a * 2)) {
                return true;
            }
        }
        return false;
    }
}
