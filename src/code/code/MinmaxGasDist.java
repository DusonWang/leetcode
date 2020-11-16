package code.code;

/**
 * @author duson
 * 假设我们在一条水平数轴上，列表 stations?来表示各个加油站的位置，加油站分别在?stations[0], stations[1], ..., stations[N-1]?的位置上，其中 N = stations.length。
 * <p>
 * 现在我们希望增加 K 个新的加油站，使得相邻两个加油站的距离 D 尽可能的最小，请你返回?D 可能的最小值。
 * <p>
 * 示例：
 * <p>
 * 输入：stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
 * 输出：0.500000
 * 注：
 * <p>
 * stations.length?是在范围?[10, 2000]?内的整数
 * stations[i] 是在范围?[0, 10^8]?内的整数
 * K 是在范围?[1, 10^6]?内的整数
 * 在?10^-6?以内的正确值会被视为正确的答案
 * 通过次数412提交次数738
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimize-max-distance-to-gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinmaxGasDist {

    public double minmaxGasDist(int[] stations, int k) {
        double lo = 0, hi = 1e8;
        while (hi - lo > 1e-6) {
            double mi = (lo + hi) / 2.0;
            if (possible(mi, stations, k)) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
        return lo;
    }

    private boolean possible(double d, int[] stations, int k) {
        int used = 0;
        for (int i = 0; i < stations.length - 1; ++i) {
            used += (int) ((stations[i + 1] - stations[i]) / d);
        }
        return used <= k;
    }
}
