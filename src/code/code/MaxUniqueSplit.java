package code.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
 * <p>
 * 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
 * <p>
 * 注意：子字符串 是字符串中的一个连续字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ababccc"
 * 输出：5
 * 解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
 * 示例 2：
 * <p>
 * 输入：s = "aba"
 * 输出：2
 * 解释：一种最大拆分方法为 ['a', 'ba'] 。
 * 示例 3：
 * <p>
 * 输入：s = "aa"
 * 输出：1
 * 解释：无法进一步拆分字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length<= 16
 * <p>
 * s 仅包含小写英文字母
 * <p>
 * 通过次数4,646提交次数9,007
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-a-string-into-the-max-number-of-unique-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxUniqueSplit {

    private Set<String> set = new HashSet<>();
    private int ans = 1;

    public int maxUniqueSplit(String s) {
        maxUnique(s, 0);
        return ans;
    }

    public void maxUnique(String s, int start) {
        if (start == s.length()) {
            ans = Math.max(ans, set.size());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (set.contains(sub)) {
                continue;
            }
            set.add(sub);
            maxUnique(s, i + 1);
            set.remove(sub);

        }
    }
}
