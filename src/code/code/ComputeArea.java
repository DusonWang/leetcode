package code.code;

/**
 * @author duson
 * <p>
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * <p>
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * 说明: 假设矩形面积不会超出 int 的范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ComputeArea {

    public int computeArea(int a, int b, int c, int d, int e, int f, int g, int h) {
        int left = Math.max(a, e), right = Math.max(Math.min(c, g), left);
        int bottom = Math.max(b, f), top = Math.max(Math.min(d, h), bottom);
        return (c - a) * (d - b) - (right - left) * (top - bottom) + (g - e) * (h - f);
    }
}
