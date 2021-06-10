package code.code;

import java.util.PriorityQueue;

/**
 * 给你一个由 n 个正整数组成的数组 nums 。
 * <p>
 * 你可以对数组的任意元素执行任意次数的两类操作：
 * <p>
 * 如果元素是 偶数 ，除以 2
 * 例如，如果数组是 [1,2,3,4] ，那么你可以对最后一个元素执行此操作，使其变成 [1,2,3,2]
 * 如果元素是 奇数 ，乘上 2
 * 例如，如果数组是 [1,2,3,4] ，那么你可以对第一个元素执行此操作，使其变成 [2,2,3,4]
 * 数组的 偏移量 是数组中任意两个元素之间的 最大差值 。
 * <p>
 * 返回数组在执行某些操作之后可以拥有的 最小偏移量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：1
 * 解释：你可以将数组转换为 [1,2,3,2]，然后转换成 [2,2,3,2]，偏移量是 3 - 2 = 1
 * 示例 2：
 * <p>
 * 输入：nums = [4,1,5,20,3]
 * 输出：3
 * 解释：两次操作后，你可以将数组转换为 [4,2,5,5,3]，偏移量是 5 - 2 = 3
 * 示例 3：
 * <p>
 * 输入：nums = [2,10,8]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 2 <= n <= 105
 * 1 <= nums[i] <= 109
 * 通过次数2,282提交次数5,218
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimize-deviation-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumDeviation {

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int min = Integer.MAX_VALUE;
        // step1: 给数组中所有奇数乘以2 得到的新数字，以及原来数组中的偶数，都保存到优先队列
        // 并保存最小数min
        for (int num : nums) {
            if ((num & 1) == 1) {
                num *= 2;
            }
            queue.add(num);
            min = Math.min(min, num);
        }
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res = Math.min(res, curr - min);
            // 如果是偶数，偶数除以2，保存到队列
            if ((curr & 1) == 0) {
                queue.add(curr / 2);
                // 除以2后的数字 比 目前队列里最小的数字还小，那么更新min值
                min = Math.min(min, curr / 2);
            } else {
                //如果队列中最大数是奇数，那不用继续操作了，结果已出
                break;
            }
        }
        return res;
    }

}
