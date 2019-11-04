package com.leetcode.offer.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumberIII {

    public int[] singleNumber2(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for (int n : nums) {
            xor = xor ^ n;
        }
        int mask = xor & (-xor);
        for (int n : nums) {
            if ((n & mask) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, 2);
            }
        }
        int[] result = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result[i++] = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumberIII singleNumberIII = new SingleNumberIII();
        System.out.println(Arrays.toString(singleNumberIII.singleNumber2(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
