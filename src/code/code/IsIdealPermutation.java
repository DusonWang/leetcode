package code.code;

/**
 * @author duson
 * 数组 A 是 [0, 1, ..., N - 1] 的一种排列，N 是数组 A 的长度。全局倒置指的是 i,j 满足 0 <= i < j < N 并且 A[i] > A[j] ，局部倒置指的是 i 满足 0 <= i < N 并且 A[i] > A[i+1] 。
 * <p>
 * 当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: A = [1,0,2]
 * 输出: true
 * 解释: 有 1 个全局倒置，和 1 个局部倒置。
 * 示例 2:
 * <p>
 * 输入: A = [1,2,0]
 * 输出: false
 * 解释: 有 2 个全局倒置，和 1 个局部倒置。
 * 注意:
 * <p>
 * A 是 [0, 1, ..., A.length - 1] 的一种排列
 * A 的长度在 [1, 5000]之间
 * 这个问题的时间限制已经减少了。
 * 通过次数1,869提交次数4,454
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/global-and-local-inversions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsIdealPermutation {

    public boolean isIdealPermutation(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            if (Math.abs(a[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}
