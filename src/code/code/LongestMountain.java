package code.code;

/**
 * @author duson
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 * <p>
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestMountain {

    public int longestMountain(int[] a) {
        if (a == null || a.length < 3) {
            return 0;
        }
        int lg = 0;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
                int l = i - 1;
                int r = i + 1;
                while (l > 0 && a[l - 1] < a[l]) {
                    l--;
                }
                while (r < a.length - 1 && a[r] > a[r + 1]) {
                    r++;
                }
                lg = Math.max(lg, r - l + 1);
            }
        }
        return lg;
    }
}
