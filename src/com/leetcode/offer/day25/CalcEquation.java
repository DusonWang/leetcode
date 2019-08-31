package com.leetcode.offer.day25;

import java.util.*;

/**
 * @author duson
 * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 * <p>
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * <p>
 * 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
 * <p>
 * 基于上述例子，输入如下：
 * <p>
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CalcEquation {

//    private HashMap<String, Integer> map;
//
//    private int[] parent;
//
//    private double[] val;
//
//    private int find(int x) {
//        if (x == parent[x]) {
//            return x;
//        }
//        int k = parent[x];
//        parent[x] = find(parent[x]);
//        val[x] = val[x] * val[k];
//        return parent[x];
//    }
//
//    private void union(int x, int y, double k) {
//        int px = find(x);
//        int py = find(y);
//        if (px == py) {
//            return;
//        }
//        parent[py] = px;
//        val[py] = k * val[x] / val[y];
//    }
//
//    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        map = new HashMap<>();
//        int totalNum = 0;
//
//        for (List<String> list : equations) {
//            String xs = list.get(0);
//            String ys = list.get(1);
//            if (!map.containsKey(xs)) {
//                map.put(xs, totalNum);
//                totalNum += 1;
//            }
//            if (!map.containsKey(ys)) {
//                map.put(ys, totalNum);
//                totalNum += 1;
//            }
//        }
//
//        parent = new int[totalNum];
//        val = new double[totalNum];
//
//        for (int i = 0; i < totalNum; i += 1) {
//            parent[i] = i;
//            val[i] = 1;
//        }
//
//        int index = -1;
//        for (List<String> list : equations) {
//            index += 1;
//            String xs = list.get(0);
//            String ys = list.get(1);
//            int x = map.get(xs);
//            int y = map.get(ys);
//            double k = values[index];
//            union(x, y, k);
//
//        }
//
//        double[] result = new double[queries.size()];
//
//        index = -1;
//
//        for (List<String> list : queries) {
//            index++;
//            String xs = list.get(0);
//            String ys = list.get(1);
//            if (!map.containsKey(xs) || !map.containsKey(ys)) {
//                result[index] = -1;
//                continue;
//            }
//
//            int x = map.get(xs);
//            int y = map.get(ys);
//            int px = find(x);
//            int py = find(y);
//
//            if (px != py) {
//                result[index] = -1;
//            } else {
//                result[index] = val[y] / val[x];
//            }
//        }
//
//        return result;
//    }

    private Map<String, List<String>> divisionRelations = new HashMap<>();
    private Map<String, Double> equationsResult = new HashMap<>();

    public double dfs(HashSet<String> visited, String a, String b) {
        double result = -1;
        visited.add(a);
        if (!divisionRelations.containsKey(a)) {
            visited.remove(a);
            return result;
        }
        List<String> list = divisionRelations.get(a);
        for (String tmp : list) {
            if (tmp.equals(b)) {
                result = equationsResult.get(a + "%" + tmp);
                break;
            } else if (!visited.contains(tmp)) {
                double midResult = dfs(visited, tmp, b);
                if (midResult != -1) {
                    result = equationsResult.get(a + "%" + tmp) * midResult;
                    break;
                }

            }
        }
        visited.remove(a);
        return result;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!divisionRelations.containsKey(a)) {
                divisionRelations.put(a, new ArrayList<>());
            }
            if (!divisionRelations.containsKey(b)) {
                divisionRelations.put(b, new ArrayList<>());
            }
            divisionRelations.get(a).add(b);
            equationsResult.put(a + "%" + b, values[i]);
            if (values[i] != 0) {
                divisionRelations.get(b).add(a);
                equationsResult.put(b + "%" + a, 1.0 / values[i]);
            }
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(new HashSet<>(), queries.get(i).get(0), queries.get(i).get(1));
        }
        return result;
    }

    public static void main(String[] args) {
        CalcEquation calcEquation = new CalcEquation();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("b", "c")));

        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("b", "a")));
        queries.add(new ArrayList<>(Arrays.asList("a", "a")));
        queries.add(new ArrayList<>(Arrays.asList("x", "x")));


        System.out.println(Arrays.toString(calcEquation.calcEquation(equations, values, queries)));
    }
}
