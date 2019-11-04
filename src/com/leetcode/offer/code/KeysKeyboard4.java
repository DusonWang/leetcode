package com.leetcode.offer.code;

/**
 * @author duson
 * 假设你有一个特殊的键盘包含下面的按键：
 * <p>
 * Key 1: (A)：在屏幕上打印一个 'A'。
 * <p>
 * Key 2: (Ctrl-A)：选中整个屏幕。
 * <p>
 * Key 3: (Ctrl-C)：复制选中区域到缓冲区。
 * <p>
 * Key 4: (Ctrl-V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
 * <p>
 * 现在，你只可以按键 N 次（使用上述四种按键），请问屏幕上最多可以显示几个 'A'呢？
 * <p>
 * 样例 1:
 * <p>
 * 输入: N = 3
 * 输出: 3
 * 解释:
 * 我们最多可以在屏幕上显示三个'A'通过如下顺序按键：
 * A, A, A
 *  
 * <p>
 * 样例 2:
 * <p>
 * 输入: N = 7
 * 输出: 9
 * 解释:
 * 我们最多可以在屏幕上显示九个'A'通过如下顺序按键：
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 *  
 * <p>
 * 注释:
 * <p>
 * 1 <= N <= 50
 * 结果不会超过 32 位有符号整数范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4-keys-keyboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KeysKeyboard4 {

    public int maxA2(int n) {
        if (n < 7) {
            return n;
        }

        int ans = maxA2(n - 4) * 3;
        ans = Math.max(ans, maxA2(n - 5) * 4);
        return ans;
    }

    public int maxA(int b) {
        int[] dp = new int[51];
        dp[0] = 0;
        for (int i = 1; i <= b; i++) {
            dp[i] = i;
            for (int j = 4; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 1] * (i - j));
            }
        }
        return dp[b];
    }
}
