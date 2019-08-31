package com.leetcode.offer.day18;

/**
 * @author duson
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回符合要求的最少分割次数。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCut {

    public int minCut(String s) {
        char[] c = s.toCharArray();
        int size = c.length;
        int[] cut = new int[size];
        boolean[][] pal = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (c[j] == c[i] && (i - j < 2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[size - 1];
    }

    public static void main(String[] args) {
        MinCut minCut = new MinCut();
        System.out.println(minCut.minCut("aab"));
    }
}
