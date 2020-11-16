package code.code;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author duson
 * <p>
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dict(词典) = ["cat", "bat", "rat"]
 * sentence(句子) = "the cattle was rattled by the battery"
 * 输出: "the cat was rat by the bat"
 * 注:
 * <p>
 * 输入只包含小写字母。
 * 1 <= 字典单词数 <=1000
 * 1 <=  句中词语数 <= 1000
 * 1 <= 词根长度 <= 100
 * 1 <= 句中词语长度 <= 1000
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        dict.sort(Comparator.comparingInt(String::length));
        for (int i = 0; i < words.length; i++) {
            for (String s : dict) {
                String currentWord = words[i];
                if (currentWord.length() < s.length()) {
                    break;
                }
                if (currentWord.contains(s) && currentWord.substring(0, s.length()).equals(s)) {
                    words[i] = s;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(word).append(" ");
        }
        return res.substring(0, res.length() - 1);
    }
}
