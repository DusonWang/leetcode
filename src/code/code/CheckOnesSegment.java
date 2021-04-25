package code.code;

/**
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * <p>
 * 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true??? 。否则，返回 false 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1001"
 * 输出：false
 * 解释：字符串中的 1 没有形成一个连续字段。
 * 示例 2：
 * <p>
 * 输入：s = "110"
 * 输出：true
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s[i]???? 为 '0' 或 '1'
 * s[0] 为 '1'
 * 通过次数7,073提交次数17,281
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckOnesSegment {

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
//        int x = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '1') {
//                x++;
//                while (i < s.length() - 1) {
//                    i++;
//                    if (s.charAt(i) == '0') {
//                        i--;
//                        break;
//                    }
//                }
//            }
//        }
//        return x == 1;
    }

}
