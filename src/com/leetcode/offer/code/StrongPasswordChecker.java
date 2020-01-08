package com.leetcode.offer.code;

/**
 * @author duson
 * 一个强密码应满足以下所有条件：
 * <p>
 * 由至少6个，至多20个字符组成。
 * 至少包含一个小写字母，一个大写字母，和一个数字。
 * 同一字符不能连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。
 * 编写函数 strongPasswordChecker(s)，s 代表输入字符串，如果 s 已经符合强密码条件，则返回0；否则返回要将 s 修改为满足强密码条件的字符串所需要进行修改的最小步数。
 * <p>
 * 插入、删除、替换任一字符都算作一次修改。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strong-password-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrongPasswordChecker {

    public int strongPasswordChecker(String s) {
        int res = 0, a = 1, aa = 1, d = 1;
        char[] carr = s.toCharArray();
        int[] arr = new int[carr.length];
        for (int i = 0; i < arr.length; ) {
            if (Character.isLowerCase(carr[i])) {
                a = 0;
            }
            if (Character.isUpperCase(carr[i])) {
                aa = 0;
            }
            if (Character.isDigit(carr[i])) {
                d = 0;
            }
            int j = i;
            while (i < carr.length && carr[i] == carr[j]) {
                i++;
            }
            arr[j] = i - j;
        }
        int totalMissing = (a + aa + d);
        if (arr.length < 6) {
            res += totalMissing + Math.max(0, 6 - (arr.length + totalMissing));
        } else {
            int overLen = Math.max(arr.length - 20, 0), leftOver = 0;
            res += overLen;
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < arr.length && overLen > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != (k - 1)) {
                        continue;
                    }
                    arr[i] -= Math.min(overLen, k);
                    overLen -= k;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 3 && overLen > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= overLen;
                    overLen -= need;
                }
                if (arr[i] >= 3) {
                    leftOver += arr[i] / 3;
                }
            }
            res += Math.max(totalMissing, leftOver);
        }
        return res;
    }
}
