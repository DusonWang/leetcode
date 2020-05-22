package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 * 示例 2:
 * <p>
 * 输入: num = "2", words = ["a", "b", "c", "d"]
 * 输出: ["a", "b", "c"]
 * 提示：
 * <p>
 * num.length <= 1000
 * words.length <= 500
 * words[i].length == num.length
 * num中不会出现 0, 1 这两个数字
 * 通过次数1,649提交次数2,356
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/t9-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author duson
 */
public class GetValidT9Words {

    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new ArrayList<>();
        char[] map = {'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'};
        for (String word : words) {
            int index = 0;
            boolean flag = true;
            for (char c : word.toCharArray()) {
                char n = map[c - 'a'];
                if (n != num.charAt(index++)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res;
    }
}
