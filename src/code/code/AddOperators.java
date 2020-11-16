package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"]
 * 示例 2:
 * <p>
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 * 示例 3:
 * <p>
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]
 * 示例 4:
 * <p>
 * 输入: num = "00", target = 0
 * 输出: ["0+0", "0-0", "0*0"]
 * 示例 5:
 * <p>
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/expression-add-operators
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        int n = num.length();
        char[] arr = num.toCharArray();
        char[] path = new char[2 * n - 1];
        long a = 0;
        for (int i = 0; i < n; i++) {
            a = 10 * a + arr[i] - '0';
            path[i] = arr[i];
            search(arr, i + 1, path, i + 1, 0, a, target, res);
            if (a == 0) {
                break;
            }
        }
        return res;
    }

    private void search(char[] num, int index, char[] arr, int end, long pre, long cur, int target, List<String> res) {
        if (index == num.length) {
            if (pre + cur == target) {
                res.add(new String(arr, 0, end));
                return;
            }
        }
        int j = end + 1;
        int val = 0;
        for (int i = index; i < num.length; i++) {
            val = val * 10 + num[i] - '0';
            arr[j++] = num[i];
            arr[end] = '+';
            search(num, i + 1, arr, j, pre + cur, val, target, res);
            arr[end] = '-';
            search(num, i + 1, arr, j, pre + cur, -val, target, res);
            arr[end] = '*';
            search(num, i + 1, arr, j, pre, cur * val, target, res);
            if (val == 0) {
                break;
            }
        }
    }
}
