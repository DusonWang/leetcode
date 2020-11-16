package code.code;

import java.util.*;

/**
 * 给定一个表达式?expression?如?expression = "e + 8 - a + 5"?和一个求值映射，如?{"e": 1}（给定的形式为?evalvars = ["e"] 和?evalints = [1]），返回表示简化表达式的标记列表，例如 ["-1*a","14"]
 * <p>
 * 表达式交替使用块和符号，每个块和符号之间有一个空格。
 * 块要么是括号中的表达式，要么是变量，要么是非负整数。
 * 块是括号中的表达式，变量或非负整数。
 * 变量是一个由小写字母组成的字符串（不包括数字）。请注意，变量可以是多个字母，并注意变量从不具有像?"2x"?或?"-x"?这样的前导系数或一元运算符?。
 * 表达式按通常顺序进行求值：先是括号，然后求乘法，再计算加法和减法。例如，expression = "1 + 2 * 3"?的答案是 ["7"]。
 * <p>
 * 输出格式如下：
 * <p>
 * 对于系数非零的每个自变量项，我们按字典排序的顺序将自变量写在一个项中。例如，我们永远不会写像 “b*a*c” 这样的项，只写 “a*b*c”。
 * 项的次数等于被乘的自变量的数目，并计算重复项。(例如，"a*a*b*c" 的次数为 4。)。我们先写出答案的最大次数项，用字典顺序打破关系，此时忽略词的前导系数。
 * 项的前导系数直接放在左边，用星号将它与变量分隔开(如果存在的话)。前导系数 1 仍然要打印出来。
 * 格式良好的一个示例答案是?["-2*a*a*a", "3*a*a*b", "3*b*b", "4*a", "5*c", "-6"]?。
 * 系数为 0 的项（包括常数项）不包括在内。例如，“0” 的表达式输出为 []。
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：expression = "e + 8 - a + 5", evalvars = ["e"], evalints = [1]
 * 输出：["-1*a","14"]
 * <p>
 * 输入：expression = "e - 8 + temperature - pressure",
 * evalvars = ["e", "temperature"], evalints = [1, 12]
 * 输出：["-1*pressure","5"]
 * <p>
 * 输入：expression = "(e + 8) * (e - 8)", evalvars = [], evalints = []
 * 输出：["1*e*e","-64"]
 * <p>
 * 输入：expression = "7 - 7", evalvars = [], evalints = []
 * 输出：[]
 * <p>
 * 输入：expression = "a * b * c + b * a * c * 4", evalvars = [], evalints = []
 * 输出：["5*a*b*c"]
 * <p>
 * 输入：expression = "((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))",
 * evalvars = [], evalints = []
 * 输出：["-1*a*a*b*b","2*a*a*b*c","-1*a*a*c*c","1*a*b*b*b","-1*a*b*b*c","-1*a*b*c*c","1*a*c*c*c","-1*b*b*b*c","2*b*b*c*c","-1*b*c*c*c","2*a*a*b","-2*a*a*c","-2*a*b*b","2*a*c*c","1*b*b*b","-1*b*b*c","1*b*c*c","-1*c*c*c","-1*a*a","1*a*b","1*a*c","-1*b*c"]
 * ?
 * <p>
 * 提示：
 * <p>
 * expression 的长度在?[1, 250]?范围内。
 * evalvars, evalints 在范围?[0, 100]?内，且长度相同。
 * 通过次数334提交次数691
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BasicCalculatorIV {

    public List<String> basicCalculatorIV(String expression, String[] evalVars, int[] evalInts) {
        Map<String, Integer> evalMap = new HashMap<>();
        for (int i = 0; i < evalVars.length; ++i) {
            evalMap.put(evalVars[i], evalInts[i]);
        }
        return parse(expression).evaluate(evalMap).toList();
    }

    public Poly make(String expr) {
        Poly ans = new Poly();
        List<String> list = new ArrayList<>();
        if (Character.isDigit(expr.charAt(0))) {
            ans.update(list, Integer.parseInt(expr));
        } else {
            list.add(expr);
            ans.update(list, 1);
        }
        return ans;
    }

    public Poly combine(Poly left, Poly right, char symbol) {
        if (symbol == '+') {
            return left.add(right);
        }
        if (symbol == '-') {
            return left.sub(right);
        }
        if (symbol == '*') {
            return left.mul(right);
        }
        return null;
    }

    public Poly parse(String expr) {
        List<Poly> bucket = new ArrayList<>();
        List<Character> symbols = new ArrayList<>();
        int i = 0;
        while (i < expr.length()) {
            if (expr.charAt(i) == '(') {
                int bal = 0, j = i;
                for (; j < expr.length(); ++j) {
                    if (expr.charAt(j) == '(') {
                        bal++;
                    }
                    if (expr.charAt(j) == ')') {
                        bal--;
                    }
                    if (bal == 0) {
                        break;
                    }
                }
                bucket.add(parse(expr.substring(i + 1, j)));
                i = j;
            } else if (Character.isLetterOrDigit(expr.charAt(i))) {
                int j = i;
                search:
                {
                    for (; j < expr.length(); ++j) {
                        if (expr.charAt(j) == ' ') {
                            bucket.add(make(expr.substring(i, j)));
                            break search;
                        }
                    }
                    bucket.add(make(expr.substring(i)));
                }
                i = j;
            } else if (expr.charAt(i) != ' ') {
                symbols.add(expr.charAt(i));
            }
            i++;
        }

        for (int j = symbols.size() - 1; j >= 0; --j) {
            if (symbols.get(j) == '*') {
                bucket.set(j, combine(bucket.get(j), bucket.remove(j + 1), symbols.remove(j)));
            }
        }

        if (bucket.isEmpty()) {
            return new Poly();
        }
        Poly ans = bucket.get(0);
        for (int j = 0; j < symbols.size(); ++j) {
            ans = combine(ans, bucket.get(j + 1), symbols.get(j));
        }

        return ans;
    }
}

class Poly {
    HashMap<List<String>, Integer> count;

    Poly() {
        count = new HashMap<>();
    }

    void update(List<String> key, int val) {
        this.count.put(key, this.count.getOrDefault(key, 0) + val);
    }

    Poly add(Poly that) {
        Poly ans = new Poly();
        for (List<String> k : this.count.keySet()) {
            ans.update(k, this.count.get(k));
        }
        for (List<String> k : that.count.keySet()) {
            ans.update(k, that.count.get(k));
        }
        return ans;
    }

    Poly sub(Poly that) {
        Poly ans = new Poly();
        for (List<String> k : this.count.keySet()) {
            ans.update(k, this.count.get(k));
        }
        for (List<String> k : that.count.keySet()) {
            ans.update(k, -that.count.get(k));
        }
        return ans;
    }

    Poly mul(Poly that) {
        Poly ans = new Poly();
        for (List<String> k1 : this.count.keySet()) {
            for (List<String> k2 : that.count.keySet()) {
                List<String> kNew = new ArrayList<>();
                kNew.addAll(k1);
                kNew.addAll(k2);
                Collections.sort(kNew);
                ans.update(kNew, this.count.get(k1) * that.count.get(k2));
            }
        }
        return ans;
    }

    Poly evaluate(Map<String, Integer> evalMap) {
        Poly ans = new Poly();
        for (List<String> k : this.count.keySet()) {
            int c = this.count.get(k);
            List<String> free = new ArrayList<>();
            for (String token : k) {
                if (evalMap.containsKey(token)) {
                    c *= evalMap.get(token);
                } else {
                    free.add(token);
                }
            }
            ans.update(free, c);
        }
        return ans;
    }

    int compareList(List<String> a, List<String> b) {
        int i = 0;
        for (String x : a) {
            String y = b.get(i++);
            if (x.compareTo(y) != 0) {
                return x.compareTo(y);
            }
        }
        return 0;
    }

    List<String> toList() {
        List<String> ans = new ArrayList<>();
        List<List<String>> keys = new ArrayList<>(this.count.keySet());
        keys.sort((a, b) ->
                a.size() != b.size() ? b.size() - a.size() : compareList(a, b));

        for (List<String> key : keys) {
            int v = this.count.get(key);
            if (v == 0) {
                continue;
            }
            StringBuilder word = new StringBuilder();
            word.append(v);
            for (String token : key) {
                word.append('*');
                word.append(token);
            }
            ans.add(word.toString());
        }
        return ans;
    }
}
