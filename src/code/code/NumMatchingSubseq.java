package code.code;

import java.util.HashSet;

/**
 * @author duson
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 * <p>
 * 示例:
 * 输入:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 * 注意:
 * <p>
 * 所有在words和 S 里的单词都只由小写字母组成。
 * S 的长度在 [1, 50000]。
 * words 的长度在 [1, 5000]。
 * words[i]的长度在[1, 50]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-matching-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumMatchingSubseq {

    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSubsequence(s, word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSubsequence(String str, String t) {
        int i = 0, j = 0, l1 = str.length(), l2 = t.length();
        if (l2 > l1) {
            return false;
        }
        while (i < l1 && j < l2) {
            if (str.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == l2;
    }

    public int numMatchingSubseq2(String s, String[] words) {
        int res = 0;
        HashSet<String> sub = new HashSet<>();
        HashSet<String> nonsub = new HashSet<>();
        for (String word : words) {
            if (sub.contains(word)) {
                res++;
                continue;
            }
            if (nonsub.contains(word)) {
                continue;
            }

            if (isSeq(s, word)) {
                res++;
                sub.add(word);
            } else {
                nonsub.add(word);
            }
        }
        return res;
    }

    private boolean isSeq(String s, String word) {
        int index = -1;
        for (char c : word.toCharArray()) {
            index = s.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
