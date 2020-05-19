package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * ?
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * ?
 * <p>
 * 提示：
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 * 通过次数9,073提交次数15,741
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructArr {

    public int[] constructArr(int[] a) {
        int n = a.length, tmp = 1;
        if (n == 0) {
            return new int[0];
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            tmp *= a[i - 1];
            res[i] = tmp;
        }
        tmp = 1;
        for (int i = n - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}
