package code.code;

/**
 * @author duson
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * <p>
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * 示例2:
 * <p>
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * 输出：4
 * 提示:
 * <p>
 * words的长度在[1, 1000000]之间
 * 通过次数2,435提交次数4,128
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindString {

    public int findString(String[] words, String s) {
        if (words == null || words.length == 0) {
            return -1;
        }
        int left = 0, right = words.length - 1;
        while (left <= right) {
            while (left <= right && words[left].length() == 0) {
                left++;
            }
            while (left <= right && words[right].length() == 0) {
                right--;
            }
            int mid = left + (right - left) / 2;
            while (mid < right && words[mid].length() == 0) {
                mid++;
            }
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
