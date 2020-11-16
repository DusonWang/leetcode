package code.code;

/**
 * @author duson
 * 输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的数组长度范围为 [1, 10000]
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPossible {

    public boolean isPossible(int[] nums) {
        int pre = Integer.MIN_VALUE;
        int p1 = 0, p2 = 0, p3 = 0;
        int curr;
        int cnt;
        int c1, c2, c3;
        for (int i = 0; i < nums.length; pre = curr, p1 = c1, p2 = c2, p3 = c3) {
            for (curr = nums[i], cnt = 0; i < nums.length && curr == nums[i]; i++) {
                cnt++;
            }
            if (curr != pre + 1) {
                if (p1 != 0 || p2 != 0) {
                    return false;
                }
                c1 = cnt;
                c2 = 0;
                c3 = 0;
            } else {
                if (cnt < p1 + p2) {
                    return false;
                }
                c1 = Math.max(0, cnt - (p1 + p2 + p3));
                c2 = p1;
                c3 = p2 + Math.min(p3, cnt - (p1 + p2));
            }
        }
        return (p1 == 0 && p2 == 0);
    }
}
