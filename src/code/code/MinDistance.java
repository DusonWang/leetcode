package code.code;

/**
 * @author duson
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        final int n = word1.length();
        final int m = word2.length();

        if (n * m == 0) {
            return n + m;
        }

        int [][] d = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            d[0][j] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = d[i - 1][j] + 1;
                int down = d[i][j - 1] + 1;
                int leftDown = d[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }
                d[i][j] = Math.min(left, Math.min(down, leftDown));

            }
        }
        return d[n][m];
    }

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance("a", "b") == 0);
        System.out.println(minDistance.minDistance("horse", "ros") == 3);
        System.out.println(minDistance.minDistance("intention", "execution") == 5);

    }
}
