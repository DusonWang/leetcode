package code.code;

/**
 * @author duson
 * 对于一个压缩字符串，设计一个数据结构，它支持如下两种操作： next 和 hasNext。
 * <p>
 * 给定的压缩字符串格式为：每个字母后面紧跟一个正整数，这个整数表示该字母在解压后的字符串里连续出现的次数。
 * <p>
 * next() - 如果压缩字符串仍然有字母未被解压，则返回下一个字母，否则返回一个空格。
 * hasNext() - 判断是否还有字母仍然没被解压。
 * <p>
 * 注意：
 * <p>
 * 请记得将你的类在 StringIterator 中 初始化 ，因为静态变量或类变量在多组测试数据中不会被自动清空。更多细节请访问 这里 。
 * <p>
 * 示例：
 * <p>
 * StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
 * <p>
 * iterator.next(); // 返回 'L'
 * iterator.next(); // 返回 'e'
 * iterator.next(); // 返回 'e'
 * iterator.next(); // 返回 't'
 * iterator.next(); // 返回 'C'
 * iterator.next(); // 返回 'o'
 * iterator.next(); // 返回 'd'
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 'e'
 * iterator.hasNext(); // 返回 false
 * iterator.next(); // 返回 ' '
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-compressed-string-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringIterator {

    private String res;
    private int ptr = 0, num = 0;
    private char ch = ' ';
    private final int len;

    public StringIterator(String s) {
        res = s;
        len = s.length();
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        if (num == 0) {
            ch = res.charAt(ptr++);
            while (ptr < len && res.charAt(ptr) >= '0' && res.charAt(ptr) <= '9'){
                num = num * 10 + res.charAt(ptr++) - '0';
            }
        }
        num--;
        return ch;
    }

    public boolean hasNext() {
        return ptr != len || num != 0;
    }

    public static void main(String[] args) {
        StringIterator stringIterator = new StringIterator("L1e2t1C1o1d1e1");
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.hasNext());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.hasNext());

    }
}
