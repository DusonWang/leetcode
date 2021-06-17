package code.code;

/**
 * 给你一个由正整数组成的数组 nums 。
 * <p>
 * 数字序列的 最大公约数 定义为序列中所有整数的共有约数中的最大整数。
 * <p>
 * 例如，序列 [4,6,16] 的最大公约数是 2 。
 * 数组的一个 子序列 本质是一个序列，可以通过删除数组中的某些元素（或者不删除）得到。
 * <p>
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 计算并返回 nums 的所有 非空 子序列中 不同 最大公约数的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [6,10,3]
 * 输出：5
 * 解释：上图显示了所有的非空子序列与各自的最大公约数。
 * 不同的最大公约数为 6 、10 、3 、2 和 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,15,40,5,6]
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 2 * 105
 * 通过次数2,106提交次数5,923
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-different-subsequences-gcds
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountDifferentSubsequenceGCDs {

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[] present = new boolean[200001];
        for (int num : nums) {
            max = Math.max(max, num);
            present[num] = true;
        }
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (present[i]) {
                count++;
                continue;
            }
            int tmp = 0;
            for (int j = i; j <= max; j += i) {
                if (present[j]) {
                    tmp = gcd(tmp, j);
                }
                if (tmp == i) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
