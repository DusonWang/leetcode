package com.leetcode.offer.code;

import java.util.*;

/**
 * 给你一个「短语」列表?phrases，请你帮忙按规则生成拼接后的「新短语」列表。
 * <p>
 * 「短语」（phrase）是仅由小写英文字母和空格组成的字符串。「短语」的开头和结尾都不会出现空格，「短语」中的空格不会连续出现。
 * <p>
 * 「前后拼接」（Before and After?puzzles）是合并两个「短语」形成「新短语」的方法。我们规定拼接时，第一个短语的最后一个单词 和 第二个短语的第一个单词 必须相同。
 * <p>
 * 返回每两个「短语」?phrases[i]?和?phrases[j]（i != j）进行「前后拼接」得到的「新短语」。
 * <p>
 * 注意，两个「短语」拼接时的顺序也很重要，我们需要同时考虑这两个「短语」。另外，同一个「短语」可以多次参与拼接，但「新短语」不能再参与拼接。
 * <p>
 * 请你按字典序排列并返回「新短语」列表，列表中的字符串应该是 不重复的 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：phrases = ["writing code","code rocks"]
 * 输出：["writing code rocks"]
 * 示例 2：
 * <p>
 * 输入：phrases = ["mission statement",
 * "a quick bite to eat",
 * ?               "a chip off the old block",
 * ?               "chocolate bar",
 * ?               "mission impossible",
 * ?               "a man on a mission",
 * ?               "block party",
 * ?               "eat my words",
 * ?               "bar of soap"]
 * 输出：["a chip off the old block party",
 * ?     "a man on a mission impossible",
 * ?     "a man on a mission statement",
 * ?     "a quick bite to eat my words",
 * "chocolate bar of soap"]
 * 示例 3：
 * <p>
 * 输入：phrases = ["a","b","a"]
 * 输出：["a"]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= phrases.length <= 100
 * 1 <= phrases[i].length <= 100
 * 通过次数1,016提交次数2,967
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/before-and-after-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author duson
 */
public class BeforeAndAfterPuzzles {

    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        List<String> res = new ArrayList<>();
        if (phrases.length == 1) {
            return res;
        }
        Set<String> set = new HashSet<>();
        StringBuilder sb;
        for (int i = 0; i < phrases.length; i++) {
            String suffix = phrases[i].substring(phrases[i].lastIndexOf(" ") + 1);
            for (int j = 0; j < phrases.length; j++) {
                if (i == j) {
                    continue;
                }
                String[] split = phrases[j].split(" ");
                if (split[0].equals(suffix)) {
                    sb = new StringBuilder();
                    sb.append(phrases[i]).append(phrases[j].substring(suffix.length()));
                    set.add(sb.toString());
                }
            }
        }
        res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }
}
