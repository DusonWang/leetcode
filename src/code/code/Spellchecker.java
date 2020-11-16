package code.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author duson
 * 在给定单词列表?wordlist?的情况下，我们希望实现一个拼写检查器，将查询单词转换为正确的单词。
 * <p>
 * 对于给定的查询单词?query，拼写检查器将会处理两类拼写错误：
 * <p>
 * 大小写：如果查询匹配单词列表中的某个单词（不区分大小写），则返回的正确单词与单词列表中的大小写相同。
 * 例如：wordlist = ["yellow"], query = "YellOw": correct = "yellow"
 * 例如：wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
 * 例如：wordlist = ["yellow"], query = "yellow": correct = "yellow"
 * 元音错误：如果在将查询单词中的元音（‘a’、‘e’、‘i’、‘o’、‘u’）分别替换为任何元音后，能与单词列表中的单词匹配（不区分大小写），则返回的正确单词与单词列表中的匹配项大小写相同。
 * 例如：wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
 * 例如：wordlist = ["YellOw"], query = "yeellow": correct = "" （无匹配项）
 * 例如：wordlist = ["YellOw"], query = "yllw": correct = "" （无匹配项）
 * 此外，拼写检查器还按照以下优先级规则操作：
 * <p>
 * 当查询完全匹配单词列表中的某个单词（区分大小写）时，应返回相同的单词。
 * 当查询匹配到大小写问题的单词时，您应该返回单词列表中的第一个这样的匹配项。
 * 当查询匹配到元音错误的单词时，您应该返回单词列表中的第一个这样的匹配项。
 * 如果该查询在单词列表中没有匹配项，则应返回空字符串。
 * 给出一些查询 queries，返回一个单词列表 answer，其中 answer[i] 是由查询 query = queries[i] 得到的正确单词。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
 * 输出：["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= wordlist.length <= 5000
 * 1 <= queries.length <= 5000
 * 1 <= wordlist[i].length <= 7
 * 1 <= queries[i].length <= 7
 * wordlist 和?queries?中的所有字符串仅由英文字母组成。
 * 通过次数1,482提交次数3,899
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vowel-spellchecker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Spellchecker {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] res = new String[queries.length];
        Set<String> dict = new HashSet<>();
        HashMap<String, String> cap = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            dict.add(w);
            String lower = w.toLowerCase();
            if (!cap.containsKey(lower)) {
                cap.put(lower, w);
            }
            String v = removeVowel(lower);
            if (!vowel.containsKey(v)) {
                vowel.put(v, w);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            String lowerq = q.toLowerCase();
            String devowelq = removeVowel(lowerq);
            if (dict.contains(q)) {
                res[i] = q;
            } else if (cap.containsKey(lowerq)) {
                res[i] = cap.get(lowerq);
            } else {
                res[i] = vowel.getOrDefault(devowelq, "");
            }
        }
        return res;
    }

    private String removeVowel(String w) {
        StringBuilder sb = new StringBuilder();
        for (char c : w.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
