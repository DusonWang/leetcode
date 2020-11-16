package code.code;

/**
 * @author duson
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 * <p>
 * 字符串长度在[0, 50000]范围内。
 * 通过次数768提交次数1,669
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CompressString {

    public String compressString(String s) {
        if (s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int count = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (sb.charAt(sb.length() - 1) == s.charAt(i)) {
                ++count;
            } else {
                sb.append(count);
                count = 1;
                sb.append(s.charAt(i));
            }
        }
        sb.append(count);
        return sb.length() >= s.length() ? s : sb.toString();
    }
}
