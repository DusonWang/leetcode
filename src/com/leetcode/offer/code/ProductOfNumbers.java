package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
 * <p>
 * 1. add(int num)
 * <p>
 * 将数字 num 添加到当前数字列表的最后面。
 * 2. getProduct(int k)
 * <p>
 * 返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
 * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
 * <p>
 * 输出：
 * [null,null,null,null,null,null,20,40,0,null,32]
 * <p>
 * 解释：
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);        // [3]
 * productOfNumbers.add(0);        // [3,0]
 * productOfNumbers.add(2);        // [3,0,2]
 * productOfNumbers.add(5);        // [3,0,2,5]
 * productOfNumbers.add(4);        // [3,0,2,5,4]
 * productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
 * productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
 * productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
 * productOfNumbers.add(8);        // [3,0,2,5,4,8]
 * productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
 *  
 * <p>
 * 提示：
 * <p>
 * add 和 getProduct 两种操作加起来总共不会超过 40000 次。
 * 0 <= num <= 100
 * 1 <= k <= 40000
 * 通过次数2,538提交次数6,233
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-the-last-k-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProductOfNumbers {

    private List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            products = new ArrayList<>();
            products.add(1);
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (products.size() <= k) {
            return 0;
        }
        return products.get(products.size() - 1) / products.get(products.size() - 1 - k);
    }
}
