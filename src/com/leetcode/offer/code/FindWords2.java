package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *  
 * <p>
 * 注意：
 * <p>
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindWords2 {

    public String[] findWords(String[] words) {
        int[] flag = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        List<String> list = new ArrayList<>();

        for (String str : words) {
            int a = 0;
            String str1 = str.toLowerCase();
            int tmp = flag[str1.charAt(0) - 'a'];
            for (char x : str1.toCharArray()) {
                if (flag[x - 'a'] != tmp) {
                    a = 1;
                    break;
                }
            }
            if (a == 0) {
                list.add(str);
            }
        }
        return list.toArray(new String[0]);
    }
}
