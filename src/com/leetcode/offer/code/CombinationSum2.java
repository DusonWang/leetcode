package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum2 {

    private void backTrack(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int idx) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < candidates.length && target >= candidates[i]; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);

            backTrack(lists, list, candidates, target - candidates[i], i + 1);

            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(lists, list, candidates, target, 0);
        return lists;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        CombinationSum2 combinationSum = new CombinationSum2();
        List<List<Integer>> combinationSumList = combinationSum.combinationSum2(candidates, target);
        System.out.println(combinationSumList);

    }

}
