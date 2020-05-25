package com.leetcode.offer.code;

import java.util.HashMap;

/**
 * 给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。
 * <p>
 * 返回该子数组，若存在多个最长子数组，返回左端点最小的。若不存在这样的数组，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * <p>
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * 示例 2:
 * <p>
 * 输入: ["A","A"]
 * <p>
 * 输出: []
 * 提示：
 * <p>
 * array.length <= 100000
 * 通过次数971提交次数2,740
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-longest-subarray-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLongestSubarray {

    public String[] findLongestSubarray(String[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = -1;
        int len = 0;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < array.length; ++i) {
            char c = ' ';
            for (char ch : array[i].toCharArray()) {
                c = ch;
            }
            if (c >= '0' && c <= '9') {
                sum--;
            } else {
                sum++;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                if (i - map.get(sum) > len) {
                    l = map.get(sum);
                    len = i - l;
                }
            }
        }
        String[] res = new String[len];
        for (int i = 1; i <= len; ++i) {
            res[i - 1] = array[i + l];
        }
        return res;
    }

}
