package com.leetcode.offer.code;

/**
 * @author duson
 * 回忆一下祖玛游戏。现在桌上有一串球，颜色有红色(R)，黄色(Y)，蓝色(B)，绿色(G)，还有白色(W)。 现在你手里也有几个球。
 * <p>
 * 每一次，你可以从手里的球选一个，然后把这个球插入到一串球中的某个位置上（包括最左端，最右端）。接着，如果有出现三个或者三个以上颜色相同的球相连的话，就把它们移除掉。重复这一步骤直到桌上所有的球都被移除。
 * <p>
 * 找到插入并可以移除掉桌上所有球所需的最少的球数。如果不能移除桌上所有的球，输出 -1 。
 * <p>
 * 示例:
 * 输入: "WRRBBW", "RB"
 * 输出: -1
 * 解释: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW （翻译者标注：手上球已经用完，桌上还剩两个球无法消除，返回-1）
 * <p>
 * 输入: "WWRRBBWW", "WRBRW"
 * 输出: 2
 * 解释: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 * <p>
 * 输入:"G", "GGGGG"
 * 输出: 2
 * 解释: G -> G[G] -> GG[G] -> empty
 * <p>
 * 输入: "RBYYBBRRB", "YRBGB"
 * 输出: 3
 * 解释: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
 * 标注:
 * <p>
 * 你可以假设桌上一开始的球中，不会有三个及三个以上颜色相同且连着的球。
 * 桌上的球不会超过20个，输入的数据中代表这些球的字符串的名字是 "board" 。
 * 你手中的球不会超过5个，输入的数据中代表这些球的字符串的名字是 "hand"。
 * 输入的两个字符串均为非空字符串，且只包含字符 'R','Y','B','G','W'。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuma-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMinStep {

    private int aux(String s, int[] c) {
        if ("".equals(s)) {
            return 0;
        }
        int res = 2 * s.length() + 1;
        for (int i = 0; i < s.length(); ) {
            int j = i++;
            while (i < s.length() && s.charAt(i) == s.charAt(j)) {
                i++;
            }
            int inc = 3 - i + j;
            if (c[s.charAt(j)] >= inc) {
                int used = Math.max(inc, 0);
                c[s.charAt(j)] -= used;
                int temp = aux(s.substring(0, j) + s.substring(i), c);
                if (temp >= 0) {
                    res = Math.min(res, used + temp);
                }
                c[s.charAt(j)] += used;
            }
        }
        return res == 2 * s.length() + 1 ? -1 : res;
    }

    public int findMinStep(String board, String hand) {
        int[] c = new int[128];
        for (char x : hand.toCharArray()) {
            c[x]++;
        }
        return aux(board, c);
    }

}
