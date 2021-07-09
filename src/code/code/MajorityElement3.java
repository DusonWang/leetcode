package code.code;

/**
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 通过次数49,372提交次数88,362
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement3 {

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        int len = nums.length;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        int k = 0;
        for (int num : nums) {
            if (num == candidate) {
                k++;
            }
        }
        return k > len / 2 ? candidate : -1;
    }

    public static void main(String[] args) {
        MajorityElement3 majorityElement3 = new MajorityElement3();
        System.out.println(majorityElement3.majorityElement(new int[]{1, 2, 3}));
        System.out.println(majorityElement3.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
        System.out.println(majorityElement3.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));

    }
}
