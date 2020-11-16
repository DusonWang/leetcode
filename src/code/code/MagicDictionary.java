package code.code;

import java.util.*;

/**
 * @author duson
 * 实现一个带有buildDict, 以及 search方法的魔法字典。
 * <p>
 * 对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
 * <p>
 * 对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * <p>
 * 示例 1:
 * <p>
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * 注意:
 * <p>
 * 你可以假设所有输入都是小写字母 a-z。
 * 为了便于竞赛，测试所用的数据量很小。你可以在竞赛结束后，考虑更高效的算法。
 * 请记住重置MagicDictionary类中声明的类变量，因为静态/类变量会在多个测试用例中保留。 请参阅这里了解更多详情。
 * 通过次数1,699提交次数3,051
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-magic-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MagicDictionary {

    private List<String> dic;

    public MagicDictionary() {
        dic = new ArrayList<>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        Collections.addAll(dic, dict);
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        for (String s : dic) {
            if (s.length() == word.length()) {
                int j = 0, c = 0;
                while (j < word.length() && c < 2) {
                    if ((int) s.charAt(j) != (int) word.charAt(j)) {
                        c++;
                    }
                    j++;
                }
                if (c == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
