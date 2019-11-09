package com.leetcode.offer.code;

/**
 * @author duson
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 * <p>
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 * <p>
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 * <p>
 * 输入： A = "", B = "aa"
 * 输出： false
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuddyStrings {

    public boolean buddyStrings2(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        if (aLen != bLen) {
            return false;
        }

        if (a.equals(b)) {
            int[] charsCount = new int[26];
            for (int i = 0; i < aLen; i++) {
                if (++charsCount[a.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
        }

        char fa = '\n';
        char fb = '\n';
        int count = 0;
        for (int i = 0; i < aLen; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (count == 0) {
                    fa = a.charAt(i);
                    fb = b.charAt(i);
                    count++;
                } else if (count == 1) {
                    if (a.charAt(i) == fb && b.charAt(i) == fa) {
                        count++;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return count == 2;
    }
}
