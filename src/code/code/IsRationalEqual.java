package code.code;

import java.util.Arrays;
import java.util.List;

/**
 * ���������ַ��� S �� T��ÿ���ַ�������һ���Ǹ���������ֻ�е����Ǳ�ʾ��ͬ������ʱ�ŷ��� true�����򣬷��� false���ַ����п���ʹ����������ʾ���������ظ����֡�
 * <p>
 * ͨ������������������������������ʾ����������?<IntegerPart>��С�����ظ�����?<NonRepeatingPart>?��С���ظ�����?<(><RepeatingPart><)>�����ֿ������������ַ���֮һ����ʾ��
 *
 * <IntegerPart>������0��12��123��
 * <IntegerPart><.><NonRepeatingPart> ������0.5��2.12��2.0001��
 * <IntegerPart><.><NonRepeatingPart><(><RepeatingPart><)>������0.1(6)��0.9(9)��0.00(1212)��
 * ʮ����չ�����ظ�����ͨ����һ��Բ�����ڱ�ʾ�����磺
 * <p>
 * 1 / 6 = 0.16666666... = 0.1(6) = 0.1666(6) = 0.166(66)
 * <p>
 * 0.1(6) ��?0.1666(6) ��?0.166(66) ����?1 / 6 ����ȷ��ʾ��ʽ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺S = "0.(52)", T = "0.5(25)"
 * �����true
 * ���ͣ���Ϊ "0.(52)" ���� 0.52525252...���� "0.5(25)" ���� 0.52525252525.....�����������ַ�����ʾ��ͬ�����֡�
 * ʾ�� 2��
 * <p>
 * ���룺S = "0.1666(6)", T = "0.166(66)"
 * �����true
 * ʾ�� 3��
 * <p>
 * ���룺S = "0.9(9)", T = "1."
 * �����true
 * ���ͣ�
 * "0.9(9)" ���� 0.999999999... ��Զ�ظ������� 1 ��[�й�˵��������Ĵ�����]
 * "1." ��ʾ���� 1�����ʽ��ȷ��(IntegerPart) = "1" �� (NonRepeatingPart) = "" ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * ÿ�����ֽ���������ɡ�
 * ��������?<IntegerPart>?������ 2 ���������㿪ͷ������ÿ�����ֵ�����û���������ƣ���
 * 1 <= <IntegerPart>.length <= 4
 * 0 <= <NonRepeatingPart>.length <= 4
 * 1 <= <RepeatingPart>.length <= 4
 * ͨ������1,135�ύ����2,821
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/equal-rational-numbers
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsRationalEqual {

    private final List<Double> ratios = Arrays.asList(1.0, 1.0 / 9, 1.0 / 99, 1.0 / 999, 1.0 / 9999);

    public boolean isRationalEqual(String s, String t) {
        return Math.abs(computeValue(s) - computeValue(t)) < 1e-9;
    }

    private double computeValue(String s) {
        if (!s.contains("(")) {
            return Double.parseDouble(s);
        }
        int leftBracket = s.indexOf('(');
        int rightBracket = s.indexOf(')');
        double intNonRepeatingValue = Double.parseDouble(s.substring(0, leftBracket));
        int nonRepeatingLength = leftBracket - s.indexOf('.') - 1;
        int repeatingLength = rightBracket - leftBracket - 1;
        int repeatingValue = Integer.parseInt(s.substring(leftBracket + 1, rightBracket));
        return intNonRepeatingValue + repeatingValue * Math.pow(0.1, nonRepeatingLength) * ratios.get(repeatingLength);
    }
}
