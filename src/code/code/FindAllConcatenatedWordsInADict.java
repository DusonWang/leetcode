package code.code;

import java.util.*;

/**
 * @author duson
 * 给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。
 * <p>
 * 连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。
 * <p>
 * 示例:
 * <p>
 * 输入: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * <p>
 * 输出: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * <p>
 * 解释: "catsdogcats"由"cats", "dog" 和 "cats"组成;
 * "dogcatsdog"由"dog", "cats"和"dog"组成;
 * "ratcatdogcat"由"rat", "cat", "dog"和"cat"组成。
 * 说明:
 * <p>
 * 给定数组的元素总数不超过 10000。
 * 给定数组中元素的长度总和不超过 600000。
 * 所有输入字符串只包含小写字母。
 * 不需要考虑答案输出的顺序。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/concatenated-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAllConcatenatedWordsInADict {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ret = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (isConcatenated(set, word)) {
                ret.add(word);
            }
        }
        return ret;
    }

    private boolean isConcatenated(Set<String> set, String s) {
        for (int i = 1; i < s.length(); i++) {
            if (set.contains(s.substring(0, i))) {
                String rightStr = s.substring(i);
                if (set.contains(rightStr) || isConcatenated(set, rightStr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
