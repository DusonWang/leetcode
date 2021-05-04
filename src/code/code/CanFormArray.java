package code.code;

/**
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * <p>
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [85], pieces = [[85]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 3：
 * <p>
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * 示例 4：
 * <p>
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 * 示例 5：
 * <p>
 * 输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
 * 输出：false
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 * 通过次数11,121提交次数16,425
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-array-formation-through-concatenation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanFormArray {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] hash = new int[101];
        for (int i = 0; i < pieces.length; i++) {
            hash[pieces[i][0]] = i + 1;
        }
        for (int i = 0; i < arr.length; ) {
            if (hash[arr[i]] > 0) {
                int idx = hash[arr[i]] - 1;
                for (int j = 0; j < pieces[idx].length; j++) {
                    if (arr[i++] != pieces[idx][j]) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
