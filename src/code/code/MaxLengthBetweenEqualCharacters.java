package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 * 示例 3：
 * <p>
 * 输入：s = "cbzxy"
 * 输出：-1
 * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 * 示例 4：
 * <p>
 * 输入：s = "cabbac"
 * 输出：4
 * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 300
 * s 只含小写英文字母
 * 通过次数9,057提交次数14,475
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxLengthBetweenEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
            } else {
                max = Math.max(max, i - map.get(chars[i]) - 1);
            }
        }
        return max;
    }

}
