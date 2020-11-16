package code.code;

import java.util.*;

/**
 * ����һ�����ʽ?expression?��?expression = "e + 8 - a + 5"?��һ����ֵӳ�䣬��?{"e": 1}����������ʽΪ?evalvars = ["e"] ��?evalints = [1]�������ر�ʾ�򻯱��ʽ�ı���б����� ["-1*a","14"]
 * <p>
 * ���ʽ����ʹ�ÿ�ͷ��ţ�ÿ����ͷ���֮����һ���ո�
 * ��Ҫô�������еı��ʽ��Ҫô�Ǳ�����Ҫô�ǷǸ�������
 * ���������еı��ʽ��������Ǹ�������
 * ������һ����Сд��ĸ��ɵ��ַ��������������֣�����ע�⣬���������Ƕ����ĸ����ע������Ӳ�������?"2x"?��?"-x"?������ǰ��ϵ����һԪ�����?��
 * ���ʽ��ͨ��˳�������ֵ���������ţ�Ȼ����˷����ټ���ӷ��ͼ��������磬expression = "1 + 2 * 3"?�Ĵ��� ["7"]��
 * <p>
 * �����ʽ���£�
 * <p>
 * ����ϵ�������ÿ���Ա�������ǰ��ֵ������˳���Ա���д��һ�����С����磬������Զ����д�� ��b*a*c�� �������ֻд ��a*b*c����
 * ��Ĵ������ڱ��˵��Ա�������Ŀ���������ظ��(���磬"a*a*b*c" �Ĵ���Ϊ 4��)��������д���𰸵�����������ֵ�˳����ƹ�ϵ����ʱ���Դʵ�ǰ��ϵ����
 * ���ǰ��ϵ��ֱ�ӷ�����ߣ����ǺŽ���������ָ���(������ڵĻ�)��ǰ��ϵ�� 1 ��ȻҪ��ӡ������
 * ��ʽ���õ�һ��ʾ������?["-2*a*a*a", "3*a*a*b", "3*b*b", "4*a", "5*c", "-6"]?��
 * ϵ��Ϊ 0 ���������������������ڡ����磬��0�� �ı��ʽ���Ϊ []��
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺expression = "e + 8 - a + 5", evalvars = ["e"], evalints = [1]
 * �����["-1*a","14"]
 * <p>
 * ���룺expression = "e - 8 + temperature - pressure",
 * evalvars = ["e", "temperature"], evalints = [1, 12]
 * �����["-1*pressure","5"]
 * <p>
 * ���룺expression = "(e + 8) * (e - 8)", evalvars = [], evalints = []
 * �����["1*e*e","-64"]
 * <p>
 * ���룺expression = "7 - 7", evalvars = [], evalints = []
 * �����[]
 * <p>
 * ���룺expression = "a * b * c + b * a * c * 4", evalvars = [], evalints = []
 * �����["5*a*b*c"]
 * <p>
 * ���룺expression = "((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))",
 * evalvars = [], evalints = []
 * �����["-1*a*a*b*b","2*a*a*b*c","-1*a*a*c*c","1*a*b*b*b","-1*a*b*b*c","-1*a*b*c*c","1*a*c*c*c","-1*b*b*b*c","2*b*b*c*c","-1*b*c*c*c","2*a*a*b","-2*a*a*c","-2*a*b*b","2*a*c*c","1*b*b*b","-1*b*b*c","1*b*c*c","-1*c*c*c","-1*a*a","1*a*b","1*a*c","-1*b*c"]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * expression �ĳ�����?[1, 250]?��Χ�ڡ�
 * evalvars, evalints �ڷ�Χ?[0, 100]?�ڣ��ҳ�����ͬ��
 * ͨ������334�ύ����691
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/basic-calculator-iv
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
