package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有 + 和 - 的字符串。你和朋友轮流将 连续 的两个 "++" 反转成 "--"。 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
 * <p>
 * 请你写出一个函数，来计算出每个有效操作后，字符串所有的可能状态。
 * <p>
 * 示例：
 * <p>
 * 输入: s = "++++"
 * 输出:
 * [
 * "--++",
 * "+--+",
 * "++--"
 * ]
 * 注意：如果不存在可能的有效操作，请返回一个空列表 []。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GeneratePossibleNextMoves {

    public List<String> generatePossibleNextMoves(String s) {
        int len = s.length();
        List<String> result = new ArrayList<>();
        String res;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                if (i - 1 == 0) {
                    res = "--" + s.substring(2, len);
                    result.add(res);
                    continue;
                }
                if (i - 1 == len - 2) {
                    res = s.substring(0, len - 2) + "--";
                    result.add(res);
                    continue;
                }
                res = s.substring(0, i - 1) + "--" + s.substring(i + 1, len);
                result.add(res);
            }
        }
        return result;
    }
}
