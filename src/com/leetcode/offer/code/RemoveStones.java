package com.leetcode.offer.code;

/**
 * @author duson
 * 在二维平面上，我们将石头放置在一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * <p>
 * 现在，move 操作将会移除与网格上的某一块石头共享一列或一行的一块石头。
 * <p>
 * 我们最多能执行多少次 move 操作？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：stones = [[0,0]]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 * 通过次数1,848提交次数3,825
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveStones {

    private int[] parent;
    private int cnt = 0;

    public int removeStones(int[][] stones) {
        parent = new int[20000];

        for (int[] s : stones) {
            int i = find(s[0]);
            int j = find(s[1] + 10000);
            if (i != j) {
                cnt--;
                parent[i] = j;
            }
        }

        return stones.length - cnt;
    }

    private int find(int p) {
        if (parent[p] == 0) {
            cnt++;
            parent[p] = p;
        }
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }
}
