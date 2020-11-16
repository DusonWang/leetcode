package code.code;

/**
 * @author duson
 * 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
 * <p>
 * S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 * 子串 'aaa' 没有出现在 S 中；
 * 子串 'bbb' 没有出现在 S 中。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = 1, B = 2
 * 输出："abb"
 * 解释："abb", "bab" 和 "bba" 都是正确答案。
 * 示例 2：
 * <p>
 * 输入：A = 4, B = 1
 * 输出："aabaa"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= A <= 100
 * 0 <= B <= 100
 * 对于给定的 A 和 B，保证存在满足要求的 S。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-without-aaa-or-bbb
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrWithout3a3b {

    public String strWithout3a3b(int aa, int bb) {
        int a = 0;
        int b = 0;
        char[] res = new char[aa + bb];
        for (int i = 0; i < res.length; i++) {
            if (aa > bb) {
                if (a + 1 != 3) {
                    res[i] = 'a';
                    a++;
                    b = 0;
                    aa--;
                } else {
                    res[i] = 'b';
                    b++;
                    a = 0;
                    bb--;
                }

            } else {
                if (b + 1 != 3) {
                    res[i] = 'b';
                    b++;
                    a = 0;
                    bb--;
                } else {
                    res[i] = 'a';
                    a++;
                    b = 0;
                    aa--;
                }
            }
        }
        return new String(res);
    }
}
