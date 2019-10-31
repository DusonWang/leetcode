package com.leetcode.offer.day53;

/**
 * @author duson
 * 给定一个关键词集合 words 和一个字符串 S，将所有 S 中出现的关键词加粗。所有在标签 <b> 和 </b> 中的字母都会加粗。
 * <p>
 * 返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。
 * <p>
 * 例如，给定 words = ["ab", "bc"] 和 S = "aabcd"，需要返回 "a<b>abc</b>d"。注意返回 "a<b>a<b>b</b>c</b>d" 会使用更多的标签，因此是错误的。
 * <p>
 *  
 * <p>
 * 注：
 * <p>
 * words 长度的范围为 [0, 50]。
 * words[i] 长度的范围为 [1, 10]。
 * S 长度的范围为 [0, 500]。
 * 所有 words[i] 和 S 中的字符都为小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bold-words-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BoldWords {

    public String boldWords(String[] words, String s) {
        int n = s.length();
        boolean[] mark = new boolean[n];
        for (String word : words) {
            int start = 0;
            while ((start = s.indexOf(word, start)) >= 0) {
                for (int i = start; i < start + word.length(); ++i) {
                    mark[i] = true;
                }
                ++start;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (mark[i] && (i == 0 || !mark[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (mark[i] && (i == n - 1 || !mark[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}
