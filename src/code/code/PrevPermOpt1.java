package code.code;

/**
 * @author duson
 * 给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。
 * <p>
 * 如果无法这么操作，就请返回原数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,1]
 * 输出：[3,1,2]
 * 解释：
 * 交换 2 和 1
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：[1,1,5]
 * 输出：[1,1,5]
 * 解释：
 * 这已经是最小排列
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入：[1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：
 * 交换 9 和 7
 *  
 * <p>
 * 示例 4：
 * <p>
 * 输入：[3,1,1,3]
 * 输出：[1,3,1,3]
 * 解释：
 * 交换 1 和 3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= A[i] <= 10000
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/previous-permutation-with-one-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrevPermOpt1 {

    public int[] prevPermOpt1(int[] a) {
        int n = a.length, left = n - 2, right = n - 1;
        while (left >= 0 && a[left] <= a[left + 1]) {
            left--;
        }
        if (left < 0) {
            return a;
        }
        while (a[left] <= a[right]) {
            right--;
        }
        while (a[right - 1] == a[right]) {
            right--;
        }
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
        return a;
    }
}
