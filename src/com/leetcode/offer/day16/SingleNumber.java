package com.leetcode.offer.day16;

/**
 * @author duson
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {

    public int singleNumber2(int[] nums) {
        int x = 0;
        int y = 0;
        for (int num : nums) {
            x = (x ^ num) & ~y;
            y = (y ^ num) & ~x;
        }
        return x;
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        int[] counts = new int[32];
        for (int num : nums) {
            int i = 1;
            int j = 31;
            while (j >= 0) {
                if ((num & i) != 0) {
                    counts[j]++;
                }
                j--;
                i = i << 1;
            }
        }
        int i = 1;
        int j = 31;
        while (j >= 0) {
            if (counts[j] % 3 != 0) {
                ans = ans ^ i;
            }
            i = i << 1;
            j--;
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        //System.out.println(singleNumber.singleNumber2(new int[]{2, 2, 3, 2}));
        System.out.println(singleNumber.singleNumber2(new int[]{0, 1, 0, 1, 0, 1, 99}));

    }
}
