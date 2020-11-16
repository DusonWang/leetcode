package code.code;

import java.util.Arrays;
import java.util.Random;

/**
 * @author duson
 * 给定一个非重叠轴对齐矩形的列表 rects，写一个函数 pick 随机均匀地选取矩形覆盖的空间中的整数点。
 * <p>
 * 提示：
 * <p>
 * 整数点是具有整数坐标的点。
 * 矩形周边上的点包含在矩形覆盖的空间中。
 * 第 i 个矩形 rects [i] = [x1，y1，x2，y2]，其中 [x1，y1] 是左下角的整数坐标，[x2，y2] 是右上角的整数坐标。
 * 每个矩形的长度和宽度不超过 2000。
 * 1 <= rects.length <= 100
 * pick 以整数坐标数组 [p_x, p_y] 的形式返回一个点。
 * pick 最多被调用10000次。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * 输出:
 * [null,[4,1],[4,1],[3,3]]
 * 示例 2：
 * <p>
 * 输入:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * 输出:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 *  
 * <p>
 * 输入语法的说明：
 * <p>
 * 输入是两个列表：调用的子例程及其参数。Solution 的构造函数有一个参数，即矩形数组 rects。pick 没有参数。参数总是用列表包装的，即使没有也是如此。
 * <p>
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-point-in-non-overlapping-rectangles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution497 {

    private int[] accumulatedArea;
    private int[][] rects;
    private Random r;

    public Solution497(int[][] rects) {
        r = new Random();
        this.rects = rects;
        accumulatedArea = new int[rects.length];

        for (int i = 0; i < rects.length; i++) {
            int area = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            accumulatedArea[i] = (i == 0) ? area : area + accumulatedArea[i - 1];
        }
    }

    public int[] pick() {
        int target = 1 + r.nextInt(accumulatedArea[accumulatedArea.length - 1]);
        int i = Arrays.binarySearch(accumulatedArea, target);
        if (i < 0) {
            i = ~i;
        }
        int[] rect = rects[i];
        int x = rect[0] + r.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + r.nextInt(rect[3] - rect[1] + 1);
        return new int[]{x, y};
    }
}
