package code.code;

/**
 * @author duson
 * 给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。
 * <p>
 * 注意：
 * <p>
 * 满足编辑距离等于 1 有三种可能的情形：
 * <p>
 * 往 s 中插入一个字符得到 t
 * 从 s 中删除一个字符得到 t
 * 在 s 中替换一个字符得到 t
 * 示例 1：
 * <p>
 * 输入: s = "ab", t = "acb"
 * 输出: true
 * 解释: 可以将 'c' 插入字符串 s 来得到 t。
 * 示例 2:
 * <p>
 * 输入: s = "cab", t = "ad"
 * 输出: false
 * 解释: 无法通过 1 步操作使 s 变为 t。
 * 示例 3:
 * <p>
 * 输入: s = "1203", t = "1213"
 * 输出: true
 * 解释: 可以将字符串 s 中的 '0' 替换为 '1' 来得到 t。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsOneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
        int dif = t.length() - s.length(), i = 0;
        if (dif < 0) {
            return isOneEditDistance(t, s);
        }
        if (dif > 1) {
            return false;
        }
        while (i < s.length() && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        if (i == s.length()) {
            return dif > 0;
        }
        if (dif == 0) {
            i++;
        }
        while (i < s.length() && s.charAt(i) == t.charAt(i + dif)) {
            i++;
        }
        return i == s.length();
    }
}
