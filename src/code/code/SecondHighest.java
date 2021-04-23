package code.code;

/**
 * 给你一个混合字符串?s?，请你返回 s?中 第二大 的数字，如果不存在第二大的数字，请你返回 -1?。
 * <p>
 * 混合字符串 由小写英文字母和数字组成。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * 示例 2：
 * <p>
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s?只包含小写英文字母和（或）数字。
 * 通过次数4,155提交次数8,813
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-largest-digit-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SecondHighest {

    public int secondHighest(String s) {
        int first = -1;
        int second = -1;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        SecondHighest secondHighest = new SecondHighest();
        System.out.println(secondHighest.secondHighest("abc1111"));
        System.out.println(secondHighest.secondHighest("dfa12321afd"));
        System.out.println(secondHighest.secondHighest("sjhtz8344"));
        System.out.println(secondHighest.secondHighest("ck077"));

    }

}
