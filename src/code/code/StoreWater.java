package code.code;

/**
 * 给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
 * <p>
 * 升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
 * 蓄水：将全部水桶接满水，倒入各自对应的水缸
 * 每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 * <p>
 * 注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 * <p>
 * 示例 1：
 * <p>
 * 输入：bucket = [1,3], vat = [6,8]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * 第 1 次操作升级 bucket[0]；
 * 第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：bucket = [9,0,1], vat = [0,2,2]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * 第 1 次操作均选择升级 bucket[1]
 * 第 2~3 次操作选择蓄水，即可完成蓄水要求。
 * <p>
 * 提示：
 * <p>
 * 1 <= bucket.length == vat.length <= 100
 * 0 <= bucket[i], vat[i] <= 10^4
 * 通过次数2,563提交次数15,592
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/o8SXZn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StoreWater {

    public int storeWater(int[] bucket, int[] vat) {
        int max = 0;
        for (int v : vat) {
            if (max < v) {
                max = v;
            }
        }
        if (max == 0) {
            return 0;
        }
        int n = bucket.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 10000; i++) {
            int per = 0;
            int cur = i;
            for (int j = 0; j < n; j++) {
                per = (vat[j] + i - 1) / i;
                cur += Math.max(0, per - bucket[j]);
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
