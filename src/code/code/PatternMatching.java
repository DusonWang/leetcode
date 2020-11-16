package code.code;

import java.util.Objects;

/**
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 * <p>
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * 示例 4：
 * <p>
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 * 提示：
 * <p>
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 * 通过次数740提交次数2,887
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PatternMatching {

    public boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        int sizeA = 0;
        int sizeB = 0;
        char[] pc = pattern.toCharArray();
        for (char c : pc) {
            if (c == 'a') {
                sizeA++;
            } else {
                sizeB++;
            }
        }
        if (value.length() == 0) {
            return sizeA == 0 || sizeB == 0;
        }
        if (sizeA == 0) {
            return value.length() % sizeB == 0 && isValid(value, pc, 0, value.length() / sizeB);
        }
        if (sizeB == 0) {
            return value.length() % sizeA == 0 && isValid(value, pc, value.length() / sizeA, 0);
        }
        int maxLengthA = value.length() / sizeA;
        for (int i = 0; i <= maxLengthA; i++) {
            boolean canUse = (value.length() - sizeA * i) % sizeB == 0;
            if (!canUse) {
                continue;
            }
            int lb = (value.length() - sizeA * i) / sizeB;
            if (isValid(value, pc, i, lb)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(String value, char[] p, int la, int lb) {
        String subA = null;
        String subB = null;
        int pointer = 0;
        for (char c : p) {
            boolean isA = c == 'a';
            int le = isA ? la : lb;
            if (pointer + le > value.length()) {
                return false;
            }
            String v = value.substring(pointer, pointer + le);
            subA = isA && subA == null ? v : subA;
            subB = !isA && subB == null ? v : subB;
            if (Objects.equals(subA, subB)) {
                return false;
            }
            String sub = isA ? subA : subB;
            if (!v.equals(sub)) {
                return false;
            }
            pointer = pointer + le;
        }
        return true;
    }
}
