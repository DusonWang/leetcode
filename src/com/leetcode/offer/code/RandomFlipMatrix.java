package com.leetcode.offer.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author duson
 * 题中给出一个 n 行 n 列的二维矩阵 (n_rows,n_cols)，且所有值被初始化为 0。要求编写一个 flip 函数，均匀随机的将矩阵中的 0 变为 1，并返回该值的位置下标 [row_id,col_id]；同样编写一个 reset 函数，将所有的值都重新置为 0。尽量最少调用随机函数 Math.random()，并且优化时间和空间复杂度。
 * <p>
 * 注意:
 * <p>
 * 1.1 <= n_rows, n_cols <= 10000
 * <p>
 * 2. 0 <= row.id < n_rows 并且 0 <= col.id < n_cols
 * <p>
 * 3.当矩阵中没有值为 0 时，不可以调用 flip 函数
 * <p>
 * 4.调用 flip 和 reset 函数的次数加起来不会超过 1000 次
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["Solution","flip","flip","flip","flip"]
 * [[2,3],[],[],[],[]]
 * 输出: [null,[0,1],[1,2],[1,0],[1,1]]
 * 示例 2：
 * <p>
 * 输入:
 * ["Solution","flip","flip","reset","flip"]
 * [[1,2],[],[],[],[]]
 * 输出: [null,[0,0],[0,1],null,[0,0]]
 * 输入语法解释：
 * <p>
 * 输入包含两个列表：被调用的子程序和他们的参数。Solution 的构造函数有两个参数，分别为 n_rows 和 n_cols。flip 和 reset 没有参数，参数总会以列表形式给出，哪怕该列表为空
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-flip-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandomFlipMatrix {

    private Map<Integer, Integer> map;
    private int rows, cols, total;
    private Random rand;

    public RandomFlipMatrix(int nRows, int nCols) {
        map = new HashMap<>();
        rand = new Random();
        rows = nRows;
        cols = nCols;
        total = rows * cols;
    }

    public int[] flip() {
        int r = rand.nextInt(total--);
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        return new int[]{x / cols, x % cols};
    }

    public void reset() {
        map.clear();
        total = rows * cols;
    }

}
