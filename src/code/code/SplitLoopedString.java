package code.code;

/**
 * @author duson
 * 给定一个字符串列表，你可以将这些字符串连接成一个循环字符串，对于每个字符串，你可以选择是否翻转它。在所有可能的循环字符串中，你需要分割循环字符串（这将使循环字符串变成一个常规的字符串），然后找到字典序最大的字符串。
 * <p>
 * 具体来说，要找到字典序最大的字符串，你需要经历两个阶段：
 * <p>
 * 将所有字符串连接成一个循环字符串，你可以选择是否翻转某些字符串，并按照给定的顺序连接它们。
 * 在循环字符串的某个位置分割它，这将使循环字符串从分割点变成一个常规的字符串。
 * 你的工作是在所有可能的常规字符串中找到字典序最大的一个。
 * <p>
 * 示例:
 * <p>
 * 输入: "abc", "xyz"
 * 输出: "zyxcba"
 * 解释: 你可以得到循环字符串 "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-"，
 * 其中 '-' 代表循环状态。
 * 答案字符串来自第四个循环字符串，
 * 你可以从中间字符 'a' 分割开然后得到 "zyxcba"。
 *  
 * <p>
 * 注意:
 * <p>
 * 输入字符串只包含小写字母。
 * 所有字符串的总长度不会超过 1,000。
 *  
 * <p>
 * 通过次数305提交次数970
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-concatenated-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitLoopedString {

    public String splitLoopedString(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(rev) < 0) {
                strs[i] = rev;
            }
        }
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            for (String st : new String[]{strs[i], rev}) {
                for (int k = 0; k < st.length(); k++) {
                    StringBuilder t = new StringBuilder(st.substring(k));
                    for (int j = i + 1; j < strs.length; j++) {
                        t.append(strs[j]);
                    }
                    for (int j = 0; j < i; j++) {
                        t.append(strs[j]);
                    }
                    t.append(st, 0, k);
                    if (t.toString().compareTo(res) > 0) {
                        res = t.toString();
                    }
                }
            }
        }
        return res;
    }
}
