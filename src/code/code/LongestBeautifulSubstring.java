package code.code;

/**
 * 当一个字符串满足如下条件时，我们称它是 美丽的?：
 * <p>
 * 所有 5 个英文元音字母（'a'?，'e'?，'i'?，'o'?，'u'）都必须?至少?出现一次。
 * 这些元音字母的顺序都必须按照 字典序?升序排布（也就是说所有的 'a'?都在 'e'?前面，所有的 'e'?都在 'i'?前面，以此类推）
 * 比方说，字符串?"aeiou" 和?"aaaaaaeiiiioou"?都是 美丽的?，但是?"uaeio"?，"aeoiu"?和?"aaaeeeooo"?不是美丽的?。
 * <p>
 * 给你一个只包含英文元音字母的字符串?word?，请你返回?word 中 最长美丽子字符串的长度?。如果不存在这样的子字符串，请返回 0?。
 * <p>
 * 子字符串 是字符串中一个连续的字符序列。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
 * 输出：13
 * 解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。
 * 示例 2：
 * <p>
 * 输入：word = "aeeeiiiioooauuuaeiou"
 * 输出：5
 * 解释：最长子字符串是 "aeiou" ，长度为 5 。
 * 示例 3：
 * <p>
 * 输入：word = "a"
 * 输出：0
 * 解释：没有美丽子字符串，所以返回 0 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 5 * 105
 * word?只包含字符?'a'，'e'，'i'，'o'?和?'u'?。
 * 通过次数5,283提交次数8,758
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-of-all-vowels-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestBeautifulSubstring {

    public int longestBeautifulSubstring(String word) {
        int index = 0;
        int len = word.length();
        char[] ch = word.toCharArray();
        int res = 0;
        while (index < len) {
            while (index < len && ch[index] != 'a') {
                index++;
            }
            if (index < len && ch[index] == 'a') {
                int l = index;
                while (index < len && ch[index] == 'a') {
                    index++;
                }
                if (index < len && ch[index] == 'e') {
                    while (index < len && ch[index] == 'e') {
                        index++;
                    }
                } else {
                    continue;
                }
                if (index < len && ch[index] == 'i') {
                    while (index < len && ch[index] == 'i') {
                        index++;
                    }
                } else {
                    continue;
                }
                if (index < len && ch[index] == 'o') {
                    while (index < len && ch[index] == 'o') {
                        index++;
                    }
                } else {
                    continue;
                }
                if (index < len && ch[index] == 'u') {
                    while (index < len && ch[index] == 'u') {
                        index++;
                    }
                } else {
                    continue;
                }
                res = Math.max(res, index - l);
            }
        }
        return res;
    }
}
