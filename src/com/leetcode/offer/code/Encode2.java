package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个非负整数 num ，返回它的「加密字符串」。
 * <p>
 * 加密的过程是把一个整数用某个未知函数进行转化，你需要从下表推测出该转化函数：
 * <p>
 * <p>
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 23
 * 输出："1000"
 * 示例 2：
 * <p>
 * 输入：num = 107
 * 输出："101100"
 * ?
 * <p>
 * 提示：
 * <p>
 * 0 <= num <= 10^9
 * 通过次数1,032提交次数1,674
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/encode-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Encode2 {

    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}
