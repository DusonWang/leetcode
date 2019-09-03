package com.leetcode.offer.day27;

/**
 * @author duson
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * <p>
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * <p>
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * <p>
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 * <p>
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * 进阶:
 * 你如何处理一个溢出的过大的整数输入?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAdditiveNumber {

    public boolean isAdditiveNumber(String s) {
        return isAdditiveNumber(s, 0, 0L, 0L, 0);
    }

    private boolean isAdditiveNumber(String s, int index, long n1, long n2, int c) {
        if (c > 2 && index == s.length()) {
            return true;
        }
        long num = 0;
        while (index < s.length()) {
            int ch = s.charAt(index++) - '0';
            num = num * 10 + ch;
            while (num != 0 && ch == 0 && index < s.length() && s.charAt(index) == '0') {
                num = num * 10 + s.charAt(index++) - '0';
            }
            if (n1 + n2 < num && c >= 2) {
                break;
            }
            if ((n1 + n2 == num || c < 2) && isAdditiveNumber(s, index, n2, num, c + 1)) {
                return true;
            }
            if (num == 0) {
                break;
            }
        }
        return false;
    }
//    public boolean isAdditiveNumber(String num) {
//        if (num == null || num.length() == 0) {
//            return false;
//        }
//        final int len = num.length();
//
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                String a1 = num.substring(0, i + 1);
//                String a2 = num.substring(i + 1, j + 1);
//                String left = num.substring(j + 1);
//                if (a1.length() > 1 && a1.charAt(0) == '0'
//                        || a2.length() > 1 && a2.charAt(0) == '0'
//                        || left.length() > 1 && left.charAt(0) == '0') {
//                    continue;
//                }
//                String addResult = add(a1, a2);
//                if (left.equals(addResult) || (left.startsWith(addResult) && isAdditiveNumber(a2 + left))) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private String add(String a1, String a2) {
//        String r = "";
//        int i = a1.length() - 1;
//        int j = a2.length() - 1;
//        int carry = 0;
//        while(i >= 0 || j >= 0) {
//            int t = (i >= 0 ? (a1.charAt(i--) - '0') : 0) + (j >= 0 ? (a2.charAt(j--) - '0') : 0) + carry;
//            r = (t % 10) + r;
//            carry = t / 10;
//        }
//        if(carry > 0) {
//            r = carry + r;
//        }
//        return r;
//    }
}
