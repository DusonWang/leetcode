package code.code;

/**
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 * <p>
 * 请你按下述方式重新格式化电话号码。
 * <p>
 * 首先，删除 所有的空格和破折号。
 * 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 * <p>
 * 返回格式化后的电话号码。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：number = "1-23-45 6"
 * 输出："123-456"
 * 解释：数字是 "123456"
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 3 个数字，将它们放入单个含 3 个数字的块。第 2 个块是 "456" 。
 * 连接这些块后得到 "123-456" 。
 * 示例 2：
 * <p>
 * 输入：number = "123 4-567"
 * 输出："123-45-67"
 * 解释：数字是 "1234567".
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 4 个数字，所以将它们分成两个含 2 个数字的块。这 2 块分别是 "45" 和 "67" 。
 * 连接这些块后得到 "123-45-67" 。
 * 示例 3：
 * <p>
 * 输入：number = "123 4-5678"
 * 输出："123-456-78"
 * 解释：数字是 "12345678" 。
 * 步骤 1：第 1 个块 "123" 。
 * 步骤 2：第 2 个块 "456" 。
 * 步骤 3：剩下 2 个数字，将它们放入单个含 2 个数字的块。第 3 个块是 "78" 。
 * 连接这些块后得到 "123-456-78" 。
 * 示例 4：
 * <p>
 * 输入：number = "12"
 * 输出："12"
 * 示例 5：
 * <p>
 * 输入：number = "--17-5 229 35-39475 "
 * 输出："175-229-353-94-75"
 * ?
 * <p>
 * 提示：
 * <p>
 * 2 <= number.length <= 100
 * number 由数字和字符 '-' 及 ' ' 组成。
 * number 中至少含 2 个数字。
 * 通过次数6,275提交次数9,832
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reformat-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReformatNumber {

    public String reformatNumber(String number) {
        number = number.replace(" ", "").replace("-", "");
        int length = number.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ) {
            int resrved = length - i;
            if (resrved > 4) {
                sb.append(number, i, i + 3);
                sb.append('-');
                i += 3;
            } else if (resrved == 3 || resrved == 2) {
                sb.append(number.substring(i));
                break;
            } else if (resrved == 4) {
                sb.append(number, i, i + 2);
                sb.append('-');
                sb.append(number, i + 2, i + 4);
                break;
            }
        }
        return sb.toString();

    }
}
