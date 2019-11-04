package com.leetcode.offer.code;

/**
 * @author duson
 * 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
 * <p>
 * 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
 * <p>
 * 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
 * <p>
 * 返回表示最终状态的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 * 示例 2：
 * <p>
 * 输入："RR.L"
 * 输出："RR.L"
 * 说明：第一张多米诺骨牌没有给第二张施加额外的力。
 * 提示：
 * <p>
 * 0 <= N <= 10^5
 * 表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.';
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/push-dominoes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PushDominoes {

    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() == 0) {
            return dominoes;
        }
        char[] d = dominoes.toCharArray();
        int fRight = -1;
        int fLeft = 0;
        for (int i = 0; i <= d.length; i++) {
            if (i == d.length || d[i] == 'R') {
                if (fRight != -1) {
                    for (int r = fRight + 1; r < i; r++) {
                        d[r] = 'R';
                    }
                }
                fRight = i;
            } else if (d[i] == 'L') {
                if (fRight == -1) {
                    for (int l = i - 1; l >= fLeft; l--) {
                        d[l] = 'L';
                    }
                } else {
                    for (int r = fRight + 1, l = i - 1; r < l; r++, l--) {
                        d[r] = 'R';
                        d[l] = 'L';
                    }
                    fRight = -1;
                }
                fLeft = i;
            }
        }
        return String.valueOf(d);
    }
}
