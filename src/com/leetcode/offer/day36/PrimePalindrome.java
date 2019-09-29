package com.leetcode.offer.day36;

/**
 * @author duson
 * 求出大于或等于 N 的最小回文素数。
 * <p>
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 * <p>
 * 例如，2，3，5，7，11 以及 13 是素数。
 * <p>
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 * <p>
 * 例如，12321 是回文数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：6
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：8
 * 输出：11
 * 示例 3：
 * <p>
 * 输入：13
 * 输出：101
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^8
 * 答案肯定存在，且小于 2 * 10^8。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrimePalindrome {

    public int primePalindrome(int N) {
        while (true) {
            if (N == reverse(N) && isPrime(N)) {
                return N;
            }
            N++;
            if (10000000 < N && N < 100000000) {
                N = 100000000;
            }
        }
    }

    private boolean isPrime(int N) {
        if (N < 2) {
            return false;
        }
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d) {
            if (N % d == 0) {
                return false;
            }
        }
        return true;
    }

    public int reverse(int N) {
        int ans = 0;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        return ans;
    }

//    public int primePalindrome(int n) {
//        if (8 <= n && n <= 11) {
//            return 11;
//        }
//        for (int x = 1; x < 100000; x++) {
//            String s = Integer.toString(x), r = new StringBuilder(s).reverse().toString().substring(1);
//            int y = Integer.parseInt(s + r);
//            if (y >= n && isPrime(y)) {
//                return y;
//            }
//        }
//        return -1;
//    }
//
//    private boolean isPrime(int x) {
//        if (x < 2 || x % 2 == 0) {
//            return x == 2;
//        }
//        for (int i = 3; i * i <= x; i += 2) {
//            if (x % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
