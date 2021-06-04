package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * <p>
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * <p>
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * <p>
 * 你的目标是确切地知道 F 的值是多少。
 * <p>
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 * <p>
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：K = 3, N = 14
 * 输出：4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= 100
 * 1 <= N <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SuperEggDrop {

    public int superEggDrop(int k, int n) {
        int[] a = new int[k];
        Arrays.fill(a, 1);

        while (a[k - 1] < n) {
            for (int j = k - 1; j > 0; j--) {
                a[j] = a[j] + a[j - 1] + 1;
            }
            a[0]++;
        }
        return a[0];
    }

    /**
     * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
     * <p>
     * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
     * <p>
     * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
     * <p>
     * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 2
     * 输出：2
     * 解释：我们可以将第一枚鸡蛋从 1 楼扔下，然后将第二枚从 2 楼扔下。
     * 如果第一枚鸡蛋碎了，可知 f = 0；
     * 如果第二没鸡蛋碎了，但第一枚没碎，可知 f = 1；
     * 否则，当两个鸡蛋都没碎时，可知 f = 2。
     * 示例 2：
     * <p>
     * 输入：n = 100
     * 输出：14
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 1000
     * 通过次数75提交次数93
     * 请问您在哪类招聘中遇到此题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int twoEggDrop(int n) {
        int[] a = new int[]{1, 1};
        while (a[1] < n) {
            a[1] += a[0] + 1;
            a[0]++;
        }
        return a[0];
    }

    public int superEggDrop2(int k, int n) {
        int[][] dp = new int[n + 1][k + 1];
        int m = 0;
        while (dp[m][k] < n) {
            m++;
            for (int e = 1; e <= k; e++) {
                dp[m][e] = dp[m - 1][e - 1] + dp[m - 1][e] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        SuperEggDrop superEggDrop = new SuperEggDrop();
        System.out.println(superEggDrop.twoEggDrop(2));
        System.out.println(superEggDrop.twoEggDrop(100));
    }
}
