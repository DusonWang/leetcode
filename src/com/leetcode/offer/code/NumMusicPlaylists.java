package com.leetcode.offer.code;

/**
 * @author duson
 * 你的音乐播放器里有 N 首不同的歌，在旅途中，你的旅伴想要听 L 首歌（不一定不同，即，允许歌曲重复）。请你为她按如下规则创建一个播放列表：
 * <p>
 * 每首歌至少播放一次。
 * 一首歌只有在其他 K 首歌播放完之后才能再次播放。
 * 返回可以满足要求的播放列表的数量。由于答案可能非常大，请返回它模 10^9 + 7 的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 3, L = 3, K = 1
 * 输出：6
 * 解释：有 6 种可能的播放列表。[1, 2, 3]，[1, 3, 2]，[2, 1, 3]，[2, 3, 1]，[3, 1, 2]，[3, 2, 1].
 * 示例 2：
 * <p>
 * 输入：N = 2, L = 3, K = 0
 * 输出：6
 * 解释：有 6 种可能的播放列表。[1, 1, 2]，[1, 2, 1]，[2, 1, 1]，[2, 2, 1]，[2, 1, 2]，[1, 2, 2]
 * 示例 3：
 * <p>
 * 输入：N = 2, L = 3, K = 1
 * 输出：2
 * 解释：有 2 种可能的播放列表。[1, 2, 1]，[2, 1, 2]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= K < N <= L <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-music-playlists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumMusicPlaylists {

    public int numMusicPlaylists(int n, int l, int k) {
        long mod = (long) Math.pow(10, 9) + 7;
        long[][] dp = new long[l + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (n - (j - 1))) % mod;
                if (j > k) {
                    dp[i][j] = (dp[i][j] + (dp[i - 1][j] * (j - k)) % mod) % mod;
                }
            }
        }
        return (int) dp[l][n];
    }
}
