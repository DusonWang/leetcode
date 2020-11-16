package code.code;

/**
 * @author duson
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例：
 * <p>
 * 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 注意：
 * <p>
 * 单词的定义是不包含空格的一系列字符
 * 输入字符串中不会包含前置或尾随的空格
 * 单词与单词之间永远是以单个空格隔开的
 * 进阶：使用 O(1) 额外空间复杂度的原地解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWords3 {

    public void reverseWords(char[] str) {
        int i = 0;
        for (int j = 0; j < str.length; j++) {
            if (str[j] != ' ') {
                continue;
            }
            reverse(str, i, j);
            i = j + 1;
        }
        reverse(str, i, str.length);
        reverse(str, 0, str.length);
    }

    private void reverse(char[] str, int i, int j) {
        for (int k = i; k < (i + j) / 2; k++) {
            char tmp = str[k];
            int g = j - 1 - k + i;
            str[k] = str[g];
            str[g] = tmp;
        }
    }
}
