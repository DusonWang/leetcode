package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 * <p>
 * 在每一步操作中，你可以选择任意 m （1 ≤ m ≤ n） 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 * <p>
 * 给定一个非负整数数组代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。如果不能使每台洗衣机中衣物的数量相等，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,0,5]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * 第一步:    1     0 <-- 5    =>    1     1     4
 * 第二步:    1 <-- 1 <-- 4    =>    2     1     3
 * 第三步:    2     1 <-- 3    =>    2     2     2
 * 示例 2：
 * <p>
 * 输入: [0,3,0]
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 第一步:    0 <-- 3     0    =>    1     2     0
 * 第二步:    1     2 --> 0    =>    1     1     1
 * 示例 3:
 * <p>
 * 输入: [0,2,0]
 * <p>
 * 输出: -1
 * <p>
 * 解释:
 * 不可能让所有三个洗衣机同时剩下相同数量的衣物。
 *  
 * <p>
 * 提示：
 * <p>
 * n 的范围是 [1, 10000]。
 * 在每台超级洗衣机中，衣物数量的范围是 [0, 1e5]。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-washing-machines
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMinMoves {

    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) {
            return -1;
        }
        int total = 0;
        for (int load : machines) {
            total += load;
        }
        final int len = machines.length;
        if (total % len != 0) {
            return -1;
        }
        int max = 0;
        int avg = total / len;
        int cnt = 0;
        int asset;
        for (int load : machines) {
            asset = load - avg;
            cnt += asset;
            max = Math.max(Math.max(max, Math.abs(cnt)), asset);
        }
        return max;
    }
}
