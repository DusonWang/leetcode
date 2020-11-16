package code.code;

/**
 * @author duson
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * <p>
 * 如果当前数字为偶数，则将其除以 2 。
 * <p>
 * 如果当前数字为奇数，则将其加上 1 。
 * <p>
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14?
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4?
 * Step 5) 4  是偶数，除 2 得到 2?
 * Step 6) 2  是偶数，除 2 得到 1?
 * 示例 2：
 * <p>
 * 输入：s = "10"
 * 输出：1
 * 解释："10" 表示十进制数 2 。
 * Step 1) 2 是偶数，除 2 得到 1
 * 示例 3：
 * <p>
 * 输入：s = "1"
 * 输出：0
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length?<= 500
 * s 由字符 '0' 或 '1' 组成。
 * s[0] == '1'
 * 通过次数4,030提交次数8,759
 * 在真实的面试中遇到过这道题？
 * <p>
 * 是
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSteps {

    public int numSteps(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int ans = 0;
        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == 0 && carry == 0) {
                break;
            }
            if (s.charAt(i) - '0' != carry) {
                carry = 1;
                ans += 1;
            }
            ans += 1;
        }
        return ans;
    }
}
