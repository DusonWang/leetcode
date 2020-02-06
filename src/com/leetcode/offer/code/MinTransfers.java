package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * 一群朋友在度假期间会相互借钱。比如说，小爱同学支付了小新同学的午餐共计 10 美元。如果小明同学支付了小爱同学的出租车钱共计 5 美元。我们可以用一个三元组 (x, y, z) 表示一次交易，表示 x 借给 y 共计 z 美元。用 0, 1, 2 表示小爱同学、小新同学和小明同学（0, 1, 2 为人的标号），上述交易可以表示为 [[0, 1, 10], [2, 0, 5]]。
 * <p>
 * 给定一群人之间的交易信息列表，计算能够还清所有债务的最小次数。
 * <p>
 * 注意：
 * <p>
 * 一次交易会以三元组 (x, y, z) 表示，并有 x ≠ y 且 z > 0。
 * 人的标号可能不是按顺序的，例如标号可能为 0, 1, 2 也可能为 0, 2, 6。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [[0,1,10], [2,0,5]]
 * <p>
 * 输出：
 * 2
 * <p>
 * 解释：
 * 人 #0 给人 #1 共计 10 美元。
 * 人 #2 给人 #0 共计 5 美元。
 * <p>
 * 需要两次交易。一种方式是人 #1 分别给人 #0 和人 #2 各 5 美元。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 人 #0 给人 #1 共计 10 美元。Person #0 gave person #1 $10.
 * 人 #1 给人 #0 共计 1 美元。Person #1 gave person #0 $1.
 * 人 #1 给人 #2 共计 5 美元。Person #1 gave person #2 $5.
 * 人 #2 给人 #0 共计 5 美元。Person #2 gave person #0 $5.
 * <p>
 * 因此，人 #1 需要给人 #0 共计 4 美元，所有的债务即可还清。
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/optimal-account-balancing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinTransfers {

    public int minTransfers(int[][] transactions) {
        if (transactions == null || transactions.length == 0 || transactions[0].length == 0) {
            return 0;
        }
        Map<Integer, Integer> accountToDelta = new HashMap<>();
        for (int[] transaction : transactions) {
            int from = transaction[0];
            int to = transaction[1];
            int val = transaction[2];
            if (!accountToDelta.containsKey(from)) {
                accountToDelta.put(from, 0);
            }
            if (!accountToDelta.containsKey(to)) {
                accountToDelta.put(to, 0);
            }
            accountToDelta.put(from, accountToDelta.get(from) - val);
            accountToDelta.put(to, accountToDelta.get(to) + val);
        }
        List<Integer> deltas = new ArrayList<>();
        for (int delta : accountToDelta.values()) {
            if (delta != 0) {
                deltas.add(delta);
            }
        }
        int matchCount = removeMatchDeltas(deltas);
        return matchCount + minTransStartsFrom(deltas, 0);
    }

    private int removeMatchDeltas(List<Integer> deltas) {
        Collections.sort(deltas);
        int left = 0;
        int right = deltas.size() - 1;
        int matchCount = 0;
        while (left < right) {
            if (-1 * deltas.get(left) == deltas.get(right)) {
                deltas.remove(left);
                deltas.remove(right - 1);
                right -= 2;
                matchCount++;
            } else if (-1 * deltas.get(left) > deltas.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return matchCount;
    }

    private int minTransStartsFrom(List<Integer> deltas, int start) {
        int result = Integer.MAX_VALUE;
        int n = deltas.size();
        while (start < n && deltas.get(start) == 0) {
            start++;
        }
        if (start == n) {
            return 0;
        }
        for (int i = start + 1; i < n; i++) {
            if ((long) deltas.get(i) * deltas.get(start) < 0) {
                deltas.set(i, deltas.get(i) + deltas.get(start));
                result = Math.min(result, 1 + minTransStartsFrom(deltas, start + 1));
                deltas.set(i, deltas.get(i) - deltas.get(start));
            }
        }
        return result;
    }
}
