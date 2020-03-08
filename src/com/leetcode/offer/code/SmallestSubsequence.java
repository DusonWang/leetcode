package com.leetcode.offer.code;

import java.util.Stack;

/**
 * @author duson
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："cdadabcc"
 * 输出："adbc"
 * 示例 2：
 * <p>
 * 输入："abcd"
 * 输出："abcd"
 * 示例 3：
 * <p>
 * 输入："ecbacba"
 * 输出："eacb"
 * 示例 4：
 * <p>
 * 输入："leetcode"
 * 输出："letcod"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 1000
 * text 由小写英文字母组成
 *  
 * <p>
 * 注意：本题目与 316 https://leetcode-cn.com/problems/remove-duplicate-letters/ 相同
 * <p>
 * 通过次数1,441提交次数3,266
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestSubsequence {

    public String smallestSubsequence(String text) {
        Stack<Integer> stack = new Stack<>();
        int[] last = new int[26], seen = new int[26];
        for (int i = 0; i < text.length(); ++i) {
            last[text.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < text.length(); ++i) {
            int c = text.charAt(i) - 'a';
            if (seen[c]++ > 0) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()]) {
                seen[stack.pop()] = 0;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : stack) {
            sb.append((char) ('a' + i));
        }
        return sb.toString();
    }
}
