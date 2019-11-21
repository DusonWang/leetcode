package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * <p>
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * <p>
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * <p>
 * 返回所有不常用单词的列表。
 * <p>
 * 您可以按任何顺序返回列表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 * 示例 2：
 * <p>
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A 和 B 都只包含空格和小写字母。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncommon-words-from-two-sentences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UncommonFromSentences {

    public String[] uncommonFromSentences(String a, String b) {

        Map<String, Integer> count = new HashMap<>();
        for (String word: a.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (String word: b.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        List<String> ans = new ArrayList<>();
        for (String word: count.keySet()) {
            if (count.get(word) == 1) {
                ans.add(word);
            }
        }

        return ans.toArray(new String[0]);
    }
}
