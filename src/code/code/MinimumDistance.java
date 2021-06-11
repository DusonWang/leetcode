package code.code;

/**
 * 二指输入法定制键盘在 XY 平面上的布局如上图所示，其中每个大写英文字母都位于某个坐标处，例如字母A位于坐标(0,0)，字母B位于坐标(0,1)，字母P位于坐标(2,3)且字母 Z位于坐标(4,1)。
 * <p>
 * 给你一个待输入字符串word，请你计算并返回在仅使用两根手指的情况下，键入该字符串需要的最小移动总距离。坐标(x1,y1) 和 (x2,y2) 之间的距离是|x1 - x2| + |y1 - y2|。
 * <p>
 * 注意，两根手指的起始位置是零代价的，不计入移动总距离。你的两根手指的起始位置也不必从首字母或者前两个字母开始。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "CAKE"
 * 输出：3
 * 解释：
 * 使用两根手指输入 "CAKE" 的最佳方案之一是：
 * 手指 1 在字母 'C' 上 -> 移动距离 = 0
 * 手指 1 在字母 'A' 上 -> 移动距离 = 从字母 'C' 到字母 'A' 的距离 = 2
 * 手指 2 在字母 'K' 上 -> 移动距离 = 0
 * 手指 2 在字母 'E' 上 -> 移动距离 = 从字母 'K' 到字母 'E' 的距离  = 1
 * 总距离 = 3
 * 示例 2：
 * <p>
 * 输入：word = "HAPPY"
 * 输出：6
 * 解释：
 * 使用两根手指输入 "HAPPY" 的最佳方案之一是：
 * 手指 1 在字母 'H' 上 -> 移动距离 = 0
 * 手指 1 在字母 'A' 上 -> 移动距离 = 从字母 'H' 到字母 'A' 的距离 = 2
 * 手指 2 在字母 'P' 上 -> 移动距离 = 0
 * 手指 2 在字母 'P' 上 -> 移动距离 = 从字母 'P' 到字母 'P' 的距离 = 0
 * 手指 1 在字母 'Y' 上 -> 移动距离 = 从字母 'A' 到字母 'Y' 的距离 = 4
 * 总距离 = 6
 * 示例 3：
 * <p>
 * 输入：word = "NEW"
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：word = "YEAR"
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= word.length <= 300
 * 每个 word[i]都是一个大写英文字母。
 * 通过次数2,308提交次数3,952
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-to-type-a-word-using-two-fingers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumDistance {

    public int minimumDistance(String word) {
        int[] dp = new int[26];
        int res = 0;
        int save = 0;
        int n = word.length();
        for (int i = 0; i < n - 1; ++i) {
            int b = word.charAt(i) - 'A';
            int c = word.charAt(i + 1) - 'A';
            for (int a = 0; a < 26; ++a) {
                dp[b] = Math.max(dp[b], dp[a] + dis(b, c) - dis(a, c));
            }
            save = Math.max(save, dp[b]);
            res += dis(b, c);
        }
        return res - save;

    }

    private int dis(int a, int b) {
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }

    int[][][] dp = new int[27][27][301];

    public int minimumDistance2(String word) {
        return dfs(word, 0, 0, 0);
    }

    private int dfs(String word, int start, int l, int r) {
        if (start >= word.length()) {
            return 0;
        }
        if (dp[l][r][start] != 0) {
            return dp[l][r][start];
        }
        int idx = word.charAt(start) - 'A' + 1;
        dp[l][r][start] = Math.min(dist(l, idx) + dfs(word, start + 1, idx, r), dist(r, idx) + dfs(word, start + 1, l, idx));
        return dp[l][r][start];
    }

    private int dist(int from, int to) {
        if (from == 0) {
            return 0;
        }
        return Math.abs((from - 1) / 6 - (to - 1) / 6) + Math.abs((from - 1) % 6 - (to - 1) % 6);
    }


    public static void main(String[] args) {
        MinimumDistance minimumDistance = new MinimumDistance();
        System.out.println(minimumDistance.minimumDistance("CAKE"));
    }
}
