package com.leetcode.offer.code;

/**
 * @author duson
 * You are given a string s?containing lowercase English letters, and a matrix?shift, where?shift[i] = [direction, amount]:
 * <p>
 * direction?can be 0?(for left shift) or 1?(for right shift).?
 * amount?is the amount by which string?s?is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 * <p>
 * ?
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:?
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 * <p>
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:?
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 * ?
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 * 通过次数79提交次数119
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perform-string-shifts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringShift {

    public String stringShift(String s, int[][] shift) {
        int count = 0;
        for (int[] value : shift) {
            if (value[0] == 0) {
                count += value[1];
            } else {
                count -= value[1];
            }
        }
        count = count % s.length();
        if (count > 0) {
            return s.substring(count) + s.substring(0, count);
        } else if (count < 0) {
            return s.substring(s.length() + count) + s.substring(0, s.length() + count);
        }
        return s;
    }
}
