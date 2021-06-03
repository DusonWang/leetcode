package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个由不同正整数的组成的非空数组 A，考虑下面的图：
 * <p>
 * 有?A.length?个节点，按从?A[0]?到?A[A.length - 1]?标记；
 * 只有当 A[i] 和 A[j] 共用一个大于 1 的公因数时，A[i]?和 A[j] 之间才有一条边。
 * 返回图中最大连通组件的大小。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：[4,6,15,35]
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：[20,50,9,63]
 * 输出：2
 * <p>
 * 示例 3：
 * <p>
 * 输入：[2,3,6,7,4,12,21,39]
 * 输出：8
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 100000
 * 通过次数2,646提交次数7,712
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-component-size-by-common-factor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestComponentSize {

    public int largestComponentSize(int[] nums) {
        Map<Integer, Integer> parent = new HashMap<>();
        for (int num : nums) {
            for (int fact = 2; fact * fact <= num; fact++) {
                if (num % fact == 0) {
                    union(num, fact, parent);
                    union(num, num / fact, parent);
                }
            }
        }
        int max = 1;
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer v : nums) {
            int f = find(v, parent);
            if (freq.containsKey(f)) {
                freq.put(f, freq.get(f) + 1);
                max = Math.max(max, freq.get(f));
            } else {
                freq.put(f, 1);
            }
        }
        return max;
    }

    public void union(int n, int m, Map<Integer, Integer> p) {
        int findN = find(n, p);
        int findM = find(m, p);
        if (findN < findM) {
            p.put(findM, findN);
        } else {
            p.put(findN, findM);
        }
    }

    public int find(int i, Map<Integer, Integer> parent) {
        parent.putIfAbsent(i, i);
        while (i != parent.get(i)) {
            i = parent.get(i);
        }
        return i;
    }

    public static void main(String[] args) {
        LargestComponentSize largestComponentSize = new LargestComponentSize();
        System.out.println(largestComponentSize.largestComponentSize(new int[]{4, 6, 15, 35}));
    }
}
