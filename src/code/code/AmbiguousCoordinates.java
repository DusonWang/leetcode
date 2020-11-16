package code.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author duson
 * ������һЩ��ά���꣬��?"(1, 3)"?��?"(2, 0.5)"��Ȼ�������Ƴ����ж��ţ�С����Ϳո񣬵õ�һ���ַ���S���������п��ܵ�ԭʼ�ַ�����һ���б��С�
 * <p>
 * ԭʼ�������ʾ��������ڶ�����㣬���Բ������������"00", "0.0", "0.00", "1.0", "001", "00.01"��һЩ������С��������ʾ���ꡣ���⣬һ��С����ǰ���ٴ���һ����������Ҳ������֡�.1����ʽ�����֡�
 * <p>
 * ��󷵻ص��б����������˳��ġ�����ע�ⷵ�ص����������м䣨����֮�󣩶���һ���ո�
 * <p>
 * ?
 * <p>
 * ʾ�� 1:
 * ����: "(123)"
 * ���: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * ʾ�� 2:
 * ����: "(00011)"
 * ���: ?["(0.001, 1)", "(0, 0.011)"]
 * ����:
 * 0.0, 00, 0001 �� 00.01 �ǲ�������ġ�
 * ʾ�� 3:
 * ����: "(0123)"
 * ���: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * ʾ�� 4:
 * ����: "(100)"
 * ���: [(10, 0)]
 * ����:
 * 1.0 �ǲ�������ġ�
 * ?
 * <p>
 * ��ʾ:
 * <p>
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", ���ַ���?S?�е�����Ԫ�ض������֡�
 * ?
 * <p>
 * ͨ������1,324�ύ����2,717
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/ambiguous-coordinates
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class AmbiguousCoordinates {

    private List<String> sub(String s) {
        if (s.length() == 1) {
            return Collections.singletonList(s);
        }
        List<String> ans = new ArrayList<>();
        if (s.charAt(0) != '0') {
            ans.add(s);
            for (int i = 1; i < s.length() && !s.endsWith("0"); i++) {
                ans.add(s.substring(0, i) + "." + s.substring(i));
            }
        } else if (!s.endsWith("0")) {
            ans.add(s.substring(0, 1) + "." + s.substring(1));
        }
        return ans;
    }

    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            List<String> left = sub(s.substring(1, i));
            List<String> right = sub(s.substring(i, s.length() - 1));
            if (!left.isEmpty() && !right.isEmpty()) {
                for (String l : left) {
                    for (String r : right) {
                        ans.add("(" + l + ", " + r + ")");
                    }
                }
            }
        }
        return ans;
    }
}
