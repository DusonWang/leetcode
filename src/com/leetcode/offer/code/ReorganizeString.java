package com.leetcode.offer.code;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorganizeString {

    public String reorganizeString(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        int[] arr = new int[26];
        int maxLength = 0;
        for (char c : s.toCharArray()) {
            if (maxLength < ++arr[c - 'a']) {
                maxLength = arr[c - 'a'];
            }
        }
        if (maxLength > (length + 1) / 2) {
            return "";
        }
        char[] ret = new char[s.length()];
        int even = 0, odd = 1;
        for (int i = 0; i < 26; i++) {
            while (arr[i] > 0 && arr[i] < (length / 2 + 1) && odd < length) {
                ret[odd] = (char) (i + 'a');
                arr[i]--;
                odd += 2;
            }
            while (arr[i] > 0) {
                ret[even] = (char) (i + 'a');
                arr[i]--;
                even += 2;
            }
        }
        return new String(ret);
    }
}
