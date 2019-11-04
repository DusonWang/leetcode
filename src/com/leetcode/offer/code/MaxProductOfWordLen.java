package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 * <p>
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * <p>
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProductOfWordLen {

    public int maxProduct(String[] words) {
        final int len = words.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (!contain(words[i], words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private boolean contain(String s, String q) {
        for (char s1 : s.toCharArray()) {
            for (char q1 : q.toCharArray()) {
                if (s1 == q1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maxProduct2(String[] words) {
        final int wLength = words.length;
        final int[] arr = new int[wLength];
        for (int i = 0; i < wLength; ++i) {
            int length = words[i].length();
            for (int j = 0; j < length; ++j) {
                arr[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < wLength; ++i) {
            for (int j = i + 1; j < wLength; ++j) {
                if ((arr[i] & arr[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProductOfWordLen maxProductOfWordLen = new MaxProductOfWordLen();
        System.out.println(maxProductOfWordLen.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
        System.out.println(maxProductOfWordLen.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(maxProductOfWordLen.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }
}
