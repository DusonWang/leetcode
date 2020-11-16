package code.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * <p>
 * 给定一个由n个不重复非空字符串组成的数组，你需要按照以下规则为每个单词生成最小的缩写。
 * <p>
 * 初始缩写由起始字母+省略字母的数量+结尾字幕组成。
 * 若存在冲突，亦即多于一个单词有同样的缩写，则使用更长的前缀代替首字母，直到从单词到缩写的映射唯一。换而言之，最终的缩写必须只能映射到一个单词。
 * 若缩写并不比原单词更短，则保留原样。
 * 示例:
 * <p>
 * 输入: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
 * 输出: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
 *  
 * <p>
 * 注意:
 * <p>
 * n和每个单词的长度均不超过 400。
 * 每个单词的长度大于 1。
 * 单词只由英文小写字母组成。
 * 返回的答案需要和原数组保持同一顺序。
 * 通过次数543提交次数1,147
 * 在真实的面试中遇到过这道题？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-abbreviation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordsAbbreviation {

    private Map<String, String> map = new HashMap<>();

    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> res = new ArrayList<>();
        dfs(0, dict);
        for (String w : dict) {
            res.add(map.get(w));
        }
        return res;
    }

    private void dfs(int start, List<String> list) {
        Map<String, List<String>> m = new HashMap<>();
        for (String w : list) {
            if (w.length() - start <= 3) {
                map.put(w, w);
                continue;
            }
            String abb = w.substring(0, start + 1) + (w.length() - 2 - start) + w.charAt(w.length() - 1);
            m.putIfAbsent(abb, new ArrayList<>());
            m.get(abb).add(w);
        }
        for (String key : m.keySet()) {
            List<String> words = m.get(key);
            if (words.size() == 1) {
                map.put(words.get(0), key);
            } else {
                dfs(start + 1, words);
            }
        }
    }
}
