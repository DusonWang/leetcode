package code.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 解释:
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 给定矩阵中的元素总数不会超过 100000 。
 * 在真实的面试中遇到过这道题？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int r = 0;
        int c = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return arr;
    }

    private final Map<Integer, List<Integer>> m = new HashMap<>();

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int size = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                m.putIfAbsent(i + j, new ArrayList<>());
                m.get(i + j).add(nums.get(i).get(j));
                size++;
            }
        }
        int[] results = new int[size];
        int index = 0;
        for (int i = 0; i < m.size(); i++) {
            for (int j = m.get(i).size() - 1; j >= 0; j--) {
                results[index] = m.get(i).get(j);
                index++;
            }
        }
        return results;
    }
}
