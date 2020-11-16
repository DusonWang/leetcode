package code.code;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author duson
 * 给出 字符串 text 和 字符串列表 words, 返回所有的索引对 [i, j] 使得在索引对范围内的子字符串 text[i]...text[j]（包括 i 和 j）属于字符串列表 words。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
 * 输出: [[3,7],[9,13],[10,17]]
 * 示例 2:
 * <p>
 * 输入: text = "ababa", words = ["aba","ab"]
 * 输出: [[0,1],[0,2],[2,3],[2,4]]
 * 解释:
 * 注意，返回的配对可以有交叉，比如，"aba" 既在 [0,2] 中也在 [2,4] 中
 *  
 * <p>
 * 提示:
 * <p>
 * 所有字符串都只包含小写字母。
 * 保证 words 中的字符串无重复。
 * 1 <= text.length <= 100
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 50
 * 按序返回索引对 [i,j]（即，按照索引对的第一个索引进行排序，当第一个索引对相同时按照第二个索引对排序）。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/index-pairs-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IndexPairs {

    public int[][] indexPairs(String text, String[] words) {
        Set<Integer> sizes = new TreeSet<>();
        for (String word : words) {
            sizes.add(word.length());
        }
        ArrayList<int[]> result = new ArrayList<>();
        for (int j = 0; j < text.length(); j++) {
            for (int m : sizes) {
                if (j + m <= text.length()) {
                    for (String n : words) {
                        if (text.substring(j, j + m).equals(n)) {
                            int[] tmp = new int[]{j, j + m - 1};
                            result.add(tmp);
                        }
                    }
                }
            }
        }
        int len = result.size();
        int[][] out = new int[len][2];
        for (int e = 0; e < len; e++) {
            out[e] = result.get(e);
        }
        return out;
    }
}
