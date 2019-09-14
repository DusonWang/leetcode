package com.leetcode.offer.day30;

/**
 * @author duson
 * 给你一个文件，并且该文件只能通过给定的 read4 方法来读取，请实现一个方法使其能够读取 n 个字符。
 * <p>
 * read4 方法：
 * <p>
 * API read4 可以从文件中读取 4 个连续的字符，并且将它们写入缓存数组 buf 中。
 * <p>
 * 返回值为实际读取的字符个数。
 * <p>
 * 注意 read4() 自身拥有文件指针，很类似于 C 语言中的 FILE *fp 。
 * <p>
 * read4 的定义：
 * <p>
 * 参数类型: char[] buf
 * 返回类型: int
 * <p>
 * 注意: buf[] 是目标缓存区不是源缓存区，read4 的返回结果将会复制到 buf[] 当中。
 * 下列是一些使用 read4 的例子：
 * <p>
 * File file("abcdefghijk"); // 文件名为 "abcdefghijk"， 初始文件指针 (fp) 指向 'a'
 * char[] buf = new char[4]; // 创建一个缓存区使其能容纳足够的字符
 * read4(buf); // read4 返回 4。现在 buf = "abcd"，fp 指向 'e'
 * read4(buf); // read4 返回 4。现在 buf = "efgh"，fp 指向 'i'
 * read4(buf); // read4 返回 3。现在 buf = "ijk"，fp 指向文件末尾
 * read 方法：
 * <p>
 * 通过使用 read4 方法，实现 read 方法。该方法可以从文件中读取 n 个字符并将其存储到缓存数组 buf 中。您 不能 直接操作文件。
 * <p>
 * 返回值为实际读取的字符。
 * <p>
 * read 的定义：
 * <p>
 * 参数类型:   char[] buf, int n
 * 返回类型:   int
 * <p>
 * 注意: buf[] 是目标缓存区不是源缓存区，你需要将结果写入 buf[] 中。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： file = "abc", n = 4
 * 输出： 3
 * 解释： 当执行你的 rand 方法后，buf 需要包含 "abc"。 文件一共 3 个字符，因此返回 3。 注意 "abc" 是文件的内容，不是 buf 的内容，buf 是你需要写入结果的目标缓存区。
 * 示例 2：
 * <p>
 * 输入： file = "abcde", n = 5
 * 输出： 5
 * 解释： 当执行你的 rand 方法后，buf 需要包含 "abcde"。文件共 5 个字符，因此返回 5。
 * 示例 3:
 * <p>
 * 输入： file = "abcdABCD1234", n = 12
 * 输出： 12
 * 解释： 当执行你的 rand 方法后，buf 需要包含 "abcdABCD1234"。文件一共 12 个字符，因此返回 12。
 * 示例 4:
 * <p>
 * 输入： file = "leetcode", n = 5
 * 输出： 5
 * 解释： 当执行你的 rand 方法后，buf 需要包含 "leetc"。文件中一共 5 个字符，因此返回 5。
 *  
 * <p>
 * 注意：
 * <p>
 * 你 不能 直接操作该文件，文件只能通过 read4 获取而 不能 通过 read。
 * read  函数只在每个测试用例调用一次。
 * 你可以假定目标缓存数组 buf 保证有足够的空间存下 n 个字符。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/read-n-characters-given-read4
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int read4(char[] buf) {
        return 0;
    }

    public int read(char[] buf, int n) {
        int count;
        char[] temp = new char[4];
        int index = 0;
        int ret = 0;
        while (index < n) {
            count = read4(temp);
            if (count >= 0) {
                System.arraycopy(temp, 0, buf, index, count);
            }
            ret += count;
            index += 4;
        }
        return Math.min(ret, n);
    }
}
