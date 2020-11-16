package code.code;

/**
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 * <p>
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 * <p>
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b?个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 * 示例 2：
 * <p>
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 * 示例 3：
 * <p>
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 * ?
 * <p>
 * 提示：
 * <p>
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 * 通过次数2,566提交次数5,825
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-happy-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestDiverseString {

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int size = a + b + c;
        int A = 0, B = 0, C = 0;
        for(int i = 0; i < size; i++) {
            if ((a >= b && a >= c && A != 2) || (B == 2 && a > 0) || (C == 2 && a > 0))  {
                sb.append("a");
                a--;
                A++;
                B = 0;
                C = 0;
            } else if ((b >= a && b >= c && B != 2) || (A == 2 && b > 0) || (C == 2 && b > 0)) {
                sb.append("b");
                b--;
                B++;
                A = 0;
                C = 0;
            } else if ((c >= a && c >= b && C != 2) || (B == 2 && c > 0) || (A == 2 && c > 0)) {
                sb.append("c");
                c--;
                C++;
                A = 0;
                B = 0;
            }
        }
        return sb.toString();
    }
}
