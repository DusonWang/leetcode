package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWords {

    public String reverseWords(String s) {
        String[] tmps = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String tmp : tmps) {
            char[] array = tmp.toCharArray();
            reverseString(array);
            sb.append(array).append(" ");
        }
        s = sb.toString();
        return s.substring(0, s.length() - 1);
    }

    private void reverseString(char[] s) {
        final int len = s.length;
        final int half = len / 2;
        for (int i = 0, end = len - 1; i < half; i++, end--) {
            char temp = s[i];
            s[i] = s[end];
            s[end] = temp;
        }
    }
}
