package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * <p>
 * 例如，
 * <p>
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * <p>
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> out = new ArrayList<>();
        if (n <= 0) {
            return out;
        }
        for (int i = 1; i < 10; i++) {
            dfs(out, i, n);
        }
        return out;
    }

    private void dfs(List<Integer> out, int start, int n) {
        if (start > n) {
            return;
        }
        out.add(start);
        for (int i = 0; i < 10; i++) {
            dfs(out, start * 10 + i, n);
        }
    }
}
