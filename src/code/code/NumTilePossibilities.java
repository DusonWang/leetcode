package code.code;

/**
 * @author duson
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 * <p>
 * 输入："AAABBC"
 * 输出：188
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 * 在真实的面试中遇到过这道题？
 * <p>
 * 是
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-tile-possibilities
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumTilePossibilities {

    private int ret = 0;
    private int[] counts = new int[26];

    private void backtrack() {
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                ret++;
                counts[i]--;
                backtrack();
                counts[i]++;
            }
        }
    }

    public int numTilePossibilities(String tiles) {
        for (char ch : tiles.toCharArray()) {
            counts[ch - 'A']++;
        }
        backtrack();
        return ret;
    }
}
