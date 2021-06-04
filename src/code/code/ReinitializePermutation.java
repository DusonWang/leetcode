package code.code;

/**
 * 给你一个偶数 n ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i（下标 从 0 开始 计数）。
 * <p>
 * 一步操作中，你将创建一个新数组 arr ，对于每个 i ：
 * <p>
 * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
 * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 * 然后将 arr 赋值给 perm 。
 * <p>
 * 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：最初，perm = [0,1]
 * 第 1步操作后，perm = [0,1]
 * 所以，仅需执行 1 步操作
 * 示例 2：
 * <p>
 * 输入：n = 4
 * 输出：2
 * 解释：最初，perm = [0,1,2,3]
 * 第 1步操作后，perm = [0,2,1,3]
 * 第 2步操作后，perm = [0,1,2,3]
 * 所以，仅需执行 2 步操作
 * 示例 3：
 * <p>
 * 输入：n = 6
 * 输出：4
 *
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 * n 是一个偶数
 * 通过次数4,773提交次数7,276
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReinitializePermutation {

    public int reinitializePermutation(int n) {
        int res = 0;
        int i = 1;
        while (res == 0 || i > 1) {
            i = (i << 1) % (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        ReinitializePermutation reinitializePermutation = new ReinitializePermutation();
        System.out.println(reinitializePermutation.reinitializePermutation(2));
        System.out.println(reinitializePermutation.reinitializePermutation(4));
        System.out.println(reinitializePermutation.reinitializePermutation(6));
    }
}
