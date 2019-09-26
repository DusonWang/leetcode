package com.leetcode.offer.day34;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 你的任务是实现 Excel 的求和功能，具体的操作如下：
 * <p>
 * Excel(int H, char W): 这是一个构造函数，输入表明了 Excel 的高度和宽度。H 是一个正整数，范围从 1 到 26，代表高度。W 是一个字符，范围从 'A' 到 'Z'，宽度等于从 'A' 到 W 的字母个数。Excel 表格是一个高度 * 宽度的二维整数数组，数组中元素初始化为 0。第一行下标从 1 开始，第一列下标从 'A' 开始。
 * <p>
 *  
 * <p>
 * void Set(int row, char column, int val): 设置 C(row, column) 中的值为 val。
 * <p>
 *  
 * <p>
 * int Get(int row, char column): 返回 C(row, column) 中的值。
 * <p>
 *  
 * <p>
 * int Sum(int row, char column, List of Strings : numbers): 这个函数会将计算的结果放入 C(row, column) 中，计算的结果等于在 numbers 中代表的所有元素之和，这个函数同时也会将这个结果返回。求和公式会一直计算更新结果直到这个公式被其他的值或者公式覆盖。
 * <p>
 * numbers 是若干字符串的集合，每个字符串代表单个位置或一个区间。如果这个字符串表示单个位置，它的格式如下：ColRow，例如 "F7" 表示位置 (7, F) 。如果这个字符串表示一个区间，它的格式如下：ColRow1:ColRow2。区间就是左上角为 ColRow1 右下角为 ColRow2 的长方形。
 * <p>
 *  
 * <p>
 * 样例 1 ：
 * <p>
 *  
 * <p>
 * Excel(3,"C");
 * // 构造一个 3*3 的二维数组，初始化全是 0。
 * //   A B C
 * // 1 0 0 0
 * // 2 0 0 0
 * // 3 0 0 0
 * <p>
 * Set(1, "A", 2);
 * // 设置 C(1,"A") 为 2。
 * //   A B C
 * // 1 2 0 0
 * // 2 0 0 0
 * // 3 0 0 0
 * <p>
 * Sum(3, "C", ["A1", "A1:B2"]);
 * // 将 C(3,"C") 的值设为 C(1,"A") 单点，左上角为 C(1,"A") 右下角为 C(2,"B") 的长方形，所有元素之和。返回值 4。
 * //   A B C
 * // 1 2 0 0
 * // 2 0 0 0
 * // 3 0 0 4
 * <p>
 * Set(2, "B", 2);
 * // 将 C(2,"B") 设为 2。 注意 C(3, "C") 的值也同时改变。
 * //   A B C
 * // 1 2 0 0
 * // 2 0 2 0
 * // 3 0 0 6
 *  
 * <p>
 * 注释 ：
 * <p>
 * 你可以认为不会出现循环求和的定义，比如说： A1 = sum(B1) ，B1 = sum(A1)。
 * 测试数据中，字母表示用双引号。
 * 请记住清零 Excel 类中的变量，因为静态变量、类变量会在多组测试数据中保存之前结果。详情请看这里。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-excel-sum-formula
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Excel {

    private Map<String, String[]> map;

    private int[][] m;

    public Excel(int h, char w) {
        map = new HashMap<>();
        m = new int[h][w - 'A' + 1];
    }

    public void set(int r, char c, int v) {
        String key = r + "#" + c;
        map.remove(key);
        m[r - 1][c - 'A'] = v;
    }

    public int get(int r, char c) {
        String key = r + "#" + c;
        if (map.containsKey(key)) {
            return sum(r, c, map.get(key));
        }
        return m[r - 1][c - 'A'];
    }

    public int sum(int r, char c, String[] strs) {
        int sum = 0;
        for (String str : strs) {
            int index = str.indexOf(":");
            if (index == -1) {
                sum += get(Integer.parseInt(str.substring(1)), str.charAt(0));
            } else {
                String a = str.substring(0, index);
                String b = str.substring(index + 1);
                int x1 = Integer.parseInt(a.substring(1)), y1 = a.charAt(0) - 'A';
                int x2 = Integer.parseInt(b.substring(1)), y2 = b.charAt(0) - 'A';
                for (int i = x1; i <= x2; ++i) {
                    for (int j = y1; j <= y2; ++j) {
                        sum += get(i, (char) (j + 'A'));
                    }
                }
            }
        }
        map.put(r + "#" + c, strs);
        return sum;
    }

    public static void main(String[] args) {
        //["Excel","sum","set","sum","get"]
        //[[3,"C"],[1,"A",["A2"]],[2,"A",1],[3,"A",["A1"]],[1,"A"]]

        //[null,0,null,0,1]
        //[null,0,null,1,1]
        Excel excel = new Excel(3, 'C');
        System.out.println("[sum1]" + excel.sum(1, 'A', new String[]{"A2"}));
        excel.set(2, 'A', 1);
        System.out.println("[sum2]" + excel.sum(3, 'A', new String[]{"A1"}));

        System.out.println("[get]" + excel.get(1, 'A'));

    }
}
