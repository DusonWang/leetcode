package code.code;

/**
 * @author duson
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/duplicate-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i == 0) {
                count++;
            }
        }
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            int temp = i + count;
            if (temp < len) {
                arr[temp] = arr[i];
            }
            if (arr[i] == 0) {
                count--;
                temp = i + count;
                if (temp < len) {
                    arr[temp] = arr[i];
                }
            }
        }
    }
}
