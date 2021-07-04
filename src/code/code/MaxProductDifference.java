package code.code;

/**
 * 两个数对?(a, b) 和 (c, d) 之间的 乘积差 定义为 (a * b) - (c * d) 。
 * <p>
 * 例如，(5, 6) 和 (2, 7) 之间的乘积差是 (5 * 6) - (2 * 7) = 16 。
 * 给你一个整数数组 nums ，选出四个 不同的 下标 w、x、y 和 z ，使数对 (nums[w], nums[x]) 和 (nums[y], nums[z]) 之间的 乘积差 取到 最大值 。
 * <p>
 * 返回以这种方式取得的乘积差中的 最大值 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,6,2,7,4]
 * 输出：34
 * 解释：可以选出下标为 1 和 3 的元素构成第一个数对 (6, 7) 以及下标 2 和 4 构成第二个数对 (2, 4)
 * 乘积差是 (6 * 7) - (2 * 4) = 34
 * 示例 2：
 * <p>
 * 输入：nums = [4,2,5,9,7,4,8]
 * 输出：64
 * 解释：可以选出下标为 3 和 6 的元素构成第一个数对 (9, 8) 以及下标 1 和 5 构成第二个数对 (2, 4)
 * 乘积差是 (9 * 8) - (2 * 4) = 64
 * ?
 * <p>
 * 提示：
 * <p>
 * 4 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 * 通过次数5,231提交次数6,088
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-difference-between-two-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProductDifference {

    public int maxProductDifference(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        int min1 = Integer.MAX_VALUE;
        int min2 = min1;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return max1 * max2 - min1 * min2;
    }
}
