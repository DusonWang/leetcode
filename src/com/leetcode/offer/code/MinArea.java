package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 图片在计算机处理中往往是使用二维矩阵来表示的。
 * <p>
 * 假设，这里我们用的是一张黑白的图片，那么 0 代表白色像素，1 代表黑色像素。
 * <p>
 * 其中黑色的像素他们相互连接，也就是说，图片中只会有一片连在一块儿的黑色像素（像素点是水平或竖直方向连接的）。
 * <p>
 * 那么，给出某一个黑色像素点 (x, y) 的位置，你是否可以找出包含全部黑色像素的最小矩形（与坐标轴对齐）的面积呢？
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * "0010",
 * "0110",
 * "0100"
 * ]
 * 和 x = 0, y = 2
 * <p>
 * 输出: 6
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-rectangle-enclosing-black-pixels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinArea {

    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int minr = x;
        int maxr = x;
        int minc = y;
        int maxc = y;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == '1') {
                    minr = Math.min(minr, i);
                    maxr = Math.max(maxr, i);
                    minc = Math.min(minc, j);
                    maxc = Math.max(maxc, j);
                }
            }
        }
        return (maxr - minr + 1) * (maxc - minc + 1);
    }
}
