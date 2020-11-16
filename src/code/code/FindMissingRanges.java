package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 * <p>
 * 示例：
 * <p>
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long pre = (long) lower - 1;
        for (int num : nums) {
            if (num - pre == 2) {
                res.add(String.valueOf(pre + 1));
            } else if (num - pre > 2) {
                res.add((pre + 1) + "->" + (num - 1));
            }
            pre = num;
        }
        if (upper - pre == 1) {
            res.add(String.valueOf(pre + 1));
        } else if (upper - pre > 1) {
            res.add((pre + 1) + "->" + upper);
        }
        return res;
    }

    public static void main(String[] args) {
        FindMissingRanges findMissingRanges = new FindMissingRanges();
        System.out.println(findMissingRanges.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
    }
}
