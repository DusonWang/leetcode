package com.leetcode.offer.code;

/**
 * @author duson
 *
 * 给你一个回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的字典序最小，且 不是 回文串。
 *
 * 请你返回结果字符串。如果无法做到，则返回一个空串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：palindrome = "abccba"
 * 输出："aaccba"
 * 示例 2：
 *
 * 输入：palindrome = "a"
 * 输出：""
 *  
 *
 * 提示：
 *
 * 1 <= palindrome.length <= 1000
 * palindrome 只包含小写英文字母。
 * 通过次数923提交次数2,165
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/break-a-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BreakPalindrome {

    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) {
            return "";
        }
        char[] cs = palindrome.toCharArray();
        boolean flag = false;
        for(int i = 0; i < cs.length / 2; ++i) {
            if(cs[i] != 'a') {
                cs[i] = 'a';
                flag = true;
                break;
            }
        }
        if(!flag) {
            cs[cs.length - 1] = 'b';
        }
        return new String(cs);
    }
}
