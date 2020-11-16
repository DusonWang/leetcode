package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 * <p>
 * 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,4,1]
 * 输出：[4,2,4,3]
 * 解释：
 * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 * 初始状态 A = [3, 2, 4, 1]
 * 第一次翻转后 (k=4): A = [1, 4, 2, 3]
 * 第二次翻转后 (k=2): A = [4, 1, 2, 3]
 * 第三次翻转后 (k=4): A = [3, 2, 1, 4]
 * 第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：[]
 * 解释：
 * 输入已经排序，因此不需要翻转任何内容。
 * 请注意，其他可能的答案，如[3，3]，也将被接受。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * A[i] 是 [1, 2, ..., A.length] 的排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pancake-sorting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PancakeSort {

    public List<Integer> pancakeSort(int[] a) {
        List<Integer> res = new ArrayList<>();
        for (int x = a.length, i; x > 0; --x) {
            for (i = 0; a[i] != x; ++i) {
                ;
            }
            reverse(a, i + 1);
            res.add(i + 1);
            reverse(a, x);
            res.add(x);
        }
        return res;
    }

    public void reverse(int[] a, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        PancakeSort pancakeSort = new PancakeSort();
        int []a = new int[]{3, 2, 4, 1};
        System.out.println(pancakeSort.pancakeSort(a));

        System.out.println(Arrays.toString(a));
    }
}
