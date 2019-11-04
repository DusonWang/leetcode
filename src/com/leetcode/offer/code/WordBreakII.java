package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> map = new HashMap<>();
        return helper(s, set, map);
    }

    private List<String> helper(String s, Set<String> set, Map<String, List<String>> used) {
        if (used.containsKey(s)) {
            return used.get(s);
        }
        int len = s.length();
        if (len == 0) {
            return null;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len + 1; i++) {
            String sub = s.substring(0, i);
            List<String> partRes;
            if (set.contains(sub)) {
                partRes = helper(s.substring(i), set, used);
                if (partRes == null) {
                    res.add(sub);
                } else {
                    for (String str : partRes) {
                        res.add(sub + " " + str);
                    }
                }
            }
        }
        used.put(s, res);
        return res;
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>(wordDict);
        ArrayList<String> res = new ArrayList<>();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (String tmp : wordDict) {
            int len = tmp.length();
            if (len > max) {
                max = len;
            }
            if (len < min) {
                min = len;
            }
        }

        for (int i = min; i <= s.length(); i++) {
            for (int j = i - min; j >= i - max && j >= 0; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[s.length()]) {
            return res;
        }

        StringBuilder sb = new StringBuilder();
        dfs(s, set, sb, res, 0);
        return res;
    }

    public void dfs(String s, Set<String> set, StringBuilder sb, List<String> res, int start) {
        if (start == s.length()) {
            res.add(sb.toString().trim());
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (set.contains(str)) {
                int length = sb.length();
                sb.append(str).append(" ");
                dfs(s, set, sb, res, i + 1);
                sb.setLength(length);
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        list.add("applepen");
        list.add("pine");
        list.add("pineapple");

        System.out.println(wordBreakII.wordBreak2("pineapplepenapple", list));
    }
}
