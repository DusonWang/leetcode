package code.luogu;

import java.util.Scanner;

/**
 * P1120 小木棍 ［数据加强版］
 * https://www.luogu.com.cn/problem/P1120
 * 题目描述
 * 乔治有一些同样长的小木棍，他把这些木棍随意砍成几段，直到每段的长都不超过5050。
 * <p>
 * 现在，他想把小木棍拼接成原来的样子，但是却忘记了自己开始时有多少根木棍和它们的长度。
 * <p>
 * 给出每段小木棍的长度，编程帮他找出原始木棍的最小可能长度。
 * <p>
 * 输入格式
 * 共二行。
 * <p>
 * 第一行为一个单独的整数N表示砍过以后的小木棍的总数，其中N≤65N≤65
 * <p>
 * （管理员注：要把超过5050的长度自觉过滤掉，坑了很多人了！）
 * <p>
 * 第二行为NN个用空个隔开的正整数，表示NN根小木棍的长度。
 * <p>
 * 输出格式
 * 一个数，表示要求的原始木棍的最小可能长度
 * <p>
 * 输入输出样例
 * 输入 #1复制
 * 9
 * 5 2 1 5 2 1 5 2 1
 * 输出 #1复制
 * 6
 * 说明/提示
 * 2017/08/05
 * <p>
 * 数据时限修改：
 * <p>
 * -#17 #20 #22 #27 四组数据时限500ms500ms
 * <p>
 * -#21 #24 #28 #29 #30五组数据时限1000ms1000ms
 * <p>
 * 其他时限改为300ms300ms（请放心食用）
 */
public class MainLittleStick {

    public static int[] num = new int[500010];
    public static int maxN;
    public static int minN;

    public static void dfs(int wait, int already, int need, int can) {
        if (wait == 0) {
            System.out.println(need);
            System.exit(0);
        }
        if (already == need) {
            dfs(wait - 1, 0, need, maxN);
            return;
        }
        for (int i = can; i >= minN; i--) {
            if (num[i] > 0 && i + already <= need) {
                num[i]--;
                dfs(wait, already + i, need, i);
                num[i]++;
                if (already == 0 || already + i == need) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int k = cin.nextInt();
            if (k <= 50) {
                sum += k;
                num[k]++;
                minN = Math.min(k, minN);
                maxN = Math.max(k, maxN);
            }
        }
        int temp = sum / 2;
        for (int i = maxN; i <= temp; i++) {
            if (sum % i == 0) {
                dfs(sum / i, 0, i, maxN);
            }
        }
        System.out.println(sum);
    }
}
