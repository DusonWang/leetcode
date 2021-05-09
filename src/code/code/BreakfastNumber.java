package code.code;

import java.util.Arrays;

/**
 * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
 * <p>
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 * <p>
 * 示例 1：
 * <p>
 * 输入：staple = [10,20,5], drinks = [5,5,2], x = 15
 * <p>
 * 输出：6
 * <p>
 * 解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 * 第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
 * 第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
 * 第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
 * 第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
 * 第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
 * 第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
 * <p>
 * 示例 2：
 * <p>
 * 输入：staple = [2,1,1], drinks = [8,9,5,1], x = 9
 * <p>
 * 输出：8
 * <p>
 * 解释：小扣有 8 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 * 第 1 种方案：staple[0] + drinks[2] = 2 + 5 = 7；
 * 第 2 种方案：staple[0] + drinks[3] = 2 + 1 = 3；
 * 第 3 种方案：staple[1] + drinks[0] = 1 + 8 = 9；
 * 第 4 种方案：staple[1] + drinks[2] = 1 + 5 = 6；
 * 第 5 种方案：staple[1] + drinks[3] = 1 + 1 = 2；
 * 第 6 种方案：staple[2] + drinks[0] = 1 + 8 = 9；
 * 第 7 种方案：staple[2] + drinks[2] = 1 + 5 = 6；
 * 第 8 种方案：staple[2] + drinks[3] = 1 + 1 = 2；
 * <p>
 * 提示：
 * <p>
 * 1 <= staple.length <= 10^5
 * 1 <= drinks.length <= 10^5
 * 1 <= staple[i],drinks[i] <= 10^5
 * 1 <= x <= 2*10^5
 * 通过次数14,630提交次数52,851
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2vYnGI
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BreakfastNumber {

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int cnt = 0;
        int m = staple.length;
        int n = drinks.length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (staple[i] + drinks[j] <= x) {
                cnt = (cnt + j + 1) % 1000000007;
                i++;
            } else {
                j--;
            }
        }
        return cnt % 1000000007;
    }

    public int breakfastNumber2(int[] staple, int[] drinks, int x) {
        int result = 0;
        int[] arr = new int[x];
        for (int j : staple) {
            if (j < x) {
                arr[j]++;
            }
        }
        for (int i = 1; i < x; i++) {
            arr[i] += arr[i - 1];
        }
        for (int drink : drinks) {
            if (drink < x) {
                result += arr[x - drink];
                if (result >= 1000000007) {
                    result -= 1000000007;
                }
            }
        }
        return result;
    }


    /**
     * 小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
     * <p>
     * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,5,3,5], target = 6
     * <p>
     * 输出：1
     * <p>
     * 解释：预算内仅能购买 nums[0] 与 nums[2]。
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums = [2,2,1,9], target = 10
     * <p>
     * 输出：4
     * <p>
     * 解释：符合预算的采购方案如下：
     * nums[0] + nums[1] = 4
     * nums[0] + nums[2] = 3
     * nums[1] + nums[2] = 3
     * nums[2] + nums[3] = 10
     * <p>
     * 提示：
     * <p>
     * 2 <= nums.length <= 10^5
     * 1 <= nums[i], target <= 10^5
     * 通过次数6,108提交次数25,677
     * 请问您在哪类招聘中遇到此题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4xy4Wx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int purchasePlans(int[] nums, int target) {
        int mod = 1_000_000_007;
        int ans = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                ans += right - left;
                left++;
            }
            ans %= mod;
        }
        return ans % mod;
    }

    /**
     * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
     * <p>
     * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
     * <p>
     * ?
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 1
     * 输出：5
     * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
     * 示例 2：
     * <p>
     * 输入：n = 2
     * 输出：15
     * 解释：仅由元音组成的 15 个字典序字符串为
     * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
     * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
     * 示例 3：
     * <p>
     * 输入：n = 33
     * 输出：66045
     * ?
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 50?
     * 通过次数10,478提交次数13,624
     * 请问您在哪类招聘中遇到此题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        for (int cnt : dp) {
            res += cnt;
        }
        return res;
    }
}
