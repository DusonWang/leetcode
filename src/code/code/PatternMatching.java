package code.code;

import java.util.Objects;

/**
 * ���������ַ�������pattern��value�� pattern�ַ�������ĸ"a"��"b"��ɣ����������ַ����е�ģʽ�����磬�ַ���"catcatgocatgo"ƥ��ģʽ"aabab"������"cat"��"a"��"go"��"b"�������ַ���Ҳƥ����"a"��"ab"��"b"������ģʽ������ע��"a"��"b"����ͬʱ��ʾ��ͬ���ַ�������дһ�������ж�value�ַ����Ƿ�ƥ��pattern�ַ�����
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺 pattern = "abba", value = "dogcatcatdog"
 * ����� true
 * ʾ�� 2��
 * <p>
 * ���룺 pattern = "abba", value = "dogcatcatfish"
 * ����� false
 * ʾ�� 3��
 * <p>
 * ���룺 pattern = "aaaa", value = "dogcatcatdog"
 * ����� false
 * ʾ�� 4��
 * <p>
 * ���룺 pattern = "abba", value = "dogdogdogdog"
 * ����� true
 * ���ͣ� "a"="dogdog",b=""����֮Ҳ���Ϲ���
 * ��ʾ��
 * <p>
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * ����Լ���patternֻ������ĸ"a"��"b"��value������Сд��ĸ��
 * ͨ������740�ύ����2,887
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/pattern-matching-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class PatternMatching {

    public boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        int sizeA = 0;
        int sizeB = 0;
        char[] pc = pattern.toCharArray();
        for (char c : pc) {
            if (c == 'a') {
                sizeA++;
            } else {
                sizeB++;
            }
        }
        if (value.length() == 0) {
            return sizeA == 0 || sizeB == 0;
        }
        if (sizeA == 0) {
            return value.length() % sizeB == 0 && isValid(value, pc, 0, value.length() / sizeB);
        }
        if (sizeB == 0) {
            return value.length() % sizeA == 0 && isValid(value, pc, value.length() / sizeA, 0);
        }
        int maxLengthA = value.length() / sizeA;
        for (int i = 0; i <= maxLengthA; i++) {
            boolean canUse = (value.length() - sizeA * i) % sizeB == 0;
            if (!canUse) {
                continue;
            }
            int lb = (value.length() - sizeA * i) / sizeB;
            if (isValid(value, pc, i, lb)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(String value, char[] p, int la, int lb) {
        String subA = null;
        String subB = null;
        int pointer = 0;
        for (char c : p) {
            boolean isA = c == 'a';
            int le = isA ? la : lb;
            if (pointer + le > value.length()) {
                return false;
            }
            String v = value.substring(pointer, pointer + le);
            subA = isA && subA == null ? v : subA;
            subB = !isA && subB == null ? v : subB;
            if (Objects.equals(subA, subB)) {
                return false;
            }
            String sub = isA ? subA : subB;
            if (!v.equals(sub)) {
                return false;
            }
            pointer = pointer + le;
        }
        return true;
    }
}
