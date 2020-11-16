package code.code;

/**
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * <p>
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 * <p>
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 * <p>
 * nums.length <=?30000
 * 通过次数1,545提交次数2,819
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-two-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingTwo {

    public int[] missingTwo(int[] nums) {
        int[] res = new int[2];
        int cnt = nums.length + 2;
        int ans = 0;
        for (int num : nums) {
            ans += num;
        }
        int sum = (1 + cnt) * cnt / 2;
        int tmp = sum - ans;
        int half = tmp / 2;
        int first = 0;
        for (int num : nums) {
            if (num <= half) {
                first += num;
            }
        }
        res[0] = (1 + half) * half / 2 - first;
        res[1] = tmp - res[0];
        return res;
    }
}
