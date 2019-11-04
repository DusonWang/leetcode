package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 *  
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }
        final int[] array = new int[26];
        final char[] ca = s.toCharArray();
        for (char c : ca) {
            array[c - 'a'] += 1;
        }
        for (int i = 0; i < ca.length; i++) {
            if (array[ca[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar("leetcode"));
        System.out.println(firstUniqChar.firstUniqChar("loveleetcode"));
    }
}
