package com.leetcode.offer.day2;

/**
 * @author duson
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String... strs) {
        int len;
        if (strs == null || (len = strs.length) == 0) {
            return "";
        }

        if (len == 1) {
            return strs[0];
        }

        String str = getString(strs[0], strs[1]);
        if (str == null) {
            return "";
        }

        for (int i = 2; i < len; i++) {
            str = getString(str, strs[i]);
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    public String longestCommonPrefix2(String... strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if ("".equals(prefix)) {
                    return "";
                }
            }
        }
        return prefix;
    }

    private String getString(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int min = Math.min(len1, len2);
        int index = -1;
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            } else {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        }
        return str1.substring(0, index + 1);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix2("flower", "flow", "flight"));
        System.out.println(longestCommonPrefix.longestCommonPrefix2("dog", "racecar", "car"));
    }
}
