package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author duson
 * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 * 示例 2：
 * <p>
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length?<= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k?<= arr.length
 * 通过次数3,321提交次数6,508
 * 在真实的面试中遇到过这道题？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/least-number-of-unique-integers-after-k-removals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLeastNumOfUniqueInts {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        int repeat = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(repeat);
                repeat = 1;
            } else {
                repeat++;
            }
        }
        list.add(repeat);
        Collections.sort(list);
        int count = list.size();
        for (int i = 0; i < list.size() && k > 0; i++) {
            if (list.get(i) > k) {
                break;
            }
            count--;
            k = k - list.get(i);
        }
        return count;
    }
}
