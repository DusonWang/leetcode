package com.leetcode.offer.code;

/**
 * @author duson
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        char[] ans = s.toCharArray();
        int left = 0;
        int right = ans.length - 1;
        while (left < right) {
            while (left < ans.length && !isVowels(ans[left])) {
                left++;
            }
            while (right >= 0 && !isVowels(ans[right])) {
                right--;
            }
            if (left < right) {
                char tmp = ans[left];
                ans[left] = ans[right];
                ans[right] = tmp;
            }
            left++;
            right--;
        }
        return new String(ans);
    }

    private boolean isVowels(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
