package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CommonChars {

    public List<String> commonChars(String[] a) {
        List<String> result = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            int minCount = Integer.MAX_VALUE;
            for (String s : a) {
                int wordCount = 0;
                for (char c1 : s.toCharArray()) {
                    if (c1 == c) {
                        wordCount++;
                    }
                }
                minCount = Math.min(minCount, wordCount);
            }
            for (int i = 0; i < minCount; i++) {
                result.add("" + c);
            }
        }

        return result;
    }
}
