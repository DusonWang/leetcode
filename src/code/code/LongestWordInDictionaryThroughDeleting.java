package code.code;

import java.util.List;

/**
 * @author duson
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 * 示例 2:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * 输出:
 * "a"
 * 说明:
 * <p>
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWordInDictionaryThroughDeleting {

    private boolean isSub(String p, String q) {
        int i = 0, j = 0;
        for (; i < p.length() && j < q.length(); i++) {
            if (p.charAt(i) == q.charAt(j)) {
                j++;
            }
        }
        return j == q.length();
    }

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        if (d == null || d.size() == 0) {
            return result;
        }
        for (String dd : d) {
            if (isSub(s, dd)) {
                if (dd.length() > result.length() || dd.length() == result.length() && dd.compareTo(result) < 0) {
                    result = dd;
                }
            }
        }
        return result;
    }

    public String findLongestWord2(String s, List<String> d) {
        String res = "";
        for (String c : d) {
            if ((c.length() > res.length() || c.length() == res.length() && c.compareTo(res) < 0) && isSubseq(c, s)) {
                res = c;
            }
        }
        return res;
    }

    private boolean isSubseq(String a, String b) {
        int i = -1, j = -1;
        while (++i < a.length()) {
            if ((j = b.indexOf(a.charAt(i), j + 1)) == -1) {
                return false;
            }
        }
        return true;
    }
}
