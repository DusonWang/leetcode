package code.code;

/**
 * @author duson
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {

    private boolean prime(int m) {
        if (m <= 3) {
            return m > 1;
        }
        for (int i = 2, max = (int) Math.sqrt(m); i <= max; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (prime(i)) {
                count++;
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        final int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = 1;
        }
        for (int i = 2; i < n; i++) {
            if (nums[i] == 1) {
                for (int j = 2; i * j < n; j++) {
                    nums[i * j] = 0;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] == 1) {
                res++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(10));
    }
}
