package code.code;

/**
 * @author duson
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * 通过次数13,889提交次数25,033
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge0 {

    public void merge(int[] a, int m, int[] b, int n) {
        int k = m - 1, j = n - 1, i = a.length - 1;
        while (k >= 0 && j >= 0) {
            a[i--] = a[k] > b[j] ? a[k--] : b[j--];
        }
        while (j >= 0) {
            a[i--] = b[j--];
        }
    }

}
