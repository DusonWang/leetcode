package code.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 *
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123? 34 8? 34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 *
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 *
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * 示例 2：
 *
 * 输入：word = "leet1234code234"
 * 输出：2
 * 示例 3：
 *
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 * ?
 *
 * 提示：
 *
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 * 通过次数9,337提交次数17,811
 * 请问您在哪类招聘中遇到此题
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-different-integers-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class NumDifferentIntegers {

    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        Set<String> strings = new HashSet<>();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                while (i < chars.length && chars[i] == '0') {
                    i++;
                }
                while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                    number.append(chars[i]);
                    i++;
                }
                strings.add(number.toString());
                number.setLength(0);
            }
        }
        return strings.size();
    }
}
