package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有 + 和 - 的字符串。你和朋友轮流将 连续 的两个 "++" 反转成 "--"。 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
 * <p>
 * 请你写出一个函数来判定起始玩家是否存在必胜的方案。
 * <p>
 * 示例：
 * <p>
 * 输入: s = "++++"
 * 输出: true
 * 解析: 起始玩家可将中间的 "++" 翻转变为 "+--+" 从而得胜。
 * 延伸：
 * 请推导你算法的时间复杂度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanWin2 {

    private Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                String ss = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                if (!canWin(ss)) {
                    map.put(ss, false);
                    return true;
                }
                map.put(ss, true);
            }
        }
        return false;
    }
}
