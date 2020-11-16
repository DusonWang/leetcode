package code.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author duson
 * 我们用一个特殊的字符串 S 来表示一份单词列表，之所以能展开成为一个列表，是因为这个字符串 S 中存在一个叫做「选项」的概念：
 * <p>
 * 单词中的每个字母可能只有一个选项或存在多个备选项。如果只有一个选项，那么该字母按原样表示。
 * <p>
 * 如果存在多个选项，就会以花括号包裹来表示这些选项（使它们与其他字母分隔开），例如 "{a,b,c}" 表示 ["a", "b", "c"]。
 * <p>
 * 例子："{a,b,c}d{e,f}" 可以表示单词列表 ["ade", "adf", "bde", "bdf", "cde", "cdf"]。
 * <p>
 * 请你按字典顺序，返回所有以这种方式形成的单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："{a,b}c{d,e}f"
 * 输出：["acdf","acef","bcdf","bcef"]
 * 示例 2：
 * <p>
 * 输入："abcd"
 * 输出：["abcd"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 50
 * 你可以假设题目中不存在嵌套的花括号
 * 在一对连续的花括号（开花括号与闭花括号）之间的所有字母都不会相同
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brace-expansion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Expand {

    private List<List<Character>> listList = new ArrayList<>();

    private List<String> list = new ArrayList<>();

    public String[] expand(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') {
                i++;
                List<Character> tmpList = new ArrayList<>();
                while (s.charAt(i) != '}') {
                    if (s.charAt(i) != ',') {
                        tmpList.add(s.charAt(i));
                    }
                    i++;
                }
                Collections.sort(tmpList);
                listList.add(tmpList);
            } else if (c != ',') {
                List<Character> tmpList = new ArrayList<>();
                tmpList.add(s.charAt(i));
                listList.add(tmpList);
            }
        }
        expand(0, new StringBuilder());
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void expand(int index, StringBuilder sb) {
        if (index == listList.size()) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < listList.get(index).size(); i++) {
            sb.append(listList.get(index).get(i));
            expand(index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
