package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {

    private void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n) {
            output.add(new ArrayList<>(nums));
        }
        for (int i = first; i < n; i++) {
            if (first != i) {
                Collections.swap(nums, first, i);
            }
            backtrack(n, nums, output, first + 1);
            if (first != i) {
                Collections.swap(nums, first, i);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        int n = nums.length;
        backtrack(n, numsList, output, 0);
        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permute permute = new Permute();
        List<List<Integer>> lists = permute.permute(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
