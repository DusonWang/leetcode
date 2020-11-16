package code.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * ?
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * ?
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * ?
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * <p>
 * 通过次数14,555提交次数27,525
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationStr {

    private final Set<String> result = new HashSet<>();

    public String[] permutation(String s) {
        if (s == null) {
            return new String[]{};
        }
        boolean[] visited = new boolean[s.length()];
        process(s, "", visited);
        return result.toArray(new String[0]);
    }

    private void process(String s, String letter, boolean[] visited) {
        if (s.length() == letter.length()) {
            result.add(letter);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            process(s, letter + temp, visited);
            visited[i] = false;
        }
    }
}
