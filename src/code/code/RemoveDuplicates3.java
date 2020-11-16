package code.code;


/**
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 * <p>
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 * <p>
 * 在执行完所有删除操作后，返回最终得到的字符串。
 * <p>
 * 本题答案保证唯一。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * 示例 2：
 * <p>
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 * 示例 3：
 * <p>
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s 中只含有小写英文字母。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author duson
 */
public class RemoveDuplicates3 {

    public String removeDuplicates(String s, int k) {
        if (s == null || "".equals(s)) {
            return s;
        }
        int i = 1, start = 0, count = 1;
        while (i < s.length() && count < k) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                start = i;
                count = 1;
            }
            i++;
        }
        if (count == k) {
            return removeDuplicates(s.substring(0, start) + s.substring(start + k), k);
        }
        return s;
    }
}
