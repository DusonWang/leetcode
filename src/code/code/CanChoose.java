package code.code;

/**
 * 给你一个长度为 n的二维整数数组groups，同时给你一个整数数组nums。
 * <p>
 * 你是否可以从 nums中选出 n个 不相交 的子数组，使得第 i个子数组与 groups[i]（下标从 0开始）完全相同，且如果i > 0，那么第(i-1)个子数组在 nums中出现的位置在第 i个子数组前面。（也就是说，这些子数组在 nums中出现的顺序需要与 groups 顺序相同）
 * <p>
 * 如果你可以找出这样的 n 个子数组，请你返回true ，否则返回false。
 * <p>
 * 如果不存在下标为 k的元素 nums[k]属于不止一个子数组，就称这些子数组是 不相交 的。子数组指的是原数组中连续元素组成的一个序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：groups = [[1,-1,-1],[3,-2,0]], nums = [1,-1,0,1,-1,-1,3,-2,0]
 * 输出：true
 * 解释：你可以分别在 nums 中选出第 0 个子数组 [1,-1,0,1,-1,-1,3,-2,0] 和第 1 个子数组 [1,-1,0,1,-1,-1,3,-2,0] 。
 * 这两个子数组是不相交的，因为它们没有任何共同的元素。
 * 示例 2：
 * <p>
 * 输入：groups = [[10,-2],[1,2,3,4]], nums = [1,2,3,4,10,-2]
 * 输出：false
 * 解释：选择子数组 [1,2,3,4,10,-2] 和 [1,2,3,4,10,-2] 是不正确的，因为它们出现的顺序与 groups 中顺序不同。
 * [10,-2] 必须出现在 [1,2,3,4] 之前。
 * 示例 3：
 * <p>
 * 输入：groups = [[1,2,3],[3,4]], nums = [7,7,1,2,3,4,7,7]
 * 输出：false
 * 解释：选择子数组 [7,7,1,2,3,4,7,7] 和 [7,7,1,2,3,4,7,7] 是不正确的，因为它们不是不相交子数组。
 * 它们有一个共同的元素 nums[4] （下标从 0 开始）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * groups.length == n
 * 1 <= n <= 103
 * 1 <= groups[i].length, sum(groups[i].length) <= 103
 * 1 <= nums.length <= 103
 * -107 <= groups[i][j], nums[k] <= 107
 * 通过次数2,002提交次数4,213
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/form-array-by-concatenating-subarrays-of-another-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanChoose {

    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < groups.length) {
            int k = 0;
            while (i + k < nums.length
                    && k < groups[j].length
                    && nums[i + k] == groups[j][k]) {
                k++;
            }
            if (k == groups[j].length) {
                j++;
                i += k;
            } else {
                i++;
            }
        }
        return j == groups.length;
    }

    private int kmp(int[] arr, int[] arr2, int s) {
        int[] next = new int[arr.length];
        next[0] = -1;
        int i = 0;
        int j = 1;
        while (j < arr.length - 1) {
            if (i == -1 || arr[i] == arr[j]) {
                next[++j] = ++i;
            } else {
                i = next[i];
            }
        }
        i = 0;
        j = s;
        while (i < arr.length && j < arr2.length) {
            if (i == -1 || arr[i] == arr2[j]) {
                i++;
                j++;
            } else {
                i = next[i];
            }
        }
        return i >= arr.length ? j : -1;
    }

    public boolean canChoose2(int[][] groups, int[] nums) {
        int n = groups.length;
        for (int i = 0, j = 0; i < n; i++) {
            j = kmp(groups[i], nums, j);
            if (j == -1) {
                return false;
            }
        }
        return true;
    }
}
