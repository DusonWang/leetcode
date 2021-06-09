package code.code;

/**
 * 给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
 * <p>
 * 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abbcccaa"
 * 输出：13
 * 解释：同构子字符串如下所列：
 * "a"   出现 3 次。
 * "aa"  出现 1 次。
 * "b"   出现 2 次。
 * "bb"  出现 1 次。
 * "c"   出现 3 次。
 * "cc"  出现 2 次。
 * "ccc" 出现 1 次。
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
 * 示例 2：
 * <p>
 * 输入：s = "xy"
 * 输出：2
 * 解释：同构子字符串是 "x" 和 "y" 。
 * 示例 3：
 * <p>
 * 输入：s = "zzzzz"
 * 输出：15
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写字符串组成
 * 通过次数4,150提交次数9,712
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-homogenous-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountHomogenous {

    public int countHomogenous(String s) {
        int res = 0;
        int cur = 0;
        int count = 0;
        int mod = 1_000_000_007;
        for (int i = 0; i < s.length(); ++i) {
            count = s.charAt(i) == cur ? count + 1 : 1;
            cur = s.charAt(i);
            res = (res + count) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        CountHomogenous countHomogenous = new CountHomogenous();
        System.out.println(countHomogenous.countHomogenous("zzzzz"));
    }
}
