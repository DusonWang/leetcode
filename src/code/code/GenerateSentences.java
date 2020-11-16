package code.code;

import java.util.*;

/**
 * @author duson
 * 给你一个近义词表?synonyms 和一个句子?text?，?synonyms 表中是一些近义词对 ，你可以将句子?text 中每个单词用它的近义词来替换。
 * <p>
 * 请你找出所有用近义词替换后的句子，按?字典序排序?后返回。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
 * text = "I am happy today but was sad yesterday"
 * 输出：
 * ["I am cheerful today but was sad yesterday",
 * "I am cheerful today but was sorrow yesterday",
 * "I am happy today but was sad yesterday",
 * "I am happy today but was sorrow yesterday",
 * "I am joy today but was sad yesterday",
 * "I am joy today but was sorrow yesterday"]
 * ?
 * <p>
 * 提示：
 * <p>
 * 0 <=?synonyms.length <= 10
 * synonyms[i].length == 2
 * synonyms[0] != synonyms[1]
 * 所有单词仅包含英文字母，且长度最多为?10 。
 * text?最多包含?10 个单词，且单词间用单个空格分隔开。
 * 通过次数725提交次数1,289
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/synonymous-sentences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateSentences {

    private final Map<String, HashSet<String>> dicMap = new HashMap<>();
    private DSU dsu;

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String> result = new ArrayList<>();
        if (null == synonyms) {
            result.add(text);
            return result;
        }
        if (text == null || text.length() == 0) {
            return result;
        }
        dsu = new DSU(synonyms);
        for (List<String> stringList : synonyms) {
            String str1 = stringList.get(0);
            String str2 = stringList.get(1);
            dsu.union(str1, str2);
        }
        for (List<String> stringList : synonyms) {
            String parent = dsu.find(stringList.get(0));
            dicMap.putIfAbsent(parent, new HashSet<>());
            dicMap.get(parent).add(stringList.get(0));
            dicMap.get(parent).add(stringList.get(1));
        }
        String[] sentenceArray = text.split(" ");
        dfs(result, sentenceArray, 0, "");
        result.sort(String::compareTo);
        return result;
    }

    private void dfs(List<String> result, String[] sentenceArray, int index, String sentence) {
        if (index == sentenceArray.length) {
            result.add(sentence.trim());
            return;
        }
        if (!dsu.parent.containsKey(sentenceArray[index])) {
            dfs(result, sentenceArray, index + 1, sentence + " " + sentenceArray[index]);
        } else {
            String tempParent = dsu.find(sentenceArray[index]);
            HashSet<String> allWords = dicMap.get(tempParent);
            for (String word : allWords) {
                dfs(result, sentenceArray, index + 1, sentence + " " + word);
            }
        }
    }

    static class DSU {
        Map<String, String> parent;

        DSU(List<List<String>> synonyms) {
            parent = new HashMap<>();
            init(synonyms);
        }

        public void init(List<List<String>> synonyms) {
            for (List<String> stringList : synonyms) {
                for (String str : stringList) {
                    parent.put(str, str);
                }
            }
        }

        public void union(String x, String y) {
            String parent1 = find(x);
            String parent2 = find(y);
            if (parent1.equals(parent2)) {
                return;
            }
            parent.put(y, parent1);
        }

        public String find(String x) {
            if (parent.get(x).equals(x)) {
                return x;
            }
            parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }
    }
}
