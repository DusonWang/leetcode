package code.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author duson
 * <p>
 * 给你一种规律 pattern 和一个字符串 str，请你判断 str 是否遵循其相同的规律。
 * <p>
 * 这里我们指的是 完全遵循，例如 pattern 里的每个字母和字符串 str 中每个 非空 单词之间，存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abab", str = "redblueredblue"
 * 输出: true
 * 示例2:
 * <p>
 * 输入: pattern = "aaaa", str = "asdasdasdasd"
 * 输出: true
 * 示例2:
 * <p>
 * 输入: pattern = "aabb", str = "xyzabcxzyabc"
 * 输出: false
 * 说明:
 * 你可以默认 pattern 和 str 都只会包含小写字母。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordPatternMatch {

    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> hm = new HashMap<>();
        Set<String> hs = new HashSet<>();
        return isMatch(pattern, 0, str, 0, hm, hs);
    }

    private boolean isMatch(String pattern, int i, String str, int j, Map<Character, String> hm, Set<String> hs) {
        if (i == pattern.length() && j == str.length()) {
            return true;
        }
        if (i == pattern.length() || j == str.length()) {
            return false;
        }
        char c = pattern.charAt(i);
        if (hm.containsKey(c)) {
            String cString = hm.get(c);
            if (!str.startsWith(cString, j)) {
                return false;
            }
            return isMatch(pattern, i + 1, str, j + cString.length(), hm, hs);
        } else {
            for (int k = j; k < str.length(); k++) {
                String s = str.substring(j, k + 1);
                if (hs.contains(s)) {
                    continue;
                }
                hm.put(c, s);
                hs.add(s);
                if (isMatch(pattern, i + 1, str, k + 1, hm, hs)) {
                    return true;
                }
                hm.remove(c);
                hs.remove(s);
            }
            return false;
        }
    }
}
