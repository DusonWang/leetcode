package code.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author duson
 * 给定一个正整数数组 w ，其中 w[i] 代表位置 i 的权重，请写一个函数 pickIndex ，它可以随机地获取位置 i，选取位置 i 的概率与 w[i] 成正比。
 * <p>
 * 说明:
 * <p>
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex 将被调用不超过 10000 次
 * 示例1:
 * <p>
 * 输入:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * 输出: [null,0]
 * 示例2:
 * <p>
 * 输入:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * 输出: [null,0,1,1,1,0]
 * 输入语法说明：
 * <p>
 * 输入是两个列表：调用成员函数名和调用的参数。Solution 的构造函数有一个参数，即数组 w。pickIndex 没有参数。输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-with-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandomPick {

    private List<Integer> list;
    private Random random;
    private int total = 0;

    public RandomPick(int[] w) {
        random = new Random();
        list = new ArrayList<>();
        for (int ww : w) {
            total += ww;
            list.add(total);
        }
    }

    public int pickIndex() {
        int m = random.nextInt(total);
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int mid = (i + j) >> 1;
            if (m >= list.get(mid)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}
