package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * <p>
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * <p>
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * 示例 2：
 * <p>
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 * 示例 3：
 * <p>
 * 输入：s = "MerryChristmas"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "AbCdEfGh"
 * 输出：true
 * ?
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 1000
 * s.length 是偶数
 * s 由 大写和小写 字母组成
 * 通过次数9,377提交次数11,889
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/determine-if-string-halves-are-alike
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        Character[] ss = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = new HashSet<>(Arrays.asList(ss));
        int cnt1 = 0;
        int cnt2 = 0;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (set.contains(s.charAt(i))) {
                cnt1++;
            }
            if (set.contains(s.charAt(j))) {
                cnt2++;
            }
            i++;
            j--;
        }
        return cnt2 == cnt1;
    }
}
