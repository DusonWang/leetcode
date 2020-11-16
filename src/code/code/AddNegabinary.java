package code.code;

import java.util.Stack;

/**
 * @author duson
 * 给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。
 * <p>
 * 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 + (-2)^2 + (-2)^0 = -3。数组形式 的数字也同样不含前导零：以 arr 为例，这意味着要么 arr == [0]，要么 arr[0] == 1。
 * <p>
 * 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * 输出：[1,0,0,0,0]
 * 解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length <= 1000
 * 1 <= arr2.length <= 1000
 * arr1 和 arr2 都不含前导零
 * arr1[i] 为 0 或 1
 * arr2[i] 为 0 或 1
 * 通过次数1,058提交次数3,549
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/adding-two-negabinary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddNegabinary {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1, carry = 0;
        Stack<Integer> stack = new Stack<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int v1 = i >= 0 ? arr1[i--] : 0;
            int v2 = j >= 0 ? arr2[j--] : 0;
            carry = v1 + v2 + carry;
            stack.push(carry & 1);
            carry = -(carry >> 1);
        }
        while (!stack.isEmpty() && stack.peek() == 0) {
            stack.pop();
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res.length == 0 ? new int[1] : res;
    }
}
