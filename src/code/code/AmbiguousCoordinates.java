package code.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author duson
 * 我们有一些二维坐标，如?"(1, 3)"?或?"(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 * <p>
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 * <p>
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 * <p>
 * ?
 * <p>
 * 示例 1:
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * 示例 2:
 * 输入: "(00011)"
 * 输出: ?["(0.001, 1)", "(0, 0.011)"]
 * 解释:
 * 0.0, 00, 0001 或 00.01 是不被允许的。
 * 示例 3:
 * 输入: "(0123)"
 * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * 示例 4:
 * 输入: "(100)"
 * 输出: [(10, 0)]
 * 解释:
 * 1.0 是不被允许的。
 * ?
 * <p>
 * 提示:
 * <p>
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", 且字符串?S?中的其他元素都是数字。
 * ?
 * <p>
 * 通过次数1,324提交次数2,717
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ambiguous-coordinates
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AmbiguousCoordinates {

    private List<String> sub(String s) {
        if (s.length() == 1) {
            return Collections.singletonList(s);
        }
        List<String> ans = new ArrayList<>();
        if (s.charAt(0) != '0') {
            ans.add(s);
            for (int i = 1; i < s.length() && !s.endsWith("0"); i++) {
                ans.add(s.substring(0, i) + "." + s.substring(i));
            }
        } else if (!s.endsWith("0")) {
            ans.add(s.substring(0, 1) + "." + s.substring(1));
        }
        return ans;
    }

    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            List<String> left = sub(s.substring(1, i));
            List<String> right = sub(s.substring(i, s.length() - 1));
            if (!left.isEmpty() && !right.isEmpty()) {
                for (String l : left) {
                    for (String r : right) {
                        ans.add("(" + l + ", " + r + ")");
                    }
                }
            }
        }
        return ans;
    }
}
