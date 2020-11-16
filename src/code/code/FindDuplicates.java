package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * <p>
 * 找到所有出现两次的元素。
 * <p>
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * <p>
 * 示例：
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [2,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDuplicates {

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> rs = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) {
                rs.add(i + 1);
            }
        }
        return rs;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return list;
    }

    public static void main(String[] args) {
        FindDuplicates findDuplicates = new FindDuplicates();
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates.findDuplicates(nums));
    }
}
