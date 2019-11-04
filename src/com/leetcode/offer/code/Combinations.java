package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combinations {
    public List<List<Integer>> combine2(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new ArrayList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            List<List<Integer>> result = new ArrayList<>();
            result.add(row);
            return result;
        }
        List<List<Integer>> result = combine2(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(combine2(n - 1, k));
        return result;
    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || k > n) {
            return res;
        }
        List<Integer> l = new ArrayList<>();
        backtrack(n, k, 1, l);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> l) {
        if (l.size() == k) {
            res.add(new ArrayList<>(l));
            return;
        }
        for (int i = start; i <= n - (k - l.size()) + 1; i++) {
            l.add(i);
            backtrack(n, k, i + 1, l);
            l.remove(l.size() - 1);
        }
    }
}
