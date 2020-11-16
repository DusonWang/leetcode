package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(16);
        if (nums == null || nums.length < 3) {
            return list;
        }

        Arrays.sort(nums);

        final int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    List<Integer> ll = new ArrayList<>(3);
                    ll.add(nums[i]);
                    ll.add(nums[left]);
                    ll.add(nums[right]);
                    list.add(ll);
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        //int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{-2, 0, 0, 2, 2};

        List<List<Integer>> list = threeSum.threeSum(nums);
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }
}
