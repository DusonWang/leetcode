package code.code;

/**
 * @author duson
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * <p>
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * <p>
 * 示例:
 * <p>
 * 输入: 4, 14, 2
 * <p>
 * 输出: 6
 * <p>
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 注意:
 * <p>
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/total-hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TotalHammingDistance {

    public int hammingDistance(int x, int y) {
        int m = x ^ y;
        int count = 0;
        while (m != 0) {
            count++;
            m = m & (m - 1);
        }
        return count;
    }

    public int totalHammingDistance2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int total = 0;
        for (int i = 0; i < 31; i++) {
            int bitCount = 0;
            for (int num : nums) {
                bitCount += (num >> i) & 1;
            }

            total += bitCount * (len - bitCount);
        }

        return total;
    }

    public int totalHammingDistance(int[] nums) {
        final int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                sum += hammingDistance(nums[i], nums[j]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TotalHammingDistance totalHammingDistance = new TotalHammingDistance();
        System.out.println(totalHammingDistance.totalHammingDistance(new int[]{4, 14, 2}));
    }
}
