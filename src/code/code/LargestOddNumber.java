package code.code;

/**
 * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 * <p>
 * 子字符串 是字符串中的一个连续的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "52"
 * 输出："5"
 * 解释：非空子字符串仅有 "5"、"2" 和 "52" 。"5" 是其中唯一的奇数。
 * 示例 2：
 * <p>
 * 输入：num = "4206"
 * 输出：""
 * 解释：在 "4206" 中不存在奇数。
 * 示例 3：
 * <p>
 * 输入：num = "35427"
 * 输出："35427"
 * 解释："35427" 本身就是一个奇数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num.length <= 105
 * num 仅由数字组成且不含前导零
 * 通过次数4,153提交次数6,440
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-odd-number-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestOddNumber {

    public String largestOddNumber(String num) {
        char[] chars = num.toCharArray();
        int len = chars.length;
        for (int i = len - 1; i >= 0; i--) {
            if (((chars[i] - '0') & 1) == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        LargestOddNumber largestOddNumber = new LargestOddNumber();
        System.out.println(largestOddNumber.largestOddNumber("52"));
        System.out.println(largestOddNumber.largestOddNumber("4206"));
        System.out.println(largestOddNumber.largestOddNumber("35427"));
    }
}
