package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * ?
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例?2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * ?
 * <p>
 * 提示:
 * <p>
 * 0 < nums.length <= 100
 * 说明:
 * <p>
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * 通过次数11,200提交次数20,110
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinNumber {

    public String minNumber(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }
}
