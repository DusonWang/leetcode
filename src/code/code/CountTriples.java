package code.code;

/**
 * 一个 平方和三元组(a,b,c)指的是满足 a2 + b2 = c2的 整数三元组a，b和c。
 * <p>
 * 给你一个整数n，请你返回满足1 <= a, b, c <= n的 平方和三元组 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：2
 * 解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
 * 示例 2：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 250
 * 通过次数2,228提交次数3,312
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-square-sum-triples
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountTriples {

    public int countTriples(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (i * i + j * j == k * k) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}
