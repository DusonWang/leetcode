package code.code;

/**
 * @author duson
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 * <p>
 * 不要使用系统的 Math.random() 方法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [7]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [8,4]
 * 示例 3:
 * <p>
 * 输入: 3
 * 输出: [8,1,10]
 *  
 * <p>
 * 提示:
 * <p>
 * rand7 已定义。
 * 传入参数: n 表示 rand10 的调用次数。
 *  
 * <p>
 * 进阶:
 * <p>
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rand10 {

    //[1-7]
    public int rand7() {
        return 0;
    }

    public int rand10() {
        while (true) {
            int a = rand7();
            int b = rand7();
            a = (a - 1) * 7 + b;
            if (a <= 40) {
                return a % 10 + 1;
            }
        }
    }
}
