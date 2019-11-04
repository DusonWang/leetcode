package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * <p>
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>(16);
        if (s == null || s.length() == 0 || words.length == 0) {
            return ans;
        }

        final int inc = words[0].length();
        final int k = words[0].length() * words.length;
        final int n = s.length();

        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> copy = new HashMap<>(map);

        for (int i = 0; i < n - k + 1; i++) {
            copy.putAll(map);
            int counter = copy.size();

            for (int j = i; j < i + k; j += inc) {
                String word = s.substring(j, j + inc);
                Integer size = copy.get(word);
                if (size != null) {
                    if (size == 1) {
                        counter--;
                    }
                    copy.put(word, size - 1);
                }
            }
            if (counter == 0) {
                ans.add(i);
            }

        }
        return ans;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> ans = new ArrayList<>(16);
        if (s == null || s.length() == 0 || words.length == 0) {
            return ans;
        }

        final int wordLen = words[0].length();
        final int listLen = words.length;
        final int sLen = s.length();
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            for (int j = i; j <= sLen - wordLen * listLen; j += wordLen) {
                Map<String, Integer> map2 = new HashMap<>(16);
                for (int k = listLen - 1; k >= 0; k--) {
                    final String temp = s.substring(j + k * wordLen, j + (k + 1) * wordLen);
                    final int val = map2.getOrDefault(temp, 0) + 1;
                    if (val > map.getOrDefault(temp, 0)) {
                        j += k * wordLen;
                        break;
                    }
                    if (k == 0) {
                        ans.add(j);
                    } else {
                        map2.put(temp, val);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindSubstring findSubstring = new FindSubstring();
        System.out.println("case 1");
        System.out.println(findSubstring.findSubstring2("barfoothefoobarman", new String[]{"foo", "bar"}));

        System.out.println("case 2");
        System.out.println(findSubstring.findSubstring2("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
    }
}
