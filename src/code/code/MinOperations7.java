package code.code;

import java.util.Arrays;

/**
 * 有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
 * <p>
 * 在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。
 * <p>
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
 * <p>
 * 每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：boxes = "110"
 * 输出：[1,1,3]
 * 解释：每个盒子对应的最小操作数如下：
 * 1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
 * 2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
 * 3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共计 3 步操作。
 * 示例 2：
 * <p>
 * 输入：boxes = "001011"
 * 输出：[11,8,5,4,3,4]
 * ?
 * <p>
 * 提示：
 * <p>
 * n == boxes.length
 * 1 <= n <= 2000
 * boxes[i] 为 '0' 或 '1'
 * 通过次数8,762提交次数10,225
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinOperations7 {

    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] res = new int[len];
        int ops = 0;
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            res[i] += ops;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            ops += cnt;
        }
        ops = 0;
        cnt = 0;
        for (int i = len - 1; i >= 0; --i) {
            res[i] += ops;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            ops += cnt;
        }
        return res;
    }

    public static void main(String[] args) {
        MinOperations7 minOperations7 = new MinOperations7();
        System.out.println(Arrays.toString(minOperations7.minOperations("10010")));
    }
}
