package code.code;

/**
 * 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 * <p>
 * 返回使字符串任意相邻两个字母不相同的最小删除成本。
 * <p>
 * 请注意，删除一个字符后，删除其他字符的成本不会改变。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abaac", cost = [1,2,3,4,5]
 * 输出：3
 * 解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
 * 示例 2：
 * <p>
 * 输入：s = "abc", cost = [1,2,3]
 * 输出：0
 * 解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
 * 示例 3：
 * <p>
 * 输入：s = "aabaa", cost = [1,2,3,4,1]
 * 输出：2
 * 解释：删除第一个和最后一个字母，得到字符串 ("aba") 。
 * ?
 * <p>
 * 提示：
 * <p>
 * s.length == cost.length
 * 1 <= s.length, cost.length <= 10^5
 * 1 <= cost[i] <=?10^4
 * s 中只含有小写英文字母
 * 通过次数9,802提交次数17,006
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCost4 {

    public int minCost(String s, int[] cost) {
        char[] arr = s.toCharArray();
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                if (cost[i] > cost[i - 1]) {
                    min += cost[i - 1];
                } else {
                    min += cost[i];
                    cost[i] = cost[i - 1];
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinCost4 minCost4 = new MinCost4();
        System.out.println(minCost4.minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(minCost4.minCost("abc", new int[]{1, 2, 3}));
        System.out.println(minCost4.minCost("aabaa", new int[]{1, 2, 3, 4, 1}));


    }
}
