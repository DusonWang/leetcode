package code.code;

/**
 * @author duson
 * 给你一个整数数组 target 。一开始，你有一个数组 A ，它的所有元素均为 1 ，你可以执行以下操作：
 * <p>
 * 令 x 为你数组里所有元素的和
 * 选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。
 * 你可以重复该过程任意次
 * 如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = [9,3,5]
 * 输出：true
 * 解释：从 [1, 1, 1] 开始
 * [1, 1, 1], 和为 3 ，选择下标 1
 * [1, 3, 1], 和为 5， 选择下标 2
 * [1, 3, 5], 和为 9， 选择下标 0
 * [9, 3, 5] 完成
 * 示例 2：
 * <p>
 * 输入：target = [1,1,1,2]
 * 输出：false
 * 解释：不可能从 [1,1,1,1] 出发构造目标数组。
 * 示例 3：
 * <p>
 * 输入：target = [8,5]
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * N == target.length
 * 1 <= target.length <= 5 * 10^4
 * 1 <= target[i] <= 10^9
 * 通过次数1,389提交次数4,353
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-target-array-with-multiple-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPossible2 {

    public boolean isPossible(int[] target) {
        int max = 0;
        int index = -1;
        long sum = 0;
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            if (target[i] > max) {
                max = target[i];
                index = i;
            }
        }
        if (max == 1) {
            return true;
        }
        long left = sum - max;
        if (left == 0) {
            return false;
        }
        target[index] %= left;
        if (target[index] == 0) {
            target[index] += left;
        }
        if (target[index] == max) {
            return false;
        }
        return isPossible(target);
    }
}
