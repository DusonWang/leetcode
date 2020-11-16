package code.code;

/**
 * @author duson
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * <p>
 * -1 : 我的数字比较小
 * 1 : 我的数字比较大
 * 0 : 恭喜！你猜对了！
 * 示例 :
 * <p>
 * 输入: n = 10, pick = 6
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GuessNumber {

    private int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        int mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            int val = guess(mid);
            if (val > 0) {
                l = mid + 1;
            } else if (val < 0) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return 0;
    }

    public int guessNumber2(int n) {
        for (int i = 1; i <= n; i++) {
            if (guess(i) == 0) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int i = 1;
        int j = 10;
        int m = i + (j - i) / 2;
        int k = i + (j - i) >> 1;
        int e = i + ((j - i) >> 1);

        System.out.println("[m=]" + m + "[k=]" + k + "[e=]" + e);
    }
}
