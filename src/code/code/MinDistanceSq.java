package code.code;

/**
 * @author duson
 * <p>
 * 现在有一棵树，一只松鼠和一些坚果。位置由二维网格的单元格表示。你的目标是找到松鼠收集所有坚果的最小路程，且坚果是一颗接一颗地被放在树下。松鼠一次最多只能携带一颗坚果，松鼠可以向上，向下，向左和向右四个方向移动到相邻的单元格。移动次数表示路程。
 * <p>
 * 输入 1:
 * <p>
 * 输入:
 * 高度 : 5
 * 宽度 : 7
 * 树的位置 : [2,2]
 * 松鼠 : [4,4]
 * 坚果 : [[3,0], [2,5]]
 * 输出: 12
 * 解释:
 * ​​​​​
 * 注意:
 * <p>
 * 所有给定的位置不会重叠。
 * 松鼠一次最多只能携带一颗坚果。
 * 给定的坚果位置没有顺序。
 * 高度和宽度是正整数。 3 <= 高度 * 宽度 <= 10,000。
 * 给定的网格至少包含一颗坚果，唯一的一棵树和一只松鼠。
 * 通过次数240提交次数383
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squirrel-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDistanceSq {

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int res = 0;
        int dis = Integer.MAX_VALUE;
        for (int[] nut : nuts) {
            res += cal(tree, nut) * 2;
            dis = Math.min(dis, cal(squirrel, nut) - cal(tree, nut));
        }
        return res + dis;
    }

    private int cal(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
