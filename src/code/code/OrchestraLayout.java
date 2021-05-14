package code.code;

/**
 * 某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
 * <p>
 * 为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。例如当 num = 5 时，站位如图所示
 * <p>
 * <p>
 * <p>
 * 请返回位于场地坐标 [Xpos,Ypos] 的成员所持乐器编号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 3, Xpos = 0, Ypos = 2
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：num = 4, Xpos = 1, Ypos = 2
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 10^9
 * 0 <= Xpos, Ypos < num
 * 通过次数3,012提交次数20,168
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/SNJvJP
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OrchestraLayout {

    public int orchestraLayout(int num, int xPos, int yPos) {
        long i = xPos + 1, j = yPos + 1, n = num;
        long mi = Math.min(i, Math.min(j, Math.min(n - i + 1, n - j + 1))), ans;
        long aaa = mi * (4 * n - 4 * mi);
        if (i <= j) {
            ans = aaa + 6 * mi - 4 * n - 3 + i + j;
        } else {
            ans = aaa + 2 * mi + 1 - i - j;
        }
        return (int) (ans % 9 == 0 ? 9 : ans % 9);
    }
}
