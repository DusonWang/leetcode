package code.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * 给定两个句子 words1, words2 （每个用字符串数组表示），和一个相似单词对的列表 pairs ，判断是否两个句子是相似的。
 * <p>
 * 例如，当相似单词对是 pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]的时候，words1 = ["great", "acting", "skills"] 和 words2 = ["fine", "drama", "talent"] 是相似的。
 * <p>
 * 注意相似关系是 具有 传递性的。例如，如果 "great" 和 "fine" 是相似的，"fine" 和 "good" 是相似的，则 "great" 和 "good" 是相似的。
 * <p>
 * 而且，相似关系是具有对称性的。例如，"great" 和 "fine" 是相似的相当于 "fine" 和 "great" 是相似的。
 * <p>
 * 并且，一个单词总是与其自身相似。例如，句子 words1 = ["great"], words2 = ["great"], pairs = [] 是相似的，尽管没有输入特定的相似单词对。
 * <p>
 * 最后，句子只会在具有相同单词个数的前提下才会相似。所以一个句子 words1 = ["great"] 永远不可能和句子 words2 = ["doubleplus","good"] 相似。
 * <p>
 * 注：
 * <p>
 * words1 and words2 的长度不会超过 1000。
 * pairs 的长度不会超过 2000。
 * 每个pairs[i] 的长度为 2。
 * 每个 words[i] 和 pairs[i][j] 的长度范围为 [1, 20]。
 * 通过次数584提交次数1,501
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sentence-similarity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AreSentencesSimilarTwo {

    private Map<String, String> map = new HashMap<>();

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        for (List<String> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }
        for (int i = 0; i < words1.length; i++) {
            if (!find(words1[i]).equals(find(words2[i]))) {
                return false;
            }
        }
        return true;
    }

    private void union(String word1, String word2) {
        String x = find(word1);
        String y = find(word2);
        if (!x.equals(y)) {
            map.put(x, y);
        }
    }

    private String find(String word) {
        while (map.containsKey(word) && !map.get(word).equals(word)) {
            word = map.get(word);
        }
        return word;
    }
}
