package code.code;

import java.util.Arrays;

/**
 * @author duson
 * <p>
 * 三枚石子放置在数轴上，位置分别为 a，b，c。
 * <p>
 * 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 * <p>
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * <p>
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 2, c = 5
 * 输出：[1, 2]
 * 解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 3, c = 2
 * 输出：[0, 0]
 * 解释：我们无法进行任何移动。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= a <= 100
 * 1 <= b <= 100
 * 1 <= c <= 100
 * a != b, b != c, c != a
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/moving-stones-until-consecutive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumMovesStones {

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        int first = arr[0], second = arr[1], third = arr[2];
        if (third - first == 2) {
            return new int[]{0, 0};
        }
        int minMove = Math.min(second - first, third - second) <= 2 ? 1 : 2;
        int maxMove = third - first - 2;
        return new int[]{minMove, maxMove};
    }

    //在一个长度无限的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作端点石子。
    //
    //每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。
    //
    //值得注意的是，如果石子像 stones = [1,2,5] 这样，你将无法移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。
    //
    //当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
    //
    //要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves] 。
    //
    // 
    //
    //示例 1：
    //
    //输入：[7,4,9]
    //输出：[1,2]
    //解释：
    //我们可以移动一次，4 -> 8，游戏结束。
    //或者，我们可以移动两次 9 -> 5，4 -> 6，游戏结束。
    //示例 2：
    //
    //输入：[6,5,4,3,10]
    //输出：[2,3]
    //解释：
    //我们可以移动 3 -> 8，接着是 10 -> 7，游戏结束。
    //或者，我们可以移动 3 -> 7, 4 -> 8, 5 -> 9，游戏结束。
    //注意，我们无法进行 10 -> 2 这样的移动来结束游戏，因为这是不合要求的移动。
    //示例 3：
    //
    //输入：[100,101,104,102,103]
    //输出：[0,0]
    // 
    //
    //提示：
    //
    //3 <= stones.length <= 10^4
    //1 <= stones[i] <= 10^9
    //stones[i] 的值各不相同。
    // 
    //
    //通过次数1,353提交次数2,857
    //在真实的面试中遇到过这道题？
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/moving-stones-until-consecutive-ii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int[] numMovesStonesII(int[] a) {
        Arrays.sort(a);
        int i = 0, n = a.length, low = n;
        int high = Math.max(a[n - 1] - n + 2 - a[1], a[n - 2] - a[0] - n + 2);
        for (int j = 0; j < n; ++j) {
            while (a[j] - a[i] >= n) {
                ++i;
            }
            if (j - i + 1 == n - 1 && a[j] - a[i] == n - 2) {
                low = Math.min(low, 2);
            } else {
                low = Math.min(low, n - (j - i + 1));
            }
        }
        return new int[]{low, high};
    }
}
