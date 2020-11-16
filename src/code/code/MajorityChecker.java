package code.code;

/**
 * @author duson
 * 实现一个 MajorityChecker 的类，它应该具有下述几个 API：
 * <p>
 * MajorityChecker(int[] arr) 会用给定的数组 arr 来构造一个 MajorityChecker 的实例。
 * int query(int left, int right, int threshold) 有这么几个参数：
 * 0 <= left <= right < arr.length 表示数组 arr 的子数组的长度。
 * 2 * threshold > right - left + 1，也就是说阈值 threshold 始终比子序列长度的一半还要大。
 * 每次查询 query(...) 会返回在 arr[left], arr[left+1], ..., arr[right] 中至少出现阈值次数 threshold 的元素，如果不存在这样的元素，就返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * MajorityChecker majorityChecker = new MajorityChecker([1,1,2,2,1,1]);
 * majorityChecker.query(0,5,4); // 返回 1
 * majorityChecker.query(0,3,3); // 返回 -1
 * majorityChecker.query(2,3,2); // 返回 2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 20000
 * 1 <= arr[i] <= 20000
 * 对于每次查询，0 <= left <= right < len(arr)
 * 对于每次查询，2 * threshold > right - left + 1
 * 查询次数最多为 10000
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/online-majority-element-in-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityChecker {

    private int[] arr;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {
        int vote = -1;
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (cnt == 0) {
                vote = arr[i];
            }
            if (vote == arr[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        cnt = 0;
        for (int i = left; i <= right; i++) {
            if (arr[i] == vote) {
                cnt++;
            }
        }
        return cnt >= threshold ? vote : -1;
    }
}
