package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "code"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: "aab"
 * 输出: true
 * 示例 3：
 * <p>
 * 输入: "carerac"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPermutePalindrome {

    public boolean canPermutePalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int n = 0;
        for (int c : count) {
            if ((c % 2) != 0) {
                n++;
            }
        }
        return n <= 1;
    }

    public static void main(String[] args) {
        CanPermutePalindrome canPermutePalindrome = new CanPermutePalindrome();
        System.out.println(canPermutePalindrome.canPermutePalindrome("carerac"));
    }
}
