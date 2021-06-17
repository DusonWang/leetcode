package code.code;

import java.util.Stack;

/**
 * 给你一个字符串s，它仅包含字符'a' 和'b' 。
 * <p>
 * 你可以删除s中任意数目的字符，使得s 平衡。我们称s平衡的当不存在下标对(i,j)满足i < j 且s[i] = 'b'同时s[j]= 'a'。
 * <p>
 * 请你返回使 s平衡的 最少删除次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 * <p>
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i]要么是'a' 要么是'b'。
 * 通过次数3,017提交次数6,119
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-deletions-to-make-string-balanced
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumDeletions {

    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'b') {
                stack.push('b');
            } else {
                if (!stack.empty()) {
                    cnt++;
                    stack.pop();
                }
            }
        }
        return cnt;
    }

}
