package com.leetcode.offer.day32;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 设计一个电话目录管理系统，让它支持以下功能：
 * <p>
 * get: 分配给用户一个未被使用的电话号码，获取失败请返回 -1
 * check: 检查指定的电话号码是否被使用
 * release: 释放掉一个电话号码，使其能够重新被分配
 * 示例:
 * <p>
 * // 初始化电话目录，包括 3 个电话号码：0，1 和 2。
 * PhoneDirectory directory = new PhoneDirectory(3);
 * <p>
 * // 可以返回任意未分配的号码，这里我们假设它返回 0。
 * directory.get();
 * <p>
 * // 假设，函数返回 1。
 * directory.get();
 * <p>
 * // 号码 2 未分配，所以返回为 true。
 * directory.check(2);
 * <p>
 * // 返回 2，分配后，只剩一个号码未被分配。
 * directory.get();
 * <p>
 * // 此时，号码 2 已经被分配，所以返回 false。
 * directory.check(2);
 * <p>
 * // 释放号码 2，将该号码变回未分配状态。
 * directory.release(2);
 * <p>
 * // 号码 2 现在是未分配状态，所以返回 true。
 * directory.check(2);
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-phone-directory
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PhoneDirectory {

    private List<Integer> used;

    private List<Integer> empty;

    private int max;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public PhoneDirectory(int maxNumbers) {
        empty = new ArrayList<>(maxNumbers);
        used = new ArrayList<>(maxNumbers);
        max = maxNumbers;
        for (int i = 0; i < maxNumbers; i++) {
            empty.add(i);
        }
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        int size = empty.size();
        if (size == 0) {
            return -1;
        }
        int index = (int) (Math.random() * size);
        int value = empty.get(index);
        used.add(value);
        empty.remove(index);
        return value;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        if (number < 0 || number > max) {
            return false;
        }
        return empty.indexOf(number) > -1;
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        int index = used.indexOf(number);
        if (index == -1) {
            return;
        }
        used.remove(index);
        empty.add(number);
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory(3);
        //["PhoneDirectory","get","get","check","get","check","release","check"]
        //[[3],[],[],[2],[],[2],[2],[2]]
        System.out.println(phoneDirectory.get());
        System.out.println(phoneDirectory.get());
        System.out.println(phoneDirectory.check(2));
        System.out.println(phoneDirectory.get());
        System.out.println(phoneDirectory.check(2));
        phoneDirectory.release(2);
        System.out.println(phoneDirectory.check(2));

    }
}
