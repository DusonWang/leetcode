package code.code;

/**
 * @author duson
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * <p>
 * 请你找到并返回这个整数
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSpecialInteger {

    public int findSpecialInteger(int[] arr) {
        int len = arr.length, cnt = len / 4, i = 0;
        len -= cnt;
        while (i < len) {
            if (arr[i] == arr[i + cnt]) {
                return arr[i];
            }
            ++i;
            while (arr[i] == arr[i - 1]) {
                ++i;
            }
        }
        return arr[0];
    }
}
