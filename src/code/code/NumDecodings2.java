package code.code;

/**
 * @author duson
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 除了上述的条件以外，现在加密字符串可以包含字符 '*'了，字符'*'可以被当做1到9当中的任意一个数字。
 * <p>
 * 给定一条包含数字和字符'*'的加密信息，请确定解码方法的总数。
 * <p>
 * 同时，由于结果值可能会相当的大，所以你应当对109 + 7取模。（翻译者标注：此处取模主要是为了防止溢出）
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "*"
 * 输出: 9
 * 解释: 加密的信息可以被解密为: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * 示例 2 :
 * <p>
 * 输入: "1*"
 * 输出: 9 + 9 = 18（翻译者标注：这里1*可以分解为1,* 或者当做1*来处理，所以结果是9+9=18）
 * 说明 :
 * <p>
 * 输入的字符串长度范围是 [1, 105]。
 * 输入的字符串只会包含字符 '*' 和 数字'0' - '9'。
 * 通过次数1,154提交次数4,374
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumDecodings2 {

    public int numDecodings(String s) {
        if (s.isEmpty() || s.startsWith("0")) {
            return 0;
        }
        int m = 1000000007;
        int len = s.length();
        long dp1 = 1;
        long dp2 = s.charAt(0) == '0' ? 0 : s.charAt(0) == '*' ? 9 : 1;
        for (int i = 1; i < len; i++) {
            long temp = dp2;
            if (s.charAt(i) == '*') {
                dp2 = 9 * dp2;
                if (s.charAt(i - 1) == '1') {
                    dp2 = (dp2 + 9 * dp1) % m;
                }
                if (s.charAt(i - 1) == '2') {
                    dp2 = (dp2 + 6 * dp1) % m;
                } else if (s.charAt(i - 1) == '*') {
                    dp2 = (dp2 + 15 * dp1) % m;
                }
            } else {
                dp2 = s.charAt(i) == '0' ? 0 : dp2;
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) < '7') {
                    dp2 = (dp2 + dp1) % m;
                } else if (s.charAt(i - 1) == '*') {
                    dp2 = (dp2 + (s.charAt(i) < '7' ? 2 : 1) * dp1) % m;
                }
            }
            dp1 = temp;
        }
        return (int) dp2;
    }
}
