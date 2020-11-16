package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 请你写出一个能够举单词全部缩写的函数。
 * <p>
 * 注意：输出的顺序并不重要。
 * <p>
 * 示例：
 * <p>
 * 输入: "word"
 * 输出:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generalized-abbreviation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GeneralizedAbbreviation {

    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        int size = 1 << word.length();
        for (int x = 0; x < size; ++x) {
            ans.add(getWord(word, x));
        }
        return ans;
    }

    private String getWord(String word, int x) {
        StringBuilder builder = new StringBuilder();
        int k = 0, n = word.length();
        for (int i = 0; i < n; ++i, x >>= 1) {
            if ((x & 1) == 0) {
                if (k != 0) {
                    builder.append(k);
                    k = 0;
                }
                builder.append(word.charAt(i));
            } else {
                ++k;
            }
        }
        if (k != 0) {
            builder.append(k);
        }
        return builder.toString();
    }
}
