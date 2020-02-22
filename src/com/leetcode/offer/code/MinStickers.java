package com.leetcode.offer.code;

/**
 * @author duson
 * 我们给出了 N 种不同类型的贴纸。每个贴纸上都有一个小写的英文单词。
 * <p>
 * 你希望从自己的贴纸集合中裁剪单个字母并重新排列它们，从而拼写出给定的目标字符串 target。
 * <p>
 * 如果你愿意的话，你可以不止一次地使用每一张贴纸，而且每一张贴纸的数量都是无限的。
 * <p>
 * 拼出目标 target 所需的最小贴纸数量是多少？如果任务不可能，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * <p>
 * ["with", "example", "science"], "thehat"
 * 输出：
 * <p>
 * 3
 * 解释：
 * <p>
 * 我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
 * 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
 * 此外，这是形成目标字符串所需的最小贴纸数量。
 * 示例 2：
 * <p>
 * 输入：
 * <p>
 * ["notice", "possible"], "basicbasic"
 * 输出：
 * <p>
 * -1
 * 解释：
 * <p>
 * 我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。
 *  
 * <p>
 * 提示：
 * <p>
 * stickers 长度范围是 [1, 50]。
 * stickers 由小写英文单词组成（不带撇号）。
 * target 的长度在 [1, 15] 范围内，由小写字母组成。
 * 在所有的测试案例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选取的，目标是两个随机单词的串联。
 * 时间限制可能比平时更具挑战性。预计 50 个贴纸的测试案例平均可在35ms内解决。
 *  
 * <p>
 * 通过次数852提交次数1,958
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stickers-to-spell-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStickers {

    private int[][] countMap;
    private int cnt = Integer.MAX_VALUE;

    public int minStickers(String[] stickers, String target) {
        if (target == null) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        if (stickers == null || stickers.length == 0) {
            return -1;
        }

        int m = stickers.length;
        countMap = new int[m][26];

        for (int i = 0; i < stickers.length; i++) {
            String s = stickers[i];
            for (char c : s.toCharArray()) {
                countMap[i][c - 'a']++;
            }
        }
        count(0, 0, new int[26], target, stickers);
        return cnt == Integer.MAX_VALUE ? -1 : cnt;
    }

    private void count(int curCnt, int pos, int[] charAvailable, String target, String[] stickers) {
        if (curCnt >= cnt) {
            return;
        }
        int m = stickers.length, n = target.length();
        if (pos == n) {
            cnt = Math.min(cnt, curCnt);
            return;
        }
        char c = target.charAt(pos);
        if (charAvailable[c - 'a'] > 0) {
            charAvailable[c - 'a']--;
            count(curCnt, pos + 1, charAvailable, target, stickers);
            charAvailable[c - 'a']++;
        } else {
            for (int i = 0; i < m; i++) {
                if (countMap[i][c - 'a'] == 0) {
                    continue;
                }
                for (int j = 0; j < 26; j++) {
                    charAvailable[j] += countMap[i][j];
                }
                count(curCnt + 1, pos, charAvailable, target, stickers);
                for (int j = 0; j < 26; j++) {
                    charAvailable[j] -= countMap[i][j];
                }
            }
        }
    }
}
